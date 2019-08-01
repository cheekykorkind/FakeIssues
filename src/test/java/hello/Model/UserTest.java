package hello;

import static org.junit.Assert.*;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.Before;
import org.junit.After;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.test.context.TestPropertySource;

import hello.Member;
import hello.UserMapper;
import hello.Migration;

// test시 사용할 properties파일을 선택한다
@TestPropertySource(locations ="classpath:/application-test.properties")
@RunWith(SpringRunner.class)
@SpringBootTest
public class UserTest
{
    private static final Logger LOG = LoggerFactory.getLogger(UserTest.class);

    @Autowired
    private Migration migration;

    @Autowired
    UserMapper userMapper;

    @Autowired
    PasswordEncoder passwordEncoder;

    @Before
    public void setup()
    {
        migration.testUp();
    }

    @Test
    public void UserTest1() throws Exception
    {
        Member member = new Member();
        String name = "testUser";

        member.setUsername(name);
        member.setPassword(passwordEncoder.encode("password44"));
        member.setName("44aa");

        userMapper.insertUser(member);

        assertEquals(name, userMapper.readUser(name).getUsername());

        userMapper.deleteUser(userMapper.readUser(name).getId());
    }

    @After
    public void tearDown()
    {
        migration.testClean();
    }
}
