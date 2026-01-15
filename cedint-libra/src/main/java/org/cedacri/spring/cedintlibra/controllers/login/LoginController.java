package org.cedacri.spring.cedintlibra.controllers.login;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class LoginController {
    @GetMapping("/libra/login")
    public String login(Model model){
        model.addAttribute("anonymous", "anonymous");
        return "login";
    }
}
