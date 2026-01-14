package org.cedacri.spring.cedintlibra.controllers.home;

import org.cedacri.spring.cedintlibra.services.issue.IssueService;
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

        model.addAttribute("title", "Libra");
        model.addAttribute("userLogin", "Temporar_Login123"); // TODO: print user login after authorizing
        model.addAttribute("logout", "Logout"); // TODO: logout logic
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

}
