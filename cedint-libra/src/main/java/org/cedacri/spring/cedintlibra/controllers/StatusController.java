package org.cedacri.spring.cedintlibra.controllers;

import org.cedacri.spring.cedintlibra.dto_s.status.StatusDto;
import org.cedacri.spring.cedintlibra.services.status.StatusService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/libra/statuses")
public class StatusController {
    private final StatusService statusService;

    public StatusController(StatusService statusService) {
        this.statusService = statusService;
    }

    @GetMapping("/all")
    public ResponseEntity<List<StatusDto>> getAll(){
        return ResponseEntity.ok(statusService.getAll());
    }

    @GetMapping("/{id}")
    public ResponseEntity<StatusDto> getById(@PathVariable("id") Long id){
        return ResponseEntity.ok(statusService.getById(id));
    }


}
