package com.zerotoismail.librarymanagement.services;

import java.time.LocalDateTime;
import java.util.UUID;

public interface UserBorrowBookService {

    boolean borrowBook(UUID bookId, UUID userId, LocalDateTime borrowDate, LocalDateTime returnDate);
    boolean returnBook(UUID bookId, UUID userId, LocalDateTime returnDate);
}
