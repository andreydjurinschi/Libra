package org.cedacri.spring.cedintlibra.controllers;

import jakarta.validation.Valid;
import org.cedacri.spring.cedintlibra.dto_s.pos.PosBaseDto;
import org.cedacri.spring.cedintlibra.dto_s.pos.PosCreateDto;
import org.cedacri.spring.cedintlibra.dto_s.pos.PosDetailedDto;
import org.cedacri.spring.cedintlibra.services.pos.PosService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/libra/pos")
public class PosController {

    private final PosService posService;

    public PosController(PosService posService) {
        this.posService = posService;
    }

/*    @GetMapping("/all")
    public ResponseEntity<List<PosBaseDto>> getAll(){
        return ResponseEntity.ok(posService.findAll());
    }*/

    @GetMapping("/{id}")
    public ResponseEntity<PosBaseDto> getById(@PathVariable("id") Long id){
        return ResponseEntity.ok(posService.findById(id));
    }

/*
    @PostMapping("/create")
    public ResponseEntity<Void> create(@RequestBody @Valid PosCreateDto dto){
        posService.createPos(dto);
        return ResponseEntity.status(HttpStatus.CREATED).body(null);
    }
*/

/*    @PutMapping("/update/{id}")
    public ResponseEntity<Void> update(@RequestBody @Valid PosCreateDto dto, @PathVariable("id") Long id){
        posService.updatePos(id, dto);
        return ResponseEntity.status(HttpStatus.CREATED).body(null);
    }*/

    @GetMapping("/info/{id}")
    public ResponseEntity<PosDetailedDto> getDetailedPos(@PathVariable Long id){
        return ResponseEntity.ok(posService.getFullPosData(id));
    }

}
