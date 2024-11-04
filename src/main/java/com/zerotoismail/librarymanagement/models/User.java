package com.zerotoismail.librarymanagement.models;

import com.zerotoismail.librarymanagement.enums.UserStatus;
import jakarta.persistence.*;
import lombok.*;

import java.util.List;

@Setter
@Getter
@ToString
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class User extends BaseModel{

    private String firstName;
    private String lastName;
    private String email;
    private String password;

    @Enumerated(EnumType.STRING)
    private UserStatus status;

    @OneToMany(mappedBy = "user")
    private List<UserBorrowBook> borrowedBooks;
}
