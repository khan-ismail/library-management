package com.zerotoismail.librarymanagement.controllers;

import com.zerotoismail.librarymanagement.dto.ErrorResponseDto;
import com.zerotoismail.librarymanagement.dto.ResponseDto;
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
import java.util.UUID;

@RestController
@RequestMapping("/api")
@AllArgsConstructor
public class UserController {

    private UserService userService;

    @GetMapping("/users")
    public ResponseEntity<List<UserResponseDto>> createUser() {
        return new ResponseEntity<>(userService.getUsers(), HttpStatus.OK);
    }

    @GetMapping("/users/{id}")
    public ResponseEntity<UserResponseDto> getUsers(@PathVariable UUID id) {
        return new ResponseEntity<>(userService.getUserById(id), HttpStatus.OK);
    }

    @GetMapping("/users/search")
    public ResponseEntity<UserResponseDto> getUserByEmail(@RequestParam String email) {
        UserResponseDto user = userService.searchUserByEmail(email);
        return new ResponseEntity<>(user, HttpStatus.OK);
    }

    @PostMapping("/users")
    public ResponseEntity<UserResponseDto> createUser(@RequestBody UserRequestDto user) {
        UserResponseDto savedUser = userService.createOrUpdateUser(null, user.getFirstName(), user.getLastName(),
                user.getEmail(), user.getPassword(), user.getStatus(), new ArrayList<>());

        return new ResponseEntity<>(savedUser, HttpStatus.CREATED);
    }

    @PutMapping("/users/{id}")
    public ResponseEntity<UserResponseDto> updateUser(@PathVariable UUID id, @RequestBody UserRequestDto user){
        UserResponseDto updatedUser = userService.createOrUpdateUser(id, user.getFirstName(), user.getLastName(),
                user.getEmail(), user.getPassword(), user.getStatus(), new ArrayList<>());

        return new ResponseEntity<>(updatedUser, HttpStatus.OK);
    }

    @DeleteMapping("/users/{id}")
    public ResponseEntity<ResponseDto> deleteUser(@PathVariable UUID id) {
        boolean deleted = userService.deleteUser(id);
        if(deleted){
            ResponseDto responseDto = ResponseDto.builder()
                    .statusCode(HttpStatus.OK.value())
                    .message("User deleted successfully").build();
            return new ResponseEntity<>(responseDto, HttpStatus.OK);
        }
        return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
    }
}
