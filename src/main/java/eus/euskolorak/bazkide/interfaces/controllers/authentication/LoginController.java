package eus.euskolorak.bazkide.interfaces.controllers.authentication;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.List;

/**
 * @author BICUGUAL
 */
@Controller
public class LoginController {

    @GetMapping({"/", "/login"})
    public String login() {
        return "views/login";
    }

    @GetMapping("/home")
    public String home(Model model) {
        //return "views/home";
        model.addAttribute("menuItemsActive", List.of("home","interface"));
        return "views/dashboard";
    }
}
