package com.zerotoismail.librarymanagement.services.impl;

import com.zerotoismail.librarymanagement.enums.BookStatus;
import com.zerotoismail.librarymanagement.exceptions.BookBorrowMaxLimitReachedException;
import com.zerotoismail.librarymanagement.exceptions.BookNotAvailableException;
import com.zerotoismail.librarymanagement.exceptions.ResourceNotFoundException;
import com.zerotoismail.librarymanagement.models.Book;
import com.zerotoismail.librarymanagement.models.User;
import com.zerotoismail.librarymanagement.models.UserBorrowBook;
import com.zerotoismail.librarymanagement.repositories.BookRepository;
import com.zerotoismail.librarymanagement.repositories.UserRepository;
import com.zerotoismail.librarymanagement.services.UserBorrowBookService;
import jakarta.persistence.ManyToOne;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;

@Service
@AllArgsConstructor
public class UserBorrowBookServiceImpl implements UserBorrowBookService {

    private BookRepository bookRepository;
    private UserRepository userRepository;

    @Override
    public boolean borrowBook(UUID bookId, UUID userId, LocalDateTime borrowDate, LocalDateTime returnDate) {
        Book book = bookRepository.findById(bookId)
                .orElseThrow(() -> new ResourceNotFoundException("Book", "BookId", bookId.toString()));

        if(book.getBookStatus() == BookStatus.NOT_AVAILABLE){
            throw new BookNotAvailableException(book.getTitle() + " Not available right now");
        }

        User user = userRepository.findById(userId)
                .orElseThrow(() -> new ResourceNotFoundException("User", "UserId", bookId.toString()));

        int bookBorrowSize = user.getBorrowedBooks().size();
        if(bookBorrowSize > 5){
            throw new BookBorrowMaxLimitReachedException(user.getFirstName() + " already borrow " + bookBorrowSize + " books please return it first");
        }

        user.getBorrowedBooks().add(new UserBorrowBook(
                null,
                book,
                user,
                borrowDate,
                returnDate
        ));
        book.setBookStatus(BookStatus.NOT_AVAILABLE);
        bookRepository.save(book);
        userRepository.save(user);
        return true;

    }

    @Override
    public boolean returnBook(UUID bookId, UUID userId, LocalDateTime returnDate) {
        Book book = bookRepository.findById(bookId)
                .orElseThrow(() -> new ResourceNotFoundException("Book", "BookId", bookId.toString()));

        book.setBookStatus(BookStatus.AVAILABLE);
        bookRepository.save(book);

        User user = userRepository.findById(userId)
                .orElseThrow(() -> new ResourceNotFoundException("User", "UserId", bookId.toString()));

        int indexFound = -1;
        for(int i = 0; i < user.getBorrowedBooks().size(); i++){
            if(user.getBorrowedBooks().get(i).getId().equals(bookId)){
                indexFound = i;
                break;
            }
        }

        user.getBorrowedBooks().remove(indexFound);
        userRepository.save(user);
        return true;
    }
}
