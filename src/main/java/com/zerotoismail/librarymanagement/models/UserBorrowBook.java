package com.zerotoismail.librarymanagement.models;

import jakarta.persistence.*;
import lombok.*;
import org.hibernate.annotations.UuidGenerator;

import java.time.LocalDateTime;
import java.util.UUID;

@Setter
@Getter
@ToString
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class UserBorrowBook{
    @Id
    @UuidGenerator
    private UUID id;

    @ManyToOne
    private Book book;

    @ManyToOne
    private User user;
    private LocalDateTime borrowDate;
    private LocalDateTime returnDate;
}
