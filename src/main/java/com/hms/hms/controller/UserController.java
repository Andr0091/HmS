package com.hms.hms.controller;

import com.hms.hms.dto.UserDto.UserCreateDto;
import com.hms.hms.dto.UserDto.UserResponseDto;
import com.hms.hms.service.UserService;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/users")
public class UserController {

    private final UserService service;

    public UserController(UserService service) {
        this.service = service;
    }

    @PostMapping
    public ResponseEntity<Long> createUser(
            @Valid @RequestBody UserCreateDto dto
    ) {
        Long id = service.createUser(dto);
        return ResponseEntity.status(HttpStatus.CREATED).body(id);
    }

    @GetMapping("/{id}")
    public ResponseEntity<UserResponseDto> getUserById(
            @PathVariable Long id
    ) {
        UserResponseDto user = service.findUserById(id);
        return ResponseEntity.ok(user);
    }

    @GetMapping
    public ResponseEntity<List<UserResponseDto>> getAllUsers() {
        List<UserResponseDto> users = service.findAllUsers();
        return ResponseEntity.ok(users);
    }

}