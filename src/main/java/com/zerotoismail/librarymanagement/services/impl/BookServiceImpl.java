package com.zerotoismail.librarymanagement.services.impl;

import com.zerotoismail.librarymanagement.enums.BookGenreType;
import com.zerotoismail.librarymanagement.enums.BookStatus;
import com.zerotoismail.librarymanagement.exceptions.ResourceNotFoundException;
import com.zerotoismail.librarymanagement.models.Book;
import com.zerotoismail.librarymanagement.models.UserBorrowBook;
import com.zerotoismail.librarymanagement.repositories.BookRepository;
import com.zerotoismail.librarymanagement.services.BookService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
@AllArgsConstructor
public class BookServiceImpl implements BookService {

    private BookRepository bookRepository;

    @Override
    public List<Book> getBooks() {
        return bookRepository.findAll();
    }

    @Override
    public Book getBookById(UUID id) {
        return bookRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Book", "BookId", id.toString()));
    }

    @Override
    public List<Book> searchBookByTitle(String title) {
        return bookRepository.findByTitle(title);
    }

    @Override
    public Book createOrUpdateBook(UUID id, String title, String author,
                                   String publisher, List<BookGenreType> genreTypes,
                                   BookStatus bookStatus, String isbn, double pageSize) {
        Book newBook = new Book();
        newBook.setId(id);
        newBook.setTitle(title);
        newBook.setAuthor(author);
        newBook.setPublisher(publisher);
        newBook.setGenreTypes(genreTypes);
        newBook.setBookStatus(bookStatus);
        newBook.setIsbn(isbn);
        newBook.setPageSize(pageSize);

        return bookRepository.save(newBook);
    }

    @Override
    public Book deleteBook(UUID id) {
        Book foundBook = bookRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Book", "BookId", id.toString()));
        bookRepository.delete(foundBook);
        return foundBook;
    }
}
