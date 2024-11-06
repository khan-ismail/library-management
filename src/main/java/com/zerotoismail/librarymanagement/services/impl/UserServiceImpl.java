package com.zerotoismail.librarymanagement.services.impl;

import com.zerotoismail.librarymanagement.common.mapper.UserMapper;
import com.zerotoismail.librarymanagement.dto.user.UserResponseDto;
import com.zerotoismail.librarymanagement.enums.UserStatus;
import com.zerotoismail.librarymanagement.exceptions.ResourceNotFoundException;
import com.zerotoismail.librarymanagement.models.User;
import com.zerotoismail.librarymanagement.models.UserBorrowBook;
import com.zerotoismail.librarymanagement.repositories.UserRepository;
import com.zerotoismail.librarymanagement.services.UserService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

@Service
@AllArgsConstructor
public class UserServiceImpl implements UserService {

    private UserRepository userRepository;

    @Override
    public List<UserResponseDto> getUsers() {
        List<User> users = userRepository.findAll();
        List<UserResponseDto> userResponseDtos = new ArrayList<>();

        for (User user : users) {
            UserResponseDto responseDto = UserMapper.fromUserToUserResponseDto(user, new UserResponseDto());
            userResponseDtos.add(responseDto);
        }

        return userResponseDtos;
    }

    @Override
    public UserResponseDto getUserById(UUID id) {
        User user = userRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("User", "userId", id.toString()));
        return UserMapper.fromUserToUserResponseDto(user, new UserResponseDto());
    }

    @Override
    public List<User> searchUserByFirstName(String title) {
        return userRepository.findByFirstName(title);
    }

    @Override
    public UserResponseDto searchUserByEmail(String email) {
        User user = userRepository.findByEmail(email).orElseThrow(
                () -> new ResourceNotFoundException("User", "email", email)
        );
        return UserMapper.fromUserToUserResponseDto(user, new UserResponseDto());
    }

    @Override
    public UserResponseDto createOrUpdateUser(UUID id, String firstName, String lastName,
                                              String email, String password, UserStatus status,
                                              List<UserBorrowBook> borrowedBooks) {
        User user = new User();
        user.setId(id);
        user.setFirstName(firstName);
        user.setLastName(lastName);
        user.setEmail(email);
        user.setPassword(password);
        user.setStatus(status);
        user.setBorrowedBooks(borrowedBooks);
        userRepository.save(user);

        UserResponseDto responseDto = UserMapper.fromUserToUserResponseDto(user, new UserResponseDto());
        responseDto.setBorrowedBooks(new ArrayList<UserBorrowBook>());

        return responseDto;
    }

    @Override
    public boolean deleteUser(UUID id) {
        User foundUser = userRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("User", "userId", id.toString()));
        userRepository.deleteById(id);
        return true;
    }
}
