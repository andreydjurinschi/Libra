package org.cedacri.spring.cedintlibra.controllers;

import jakarta.validation.Valid;
import org.cedacri.spring.cedintlibra.dto_s.log.LogBaseDto;
import org.cedacri.spring.cedintlibra.dto_s.log.LogCreateUpdateDto;
import org.cedacri.spring.cedintlibra.services.log.LogService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/libra/logs")
public class LogController {

    private final LogService logService;

    public LogController(LogService logService) {
        this.logService = logService;
    }

    @GetMapping("/all")
    public ResponseEntity<List<LogBaseDto>> getAll() {
        return ResponseEntity.ok(logService.getAll());
    }

    @GetMapping("/{id}")
    public ResponseEntity<LogBaseDto> getById(@PathVariable("id") Long id) {
        return ResponseEntity.ok(logService.getById(id));
    }

    @PostMapping("/create")
    public ResponseEntity<Void> create(@RequestBody @Valid LogCreateUpdateDto dto) {
        logService.create(dto);
        return ResponseEntity.status(HttpStatus.CREATED).body(null);
    }

    @PutMapping("/update/{id}")
    public ResponseEntity<Void> update(@PathVariable("id") Long id, @RequestBody @Valid LogCreateUpdateDto dto) {
        logService.update(id, dto);
        return ResponseEntity.status(HttpStatus.CREATED).body(null);
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<Void> delete(@PathVariable("id") Long id) {
        logService.delete(id);
        return ResponseEntity.status(HttpStatus.NO_CONTENT).body(null);
    }
}
