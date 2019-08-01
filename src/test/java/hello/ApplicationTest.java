package hello;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
import static org.junit.Assert.*;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.context.ActiveProfiles;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.test.context.TestPropertySource;

import hello.Member;
import hello.UserMapper;

// test시 사용할 properties파일을 선택한다
@TestPropertySource(locations ="classpath:/application-logging-test.properties")
@RunWith(SpringRunner.class)
@SpringBootTest
@AutoConfigureMockMvc
public class ApplicationTest {

    private static final Logger LOG = LoggerFactory.getLogger(ApplicationTest.class);

    @Autowired
    UserMapper userMapper;

    @Autowired
    PasswordEncoder passwordEncoder;

    @Autowired
    private MockMvc mockMvc;

    @Test
    public void shouldReturnDefaultMessage() throws Exception {
        this.mockMvc.perform(get("/login")).andDo(print()).andExpect(status().isOk());
    }

    @Test
    public void dbTest1() throws Exception {
        Member member = new Member();
        member.setUsername("user44");
        member.setPassword(passwordEncoder.encode("password44"));
        member.setName("44aa");

        userMapper.insertUser(member);

        assertEquals("user44", userMapper.readUser("user44").getUsername());

        userMapper.deleteUser(userMapper.readUser("user44").getId());
    }
}
