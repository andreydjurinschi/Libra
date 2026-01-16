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

import java.util.List;

@Controller
public class IssuePageController {
    private final IssueService issueService;
    private final PosService posService;
    private final IssueTypeService issueTypeService;
    private final StatusService statusService;
    private final UserService userService;
    public IssuePageController(IssueService issueService, PosService posService, IssueTypeService issueTypeService, StatusService statusService, UserService userService) {
        this.issueService = issueService;
        this.posService = posService;
        this.issueTypeService = issueTypeService;
        this.statusService = statusService;
        this.userService = userService;
    }

/*    @GetMapping("libra/issues/detailed/{id}")
    public String showDetailedPage(Model model, @PathVariable("id") Long id){

        IssueBaseDto issueBaseDto = issueService.getById(id);
        PosBaseDto posBaseDto = posService.findById(issueBaseDto.getPosId());
        model.addAttribute("id", id);
        model.addAttribute("issue", issueBaseDto);
        model.addAttribute("pos", posBaseDto);
        return "issue/issue-details-page";
    }*/


    @GetMapping("libra/issues/detailed/{id}")
    public String getIssue(@PathVariable Long id, Model model) {
        IssueBaseDto issue = issueService.getById(id);

        model.addAttribute("issue", issue);

        model.addAttribute("generalTypes", GeneralType.values());
        model.addAttribute("types", issueTypeService.getAll());
        model.addAttribute("statuses", statusService.getAll());
        model.addAttribute("users", userService.getAllUsers());
        model.addAttribute("positions", posService.findAll());

        model.addAttribute("priorities", List.of(1,2,3,4,5));

        model.addAttribute("pos", posService.findById(issue.getPosId()));

        return "issue/issue-details-page";
    }

    @PostMapping("libra/issues/update/{id}")
    public String updateIssue(@PathVariable Long id,
                              @ModelAttribute("issue") IssueUpdateDto dto,
                              RedirectAttributes ra) {
        issueService.update(id, dto);
        ra.addFlashAttribute("success", "Issue updated successfully");
        return "redirect:/libra/home";
    }



}
