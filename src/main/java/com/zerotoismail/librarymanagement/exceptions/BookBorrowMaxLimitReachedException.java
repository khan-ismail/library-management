package com.zerotoismail.librarymanagement.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.BAD_REQUEST)
public class BookBorrowMaxLimitReachedException extends RuntimeException {
    public BookBorrowMaxLimitReachedException(String message) {
        super(message);
    }
}
