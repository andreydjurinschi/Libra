package org.cedacri.spring.cedintlibra.controllers.issue;

import org.cedacri.spring.cedintlibra.dto_s.issue.IssueBaseDto;
import org.cedacri.spring.cedintlibra.dto_s.issue.IssueUpdateDto;
import org.cedacri.spring.cedintlibra.dto_s.pos.PosBaseDto;
import org.cedacri.spring.cedintlibra.entity.util_models.GeneralType;
import org.cedacri.spring.cedintlibra.services.issue.IssueService;
import org.cedacri.spring.cedintlibra.services.issue_type.IssueTypeService;
import org.cedacri.spring.cedintlibra.services.pos.PosService;
import org.cedacri.spring.cedintlibra.services.status.StatusService;
import org.cedacri.spring.cedintlibra.services.user.UserService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;
import jakarta.validation.Valid;
import org.cedacri.spring.cedintlibra.dto_s.issue.IssueCreateDto;
import org.cedacri.spring.cedintlibra.entity.User;
import org.cedacri.spring.cedintlibra.repositories.UserRepository;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.validation.BindingResult;

import java.time.LocalDate;


import java.util.List;

@Controller
public class IssuePageController {
    private final IssueService issueService;
    private final PosService posService;
    private final IssueTypeService issueTypeService;
    private final StatusService statusService;
    private final UserService userService;
    private final UserRepository userRepository;

    public IssuePageController(IssueService issueService, PosService posService,
                               IssueTypeService issueTypeService, StatusService statusService,
                               UserService userService,
                               UserRepository userRepository) {
        this.issueService = issueService;
        this.posService = posService;
        this.issueTypeService = issueTypeService;
        this.statusService = statusService;
        this.userService = userService;
        this.userRepository = userRepository;
    }

    @GetMapping("libra/issues/detailed/{id}")
    public String showDetailedPage(Model model, @PathVariable("id") Long id){
        IssueBaseDto issueBaseDto = issueService.getById(id);
        PosBaseDto posBaseDto = posService.findById(issueBaseDto.getPosId());
        model.addAttribute("id", id);
        model.addAttribute("issue", issueBaseDto);
        model.addAttribute("pos", posBaseDto);
        return "issue/issue-details-page";
    }


    @GetMapping("/libra/issues/create")
    public String showCreateIssueForm(Model model) {

        IssueCreateDto form = new IssueCreateDto();

        // required by validations
        form.setCreationDate(LocalDate.now());
        form.setModifyDate(LocalDate.now());

        // REQUIRED by IssueService.create()
        UserDetails userDetails = getCurrentUser();
        User currentUser = userRepository.findByLoginWithType(userDetails.getUsername());
        if (currentUser == null) {
            throw new IllegalStateException(
                    "Logged-in user not found in DB. login=" + userDetails.getUsername()
            );
        }

        form.setUserCreatedId(currentUser.getId());

        model.addAttribute("form", form);

        // dropdowns / lists (same as detailed page)
        populateCreateIssueModel(model);

        return "issue/create-issue";
    }

    @PostMapping("/libra/issues/create")
    public String createIssue(
            @Valid @ModelAttribute("form") IssueCreateDto form,
            BindingResult bindingResult,
            Model model,
            RedirectAttributes ra
    ) {
        if (bindingResult.hasErrors()) {
            populateCreateIssueModel(model);
            return "issue/create-issue";
        }

        issueService.create(form);
        ra.addFlashAttribute("success", "Issue created successfully");
        return "redirect:/libra/home";
    }

    private void populateCreateIssueModel(Model model) {
        model.addAttribute("generalTypes", GeneralType.values());
        model.addAttribute("types", issueTypeService.getAll());
        model.addAttribute("statuses", statusService.getAll());
        model.addAttribute("users", userService.getAllUsers());
        model.addAttribute("positions", posService.findAll());
        model.addAttribute("priorities", List.of(1,2,3,4,5));
    }

    private UserDetails getCurrentUser() {
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();

        if (authentication == null || !authentication.isAuthenticated()) {
            throw new IllegalStateException("Not authenticated (authentication is null or not authenticated)");
        }

        Object principal = authentication.getPrincipal();

        if (principal instanceof UserDetails ud) {
            return ud;
        }

        // common case when not logged in
        throw new IllegalStateException("Principal is not UserDetails: " + principal);
    }





}
