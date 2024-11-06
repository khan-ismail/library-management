package com.zerotoismail.librarymanagement.dto.user;

import com.zerotoismail.librarymanagement.enums.UserStatus;
import lombok.*;


@Data
@Builder
public class UserRequestDto {
    private String firstName;
    private String lastName;
    private String email;
    private String password;
    private UserStatus status;
}
