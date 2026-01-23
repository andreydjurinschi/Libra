package org.cedacri.spring.cedintlibra.controllers.user;

import jakarta.validation.Valid;
import org.cedacri.spring.cedintlibra.dto_s.user.UserBaseDto;
import org.cedacri.spring.cedintlibra.dto_s.user.UserCreateDto;
import org.cedacri.spring.cedintlibra.dto_s.user.UserUpdateDto;
import org.cedacri.spring.cedintlibra.dto_s.user.UserWithTypeDto;
import org.cedacri.spring.cedintlibra.services.user.UserService;
import org.cedacri.spring.cedintlibra.services.user_type.UserTypeService;
import org.springframework.security.config.annotation.SecurityConfigurer;
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
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.util.List;

@Controller
@RequestMapping("/libra/users")
public class UserPageController {

    private final UserService userService;
    private final UserTypeService userTypeService;

    public UserPageController(UserService userService, UserTypeService userTypeService) {
        this.userService = userService;
        this.userTypeService = userTypeService;
    }

    @GetMapping("/all")
    public String getAllUsers(Model model){
        List<UserBaseDto> users = userService.getAllUsers();
        model.addAttribute("title", "Users Manager");
        model.addAttribute("userList", users);
        return "users/all-users";
    }

    @GetMapping("/create")
    public String showCreateForm(Model model) {
        if (!model.containsAttribute("form")) {
            model.addAttribute("form", new UserCreateDto());
        }
        UserDetails userDetails = getUserData();
        model.addAttribute("userLogin", userDetails.getUsername());
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

    @GetMapping("/detailed/{id}")
    public String showDetailedUserPage(@PathVariable("id") Long id, Model model) {
        UserWithTypeDto userBaseDto = userService.getUserWithType(id);
        model.addAttribute("user", userBaseDto);
        model.addAttribute("userTypes", userTypeService.getAll());
        return "users/user-details";
    }

    @PostMapping("/update/{id}")
    public String updateUser(@PathVariable("id") Long id, @ModelAttribute("user") UserUpdateDto form) {
        userService.updateUser(id, form);
        return "redirect:/libra/users/all";
    }
    private UserDetails getUserData(){
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        return (UserDetails) authentication.getPrincipal();
    }
}
