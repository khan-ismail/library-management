package com.zerotoismail.librarymanagement.dto;

import com.zerotoismail.librarymanagement.dto.book.BookResponseDto;
import lombok.*;

import java.time.LocalDateTime;
import java.util.UUID;

@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class UserResponseBorrowBookDto {
    private UUID uuid;
    private BookResponseDto book;
    private LocalDateTime borrowDate;
    private LocalDateTime returnDate;
}
