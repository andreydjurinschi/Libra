package org.cedacri.spring.cedintlibra.controllers.home;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class HomeController {

    //TODO: print username in userLogin attribute after authentification logic / logout logic
    @GetMapping("/home")
    public String homePage(Model model){
        model.addAttribute("title", "Libra Dashboard");
        model.addAttribute("userLogin", "Temporar_Login123");
        model.addAttribute("logout", "Logout");
        return "home";
    }
}
