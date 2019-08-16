package hello;

import static org.junit.Assert.*;

import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.security.crypto.password.PasswordEncoder;

import hello.Member;
import hello.UserMapper;
import hello.ApplicationTest;

public class UserTest extends ApplicationTest
{
    private static final Logger LOG = LoggerFactory.getLogger(UserTest.class);

    @Autowired
    UserMapper userMapper;

    @Autowired
    PasswordEncoder passwordEncoder;

    // @Test
    // public void UserTest1() throws Exception
    // {
    //     Member member = new Member();
    //     String name = "testUser";

    //     member.setUsername(name);
    //     member.setPassword(passwordEncoder.encode("password44"));
    //     member.setName("44aa");

    //     userMapper.insertUser(member);

    //     assertEquals(name, userMapper.readUser(name).getUsername());

    //     userMapper.deleteUser(userMapper.readUser(name).getId());
    // }
}
