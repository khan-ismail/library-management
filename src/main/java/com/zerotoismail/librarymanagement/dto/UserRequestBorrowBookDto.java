package com.zerotoismail.librarymanagement.dto;

import lombok.*;

import java.time.LocalDateTime;
import java.util.Date;
import java.util.UUID;

@Data
@Builder
public class UserRequestBorrowBookDto {
        private UUID bookId;
        private UUID userId;
        private LocalDateTime borrowDate;
        private LocalDateTime returnDate;
    }
