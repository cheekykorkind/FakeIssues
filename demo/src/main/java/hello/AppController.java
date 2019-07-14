package hello;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.stereotype.Controller;

import hello.UserMapper;
import hello.Member;

@Controller
public class AppController {
    @RequestMapping("/home")
    public String index2() {
        return "home";
    }

    @RequestMapping("/login")
    public String login() {
        return "login";
    }
}
