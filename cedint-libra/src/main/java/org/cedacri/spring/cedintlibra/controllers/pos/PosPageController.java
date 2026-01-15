package org.cedacri.spring.cedintlibra.controllers.pos;

import org.cedacri.spring.cedintlibra.services.pos.PosService;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class PosPageController {
    private final PosService posService;


    public PosPageController(PosService posService) {
        this.posService = posService;
    }

    @GetMapping("/libra/pos")
    public String posPage(Model model){
        model.addAttribute("title", "POS MANAGER");
        model.addAttribute("userLogin", getUserData().getUsername());
        model.addAttribute("allPos", posService.findAll());
        return "allPos";
    }

    private UserDetails getUserData(){
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        return (UserDetails) authentication.getPrincipal();
    }
}
