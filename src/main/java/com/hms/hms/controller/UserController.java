package com.hms.hms.controller;

import com.hms.hms.dto.UserDto.UserCreateDto;
import com.hms.hms.service.UserService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/users")
public class UserController {

    private final UserService service;

    public UserController(UserService service) {
        this.service = service;
    }

    @PostMapping
    public ResponseEntity<Long> createUser(@RequestBody UserCreateDto dto) {
        Long id = service.createUser(dto);
        return ResponseEntity.status(HttpStatus.CREATED).body(id);
    }
}