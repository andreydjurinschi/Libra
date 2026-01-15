package org.cedacri.spring.cedintlibra.controllers.home;

import org.cedacri.spring.cedintlibra.services.issue.IssueService;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class HomePageController {

    private final IssueService issueService;
    public HomePageController(IssueService issueService) {
        this.issueService = issueService;
    }

    @GetMapping("/libra/home")
    public String home(Model model) {

        UserDetails userDetails = getUserData();

        model.addAttribute("title", "Libra");
        model.addAttribute("userLogin", userDetails.getUsername());
        model.addAttribute("allIssues", issueService.getAll());
        model.addAttribute("assignedCount",
                issueService.getIssueCountByStatus("ASSIGNED"));

        model.addAttribute("newCount",
                issueService.getIssueCountByStatus("NEW"));

        model.addAttribute("inProgressCount",
                issueService.getIssueCountByStatus("IN_PROGRESS"));

        model.addAttribute("pendingCount",
                issueService.getIssueCountByStatus("PENDING"));

        return "home";
    }

    private UserDetails getUserData(){
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        return (UserDetails) authentication.getPrincipal();
    }
}
