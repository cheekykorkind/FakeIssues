package hello;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.stereotype.Controller;

import hello.UserMapper;
import hello.Member;

@Controller
public class AppController {
    @RequestMapping("/")
    public String root() {
        return "root";
    }

    @RequestMapping("/index")
    public String index() {
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