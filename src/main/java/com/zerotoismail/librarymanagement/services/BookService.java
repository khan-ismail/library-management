package com.zerotoismail.librarymanagement.services;

import com.zerotoismail.librarymanagement.enums.BookGenreType;
import com.zerotoismail.librarymanagement.enums.BookStatus;
import com.zerotoismail.librarymanagement.models.Book;
import com.zerotoismail.librarymanagement.models.UserBorrowBook;

import java.util.List;
import java.util.UUID;

public interface BookService {
    List<Book> getBooks();

    Book getBookById(UUID id);

    List<Book> searchBookByTitle(String title);

    Book createOrUpdateBook(UUID id, String title, String author, String publisher,
                    List<BookGenreType> genreTypes, BookStatus bookStatus,
                    List<UserBorrowBook> borrowedBooks, String isbn, double pageSize);

    Book deleteBook(UUID id);
}
