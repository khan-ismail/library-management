package com.zerotoismail.librarymanagement.services;

import com.zerotoismail.librarymanagement.dto.book.BookResponseDto;
import com.zerotoismail.librarymanagement.enums.BookGenreType;
import com.zerotoismail.librarymanagement.enums.BookStatus;
import com.zerotoismail.librarymanagement.models.Book;
import com.zerotoismail.librarymanagement.models.UserBorrowBook;

import java.util.List;
import java.util.UUID;

public interface BookService {
    List<BookResponseDto> getBooks();

    BookResponseDto getBookById(UUID id);

    List<BookResponseDto> searchBookByTitle(String title);

    BookResponseDto createOrUpdateBook(UUID id, String title, String author, String publisher,
                                       List<BookGenreType> genreTypes, BookStatus bookStatus,
                                       String isbn, double pageSize);

    boolean deleteBook(UUID id);
}
