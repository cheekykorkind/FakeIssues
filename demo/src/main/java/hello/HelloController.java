package hello;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import hello.UserMapper;


@RestController
public class HelloController {
    @Autowired
    private UserMapper userMapper;


    @RequestMapping("/")
    public String index() {
        return "Greetings from Spring Boot!";
    }

    @RequestMapping("/account_detail")
    public String accountDetail() {
        Member user1 = userMapper.findById(1);
        
        return user1.getName();
    }

    @RequestMapping("/login")
    public String login() {
        return "my login";
    }
    
}