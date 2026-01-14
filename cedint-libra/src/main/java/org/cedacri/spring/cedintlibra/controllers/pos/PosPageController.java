package org.cedacri.spring.cedintlibra.controllers.pos;

import org.cedacri.spring.cedintlibra.services.pos.PosService;
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
        model.addAttribute("allPos", posService.findAll());
        return "allPos";
    }
}
