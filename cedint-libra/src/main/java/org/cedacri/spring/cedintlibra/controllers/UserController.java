package org.cedacri.spring.cedintlibra.controllers;

import jakarta.validation.Valid;
import org.cedacri.spring.cedintlibra.dto_s.user.UserBaseDto;
import org.cedacri.spring.cedintlibra.dto_s.user.UserCreateDto;
import org.cedacri.spring.cedintlibra.dto_s.user.UserUpdateDto;
import org.cedacri.spring.cedintlibra.dto_s.user.UserWithTypeDto;
import org.cedacri.spring.cedintlibra.services.user.UserService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/libra/users")
public class UserController {

    private final UserService userService;

    public UserController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping("/all")
    public ResponseEntity<List<UserBaseDto>> getAllUsers(){
        return ResponseEntity.status(HttpStatus.OK).body(userService.getAllUsers());
    }

    @GetMapping("/{id}")
    public ResponseEntity<UserBaseDto> getById(@PathVariable("id") Long id){
        return ResponseEntity.ok(userService.getById(id));
    }

    @GetMapping("/{id}/type")
    public ResponseEntity<UserWithTypeDto> getWithType(@PathVariable("id") Long id){
        return ResponseEntity.ok(userService.getUserWithType(id));
    }

    @PostMapping(value = "/create", consumes = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Void> createUser(@RequestBody @Valid UserCreateDto dto){
        userService.createUser(dto);
        return ResponseEntity.status(HttpStatus.CREATED).body(null);
    }

    @PutMapping(value = "/update/{id}", consumes = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Void> updateUser(@PathVariable("id") Long id, @RequestBody @Valid UserUpdateDto dto){
        userService.updateUser(id, dto);
        return ResponseEntity.status(HttpStatus.CREATED).body(null);
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<Void> deleteUser(@PathVariable("id") Long id){
        userService.deleteUser(id);
        return ResponseEntity.status(HttpStatus.NO_CONTENT).body(null);
    }

}
