package com.zerotoismail.librarymanagement.services;

import com.zerotoismail.librarymanagement.dto.user.UserResponseDto;
import com.zerotoismail.librarymanagement.enums.UserStatus;
import com.zerotoismail.librarymanagement.models.User;
import com.zerotoismail.librarymanagement.models.UserBorrowBook;

import java.util.List;
import java.util.UUID;

public interface UserService {    
    List<UserResponseDto> getUsers();

    User getUserById(UUID id);

    List<User> searchUserByFirstName(String title);
    List<User> searchUserByEmail(String email);

    UserResponseDto createOrUpdateUser(UUID id, String firstName, String lastName,
                                       String email, String password, UserStatus status,
                                       List<UserBorrowBook> borrowedBooks);

    User deleteUser(UUID id);
}
