package com.zerotoismail.librarymanagement.services.impl;

import com.zerotoismail.librarymanagement.common.mapper.BookMapper;
import com.zerotoismail.librarymanagement.dto.book.BookResponseDto;
import com.zerotoismail.librarymanagement.enums.BookGenreType;
import com.zerotoismail.librarymanagement.enums.BookStatus;
import com.zerotoismail.librarymanagement.exceptions.ResourceNotFoundException;
import com.zerotoismail.librarymanagement.models.Book;
import com.zerotoismail.librarymanagement.models.UserBorrowBook;
import com.zerotoismail.librarymanagement.repositories.BookRepository;
import com.zerotoismail.librarymanagement.services.BookService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

@Service
@AllArgsConstructor
public class BookServiceImpl implements BookService {

    private BookRepository bookRepository;

    @Override
    public List<BookResponseDto> getBooks() {
        List<Book> books = bookRepository.findAll();
        List<BookResponseDto> bookResponseDtos = new ArrayList<>();
        for(Book book : books){
            bookResponseDtos.add(BookMapper.fromBookToBookResponseDto(book, new BookResponseDto()));
        }

        return bookResponseDtos;
    }

    @Override
    public BookResponseDto getBookById(UUID id) {
        Book book = bookRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Book", "BookId", id.toString()));
        return BookMapper.fromBookToBookResponseDto(book, new BookResponseDto());
    }

    @Override
    public List<BookResponseDto> searchBookByTitle(String title) {
        List<Book> books = bookRepository.findByTitleContainingIgnoreCase(title);

        List<BookResponseDto> bookResponseDtos = new ArrayList<>();
        for(Book book : books){
            bookResponseDtos.add(BookMapper.fromBookToBookResponseDto(book, new BookResponseDto()));
        }
        return bookResponseDtos;
    }

    @Override
    public BookResponseDto createOrUpdateBook(UUID id, String title, String author,
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

        Book savedBook = bookRepository.save(newBook);
        return BookMapper.fromBookToBookResponseDto(savedBook, new BookResponseDto());
    }

    @Override
    public boolean deleteBook(UUID id) {
        Book foundBook = bookRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Book", "BookId", id.toString()));
        bookRepository.delete(foundBook);
        return true;
    }
}
