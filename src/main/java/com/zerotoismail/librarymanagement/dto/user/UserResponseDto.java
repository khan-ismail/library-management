package com.zerotoismail.librarymanagement.dto.user;

import com.zerotoismail.librarymanagement.dto.UserResponseBorrowBookDto;
import com.zerotoismail.librarymanagement.enums.UserStatus;
import com.zerotoismail.librarymanagement.models.UserBorrowBook;
import lombok.*;

import java.util.List;
import java.util.UUID;

@Setter
@Getter
@ToString
@AllArgsConstructor
@NoArgsConstructor
public class UserResponseDto {
    private UUID uuid;
    private String firstName;
    private String lastName;
    private String email;
    private UserStatus status;
    private List<UserResponseBorrowBookDto> borrowedBooks;
}
