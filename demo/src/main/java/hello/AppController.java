package hello;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.stereotype.Controller;

import hello.UserMapper;

@Controller
public class AppController {
    // @Autowired
    // private UserMapper userMapper;

    @RequestMapping("/")
    public String root() {
        return "root";
    }

    @RequestMapping("/index")
    public String index() {
        // Member user1 = userMapper.findById(1);
        return "index";
    }

    @RequestMapping("/index2")
    public String index2() {
        return "index2";
    }
    

    @RequestMapping("/login")
    public String login() {
        return "login";
    }
}