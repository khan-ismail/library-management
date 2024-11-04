package com.zerotoismail.librarymanagement.dto.user;

import com.zerotoismail.librarymanagement.enums.UserStatus;
import lombok.*;


@Setter
@Getter
@ToString
@AllArgsConstructor
@NoArgsConstructor
public class UserRequestDto {
    private String firstName;
    private String lastName;
    private String email;
    private String password;
    private UserStatus status;
}
