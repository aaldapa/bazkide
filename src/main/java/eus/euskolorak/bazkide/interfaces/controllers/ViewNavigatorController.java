package eus.euskolorak.bazkide.interfaces.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.List;

/**
 * @author BICUGUAL
 */
@Controller
public class ViewNavigatorController {

    @GetMapping("/admin/access")
    public String adminAccess(Model model) {
        model.addAttribute("menuItemsActive", List.of("admin", "access"));
        return "views/admin/access";
    }
}
