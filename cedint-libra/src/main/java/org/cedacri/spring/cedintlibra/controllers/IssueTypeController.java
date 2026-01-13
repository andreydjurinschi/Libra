package org.cedacri.spring.cedintlibra.controllers;

import jakarta.validation.Valid;
import org.cedacri.spring.cedintlibra.dto_s.issue_type.IssueTypeCreateUpdateDto;
import org.cedacri.spring.cedintlibra.dto_s.issue_type.IssueTypeDto;
import org.cedacri.spring.cedintlibra.services.issue_type.IssueTypeService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/libra/issue-types")
public class IssueTypeController {

    private final IssueTypeService issueTypeService;

    public IssueTypeController(IssueTypeService issueTypeService) {
        this.issueTypeService = issueTypeService;
    }

    @GetMapping("/all")
    public ResponseEntity<List<IssueTypeDto>> getAll() {
        return ResponseEntity.ok(issueTypeService.getAll());
    }

    @GetMapping("/{id}")
    public ResponseEntity<IssueTypeDto> getById(@PathVariable("id") Long id) {
        return ResponseEntity.ok(issueTypeService.getById(id));
    }

    @PostMapping("/create")
    public ResponseEntity<Void> create(@RequestBody @Valid IssueTypeCreateUpdateDto dto) {
        issueTypeService.create(dto);
        return ResponseEntity.status(HttpStatus.CREATED).body(null);
    }

    @PutMapping("/update/{id}")
    public ResponseEntity<Void> update(@PathVariable("id") Long id, @RequestBody @Valid IssueTypeCreateUpdateDto dto) {
        issueTypeService.update(id, dto);
        return ResponseEntity.status(HttpStatus.CREATED).body(null);
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<Void> delete(@PathVariable("id") Long id) {
        issueTypeService.delete(id);
        return ResponseEntity.status(HttpStatus.NO_CONTENT).body(null);
    }
}
