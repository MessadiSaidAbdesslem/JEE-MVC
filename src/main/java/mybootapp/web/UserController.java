package mybootapp.web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/user")
public class UserController {

    @Autowired
    User user;

    @ModelAttribute("user")
    public User newUser() {
        return user;
    }

    @GetMapping("")
    public String show() {
        return "user";
    }

    @GetMapping("/login")
    public String login() {
        user.setName("It's me");
        return "user";
    }

    @GetMapping("/logout")
    public String logout() {
        user.setName("Anonymous");
        return "user";
    }
}