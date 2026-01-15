package org.cedacri.spring.cedintlibra.controllers.user;

import jakarta.validation.Valid;
import org.cedacri.spring.cedintlibra.dto_s.user.UserCreateDto;
import org.cedacri.spring.cedintlibra.services.user.UserService;
import org.cedacri.spring.cedintlibra.services.user_type.UserTypeService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

@Controller
@RequestMapping("/libra/users")
public class UserPageController {

    private final UserService userService;
    private final UserTypeService userTypeService;

    public UserPageController(UserService userService, UserTypeService userTypeService) {
        this.userService = userService;
        this.userTypeService = userTypeService;
    }

    @GetMapping("/create")
    public String showCreateForm(Model model) {
        if (!model.containsAttribute("form")) {
            model.addAttribute("form", new UserCreateDto());
        }
        model.addAttribute("userTypes", userTypeService.getAll());
        return "users/create-user";
    }

    @PostMapping("/create")
    public String handleCreate(
            @Valid @ModelAttribute("form") UserCreateDto form,
            BindingResult bindingResult,
            Model model,
            RedirectAttributes ra
    ) {
        if (bindingResult.hasErrors()) {
            model.addAttribute("userTypes", userTypeService.getAll());
            return "users/create-user";
        }

        userService.createUser(form);
        ra.addFlashAttribute("successMessage", "User created successfully.");
        return "redirect:/libra/users/create";
    }
}
