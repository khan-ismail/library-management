package com.zerotoismail.librarymanagement.controllers;

import com.zerotoismail.librarymanagement.dto.user.UserRequestDto;
import com.zerotoismail.librarymanagement.dto.user.UserResponseDto;
import com.zerotoismail.librarymanagement.models.User;
import com.zerotoismail.librarymanagement.services.UserService;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.RequestEntity;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/api")
@AllArgsConstructor
public class UserController {

    private UserService userService;

    @GetMapping("/users")
    public ResponseEntity<List<UserResponseDto>> createUser() {
        return new ResponseEntity<>(userService.getUsers(), HttpStatus.CREATED);
    }

    @PostMapping("/users")
    public ResponseEntity<UserResponseDto> createUser(@RequestBody UserRequestDto user) {
        UserResponseDto savedUser = userService.createOrUpdateUser(null, user.getFirstName(), user.getLastName(),
                user.getEmail(), user.getPassword(), user.getStatus(), new ArrayList<>());

        return new ResponseEntity<>(savedUser, HttpStatus.CREATED);
    }
}
