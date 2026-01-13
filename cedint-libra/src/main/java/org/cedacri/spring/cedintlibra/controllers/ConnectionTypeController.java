package org.cedacri.spring.cedintlibra.controllers;

import jakarta.validation.Valid;
import org.cedacri.spring.cedintlibra.dto_s.connection_type.ConnectionTypeCreateUpdateDto;
import org.cedacri.spring.cedintlibra.dto_s.connection_type.ConnectionTypeDto;
import org.cedacri.spring.cedintlibra.services.connection_type.ConnectionTypeService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/libra/connection-types")
public class ConnectionTypeController {

    private final ConnectionTypeService connectionTypeService;

    public ConnectionTypeController(ConnectionTypeService connectionTypeService) {
        this.connectionTypeService = connectionTypeService;
    }

    @GetMapping("/all")
    public ResponseEntity<List<ConnectionTypeDto>> getAll() {
        return ResponseEntity.ok(connectionTypeService.getAll());
    }

    @GetMapping("/{id}")
    public ResponseEntity<ConnectionTypeDto> getById(@PathVariable("id") Long id) {
        return ResponseEntity.ok(connectionTypeService.getById(id));
    }

    @PostMapping("/create")
    public ResponseEntity<Void> create(@RequestBody @Valid ConnectionTypeCreateUpdateDto dto) {
        connectionTypeService.create(dto);
        return ResponseEntity.status(HttpStatus.CREATED).body(null);
    }

    @PutMapping("/update/{id}")
    public ResponseEntity<Void> update(@PathVariable("id") Long id, @RequestBody @Valid ConnectionTypeCreateUpdateDto dto) {
        connectionTypeService.update(id, dto);
        return ResponseEntity.status(HttpStatus.CREATED).body(null);
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<Void> delete(@PathVariable("id") Long id) {
        connectionTypeService.delete(id);
        return ResponseEntity.status(HttpStatus.NO_CONTENT).body(null);
    }
}
