package org.cedacri.spring.cedintlibra.controllers.pos;

import jakarta.validation.Valid;
import org.cedacri.spring.cedintlibra.dto_s.pos.PosCreateDto;
import org.cedacri.spring.cedintlibra.dto_s.pos.PosDetailedDto;
import org.cedacri.spring.cedintlibra.dto_s.pos.PosUpdateDto;
import org.cedacri.spring.cedintlibra.entity.util_models.WeekDays;
import org.cedacri.spring.cedintlibra.services.city.CityService;
import org.cedacri.spring.cedintlibra.services.connection_type.ConnectionTypeService;
import org.cedacri.spring.cedintlibra.services.pos.PosService;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.Set;

@Controller
public class PosPageController {

    private final PosService posService;
    private final Set<WeekDays> weekDaysSet;
    private final CityService cityService;
    private final ConnectionTypeService connectionTypeService;

    public PosPageController(
            PosService posService,
            Set<WeekDays> weekDaysSet,
            CityService cityService,
            ConnectionTypeService connectionTypeService
    ) {
        this.posService = posService;
        this.weekDaysSet = weekDaysSet;
        this.cityService = cityService;
        this.connectionTypeService = connectionTypeService;
    }

    @GetMapping("/libra/pos/all")
    public String showAllPoses(Model model){
        UserDetails userDetails = getUserData();
        model.addAttribute("allPos", posService.findAll());
        model.addAttribute("userLogin", userDetails.getUsername());
        return "/pos/allPos";
    }
    @GetMapping("/libra/pos/create")
    public String showCreateForm(Model model) {
        model.addAttribute("form", new PosCreateDto());
        model.addAttribute("weekDays", weekDaysSet);
        model.addAttribute("cities", cityService.getAll());
        model.addAttribute("connectionTypes", connectionTypeService.getAll());
        UserDetails userDetails = getUserData();
        model.addAttribute("userLogin", userDetails.getUsername());
        return "pos/create-pos";
    }
    @GetMapping("/libra/pos/detailed/{id}")
    public String showDetailedPosFPage(Model model, @PathVariable("id") Long id){
        UserDetails userDetails = getUserData();
        model.addAttribute("pos", posService.getFullPosData(id));
        model.addAttribute("cities", cityService.getAll());
        model.addAttribute("connectionTypes", connectionTypeService.getAll());
        model.addAttribute("posIssues", posService.findAllByIssuesByPosId(id));
        model.addAttribute("userLogin", userDetails.getUsername());
        return "pos/pos-details-page";
    }


    @PostMapping("/libra/pos/create")
    public String createPos(
            @Valid @ModelAttribute("form") PosCreateDto form,
            BindingResult bindingResult,
            Model model
    ) {
        if (bindingResult.hasErrors()) {
            fillDictionaries(model);
            return "pos/create-pos";
        }
        posService.createPos(form);
        return "pos/allPos";
    }

    @PostMapping("/libra/pos/update/{id}")
    public String updatePos(@PathVariable("id") Long posId, @ModelAttribute("pos")PosUpdateDto posUpdateDto){
        posService.updatePos(posId, posUpdateDto);
        return "redirect:/libra/pos/all";
    }

    private void fillDictionaries(Model model) {
        model.addAttribute("weekDays", weekDaysSet);
        model.addAttribute("cities", cityService.getAll());
        model.addAttribute("connectionTypes", connectionTypeService.getAll());
    }

    private UserDetails getUserData(){
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        return (UserDetails) authentication.getPrincipal();
    }
}
