package org.cedacri.spring.cedintlibra.controllers;

import org.cedacri.spring.cedintlibra.dto_s.user_type.UserTypeDto;
import org.cedacri.spring.cedintlibra.services.user_type.UserTypeService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/libra/user-types")
public class UserTypeController {

    private final UserTypeService userTypeService;

    public UserTypeController(UserTypeService userTypeService) {
        this.userTypeService = userTypeService;
    }

    @GetMapping("/all")
    public ResponseEntity<List<UserTypeDto>> getAll(){
        return ResponseEntity.ok(userTypeService.getAll());
    }

    @GetMapping("/{id}")
    public ResponseEntity<UserTypeDto> getById(@PathVariable("id") Long id){
        return ResponseEntity.ok(userTypeService.findById(id));
    }
}
