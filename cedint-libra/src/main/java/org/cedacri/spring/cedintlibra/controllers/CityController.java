package org.cedacri.spring.cedintlibra.controllers;

import jakarta.validation.Valid;
import org.cedacri.spring.cedintlibra.dto_s.city.CityCreateUpdateDto;
import org.cedacri.spring.cedintlibra.dto_s.city.CityDto;
import org.cedacri.spring.cedintlibra.services.city.CityService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/libra/cities")
public class CityController {

    private final CityService cityService;

    public CityController(CityService cityService) {
        this.cityService = cityService;
    }

    @GetMapping("/all")
    public ResponseEntity<List<CityDto>> getAll() {
        return ResponseEntity.ok(cityService.getAll());
    }

    @GetMapping("/{id}")
    public ResponseEntity<CityDto> getById(@PathVariable("id") Long id) {
        return ResponseEntity.ok(cityService.getById(id));
    }

    @PostMapping("/create")
    public ResponseEntity<Void> create(@RequestBody @Valid CityCreateUpdateDto dto) {
        cityService.create(dto);
        return ResponseEntity.status(HttpStatus.CREATED).body(null);
    }

    @PutMapping("/update/{id}")
    public ResponseEntity<Void> update(@PathVariable("id") Long id, @RequestBody @Valid CityCreateUpdateDto dto) {
        cityService.update(id, dto);
        return ResponseEntity.status(HttpStatus.CREATED).body(null);
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<Void> delete(@PathVariable("id") Long id) {
        cityService.delete(id);
        return ResponseEntity.status(HttpStatus.NO_CONTENT).body(null);
    }
}
