package com.zerotoismail.librarymanagement.common.mapper;

import com.zerotoismail.librarymanagement.dto.user.UserRequestDto;
import com.zerotoismail.librarymanagement.dto.user.UserResponseDto;
import com.zerotoismail.librarymanagement.models.User;

import java.util.ArrayList;

public class UserMapper {

    public static User fromUserToUserRequestDto(UserRequestDto userRequestDto, User user) {
        user.setFirstName(userRequestDto.getFirstName());
        user.setLastName(userRequestDto.getLastName());
        user.setEmail(userRequestDto.getEmail());
        user.setPassword(userRequestDto.getPassword());
        user.setStatus(userRequestDto.getStatus());
        return user;
    }

    public static UserRequestDto fromUserToUserRequestDto(User user, UserRequestDto userRequestDto) {
        userRequestDto.setFirstName(user.getFirstName());
        userRequestDto.setLastName(user.getLastName());
        userRequestDto.setEmail(user.getEmail());
        userRequestDto.setPassword(user.getPassword());
        userRequestDto.setStatus(user.getStatus());
        return userRequestDto;
    }

    public static UserResponseDto fromUserToUserResponseDto(User user, UserResponseDto userResponseDto) {
        userResponseDto.setUuid(user.getId());
        userResponseDto.setFirstName(user.getFirstName());
        userResponseDto.setLastName(user.getLastName());
        userResponseDto.setEmail(user.getEmail());
        userResponseDto.setStatus(user.getStatus());
        userResponseDto.setBorrowedBooks(user.getBorrowedBooks() == null ? new ArrayList<>() : user.getBorrowedBooks());
        return userResponseDto;
    }
}
