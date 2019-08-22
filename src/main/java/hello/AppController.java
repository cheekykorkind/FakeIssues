package hello;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.validation.BindingResult;
import org.springframework.ui.Model;
import org.springframework.security.core.context.SecurityContextHolder;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import hello.SecurityMember;
import hello.UserMapper;
import hello.Member;
import hello.MemberRequest;
import hello.RepositoriesRequest;
import hello.RepositoriesMapper;
import hello.Repositories;

@Controller
public class AppController {
    private static final Logger LOG = LoggerFactory.getLogger(AppController.class);

    @Autowired
    RepositoriesMapper repositoryMapper;

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
        SecurityMember principal = (SecurityMember) SecurityContextHolder.getContext().getAuthentication().getPrincipal();

        System.out.println(principal.getId());

        return "User/add";
    }

    @PostMapping("/user/create")
    public String create(@Valid MemberRequest memberRequest, BindingResult bindingResult, Model m) {
        if (bindingResult.hasErrors()) {
            m.addAttribute("v", bindingResult);

            return "User/add";
        }

        return "redirect:/home";
    }

    @GetMapping("/repository/add")
    public String repositoryAdd() {
        return "Repositories/add";
    }

    @PostMapping("/repository/create")
    public String repositoryCreate(@Valid RepositoriesRequest repositoryRequest, BindingResult bindingResult, Model m) {
        if (bindingResult.hasErrors()) {
            m.addAttribute("v", bindingResult);

            return "Repositories/add";
        }

        Repositories repository = new Repositories();
        repository.setName(repositoryRequest.getName());
        repository.setDescription(repositoryRequest.getDescription());
        repository.setType(repositoryRequest.getType());

        repositoryMapper.create(repository);

        return "redirect:/home";
    }
}
