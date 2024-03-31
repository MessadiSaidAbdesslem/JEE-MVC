package mybootapp.web;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

@Controller()
@RequestMapping("/simple-user")
@SessionAttributes("simpleUser")
public class SimpleUserController {


    @ModelAttribute("simpleUser")
    public SimpleUser newUser() {
        var user = new SimpleUser();
        return user;
    }

    @GetMapping("/show")
    public String show(@ModelAttribute("simpleUser") SimpleUser user) {
        return "simple-user";
    }

    @GetMapping("/login")
    public String login(//
                        @ModelAttribute("simpleUser") SimpleUser user, //
                        RedirectAttributes attributes) {
        user.setName("It's me");
        attributes.addFlashAttribute("message", "Bienvenue !");
        return "redirect:show";
    }

    @GetMapping("/logout")
    public String logout(//
                         @ModelAttribute("simpleUser") SimpleUser user, //
                         RedirectAttributes attributes) {
        user.setName("Anonymous");
        attributes.addFlashAttribute("message", "Au revoir.");
        return "redirect:show";
    }
}