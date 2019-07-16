package hello;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.GetMapping;



import hello.UserMapper;
import hello.Member;
import hello.MemberRequest;


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

    @GetMapping("/user/add")
    public String add() {
        return "User/add";
    }

    @PostMapping("/user/create")
    public String create(MemberRequest memberRequest) {
        System.out.println("================================================");
        System.out.println(memberRequest.getUsername());
        System.out.println("================================================");
        System.out.println(memberRequest.getPassword());

        return "redirect:/home";
    }
}
