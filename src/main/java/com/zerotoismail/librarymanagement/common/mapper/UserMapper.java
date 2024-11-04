package com.zerotoismail.librarymanagement.common.mapper;

import com.zerotoismail.librarymanagement.dto.user.UserRequestDto;
import com.zerotoismail.librarymanagement.dto.user.UserResponseDto;
import com.zerotoismail.librarymanagement.models.User;

public class UserMapper {

    static User fromUserToUserRequestDto(UserRequestDto userRequestDto, User user) {
        user.setFirstName(userRequestDto.getFirstName());
        user.setLastName(userRequestDto.getLastName());
        user.setEmail(userRequestDto.getEmail());
        user.setPassword(userRequestDto.getPassword());
        user.setStatus(userRequestDto.getStatus());
        return user;
    }

    static UserRequestDto fromUserToUserRequestDto(User user, UserRequestDto userRequestDto) {
        userRequestDto.setFirstName(user.getFirstName());
        userRequestDto.setLastName(user.getLastName());
        userRequestDto.setEmail(user.getEmail());
        userRequestDto.setPassword(user.getPassword());
        userRequestDto.setStatus(user.getStatus());
        return userRequestDto;
    }

    static UserResponseDto fromUserToUserResponseDto(User user, UserResponseDto userResponseDto) {
        userResponseDto.setUuid(user.getId());
        userResponseDto.setFirstName(user.getFirstName());
        userResponseDto.setLastName(user.getLastName());
        userResponseDto.setEmail(user.getEmail());
        userResponseDto.setPassword(user.getPassword());
        userResponseDto.setStatus(user.getStatus());
        return userResponseDto;
    }
}
