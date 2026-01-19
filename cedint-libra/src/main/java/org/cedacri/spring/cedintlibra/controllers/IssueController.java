package org.cedacri.spring.cedintlibra.controllers;

import jakarta.validation.Valid;
import org.cedacri.spring.cedintlibra.dto_s.issue.IssueBaseDto;
import org.cedacri.spring.cedintlibra.dto_s.issue.IssueCreateDto;
import org.cedacri.spring.cedintlibra.dto_s.issue.IssueUpdateDto;
import org.cedacri.spring.cedintlibra.entity.Status;
import org.cedacri.spring.cedintlibra.services.issue.IssueService;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/libra/issues")
public class IssueController {

    private final IssueService issueService;

    public IssueController(IssueService issueService) {
        this.issueService = issueService;
    }

    @GetMapping("/all")
    public ResponseEntity<List<IssueBaseDto>> getAll() {
        return ResponseEntity.ok(issueService.getAll());
    }

    @GetMapping("/{id}")
    public ResponseEntity<IssueBaseDto> getById(@PathVariable("id") Long id) {
        return ResponseEntity.ok(issueService.getById(id));
    }

    @PostMapping(value = "/create", consumes = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Void> create(@RequestBody @Valid IssueCreateDto dto) {
        issueService.create(dto);
        return ResponseEntity.status(HttpStatus.CREATED).body(null);
    }

    @PutMapping(value = "/update/{id}", consumes = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Void> update(@PathVariable("id") Long id, @RequestBody @Valid IssueUpdateDto dto) {
        issueService.update(id, dto);
        return ResponseEntity.status(HttpStatus.CREATED).body(null);
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<Void> delete(@PathVariable("id") Long id) {
        issueService.delete(id);
        return ResponseEntity.status(HttpStatus.NO_CONTENT).body(null);
    }

}
