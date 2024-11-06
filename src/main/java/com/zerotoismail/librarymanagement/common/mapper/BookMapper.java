package com.zerotoismail.librarymanagement.common.mapper;

import com.zerotoismail.librarymanagement.dto.book.BookRequestDto;
import com.zerotoismail.librarymanagement.dto.book.BookResponseDto;
import com.zerotoismail.librarymanagement.models.Book;

public class BookMapper {

    public static Book fromBookRequestDtoToBook(BookRequestDto bookRequestDto, Book book) {
        book.setTitle(bookRequestDto.getTitle());
        book.setAuthor(bookRequestDto.getAuthor());
        book.setPublisher(bookRequestDto.getPublisher());
        book.setGenreTypes(bookRequestDto.getGenreTypes());
        book.setBookStatus(bookRequestDto.getBookStatus());
        book.setIsbn(bookRequestDto.getIsbn());
        book.setPageSize(bookRequestDto.getPageSize());
        return book;
    }

    public static BookRequestDto fromBookToBookRequestDto(Book book, BookRequestDto bookRequestDto) {
        bookRequestDto.setTitle(book.getTitle());
        bookRequestDto.setAuthor(book.getAuthor());
        bookRequestDto.setPublisher(book.getPublisher());
        bookRequestDto.setGenreTypes(book.getGenreTypes());
        bookRequestDto.setBookStatus(book.getBookStatus());
        bookRequestDto.setIsbn(book.getIsbn());
        bookRequestDto.setPageSize(book.getPageSize());
        return bookRequestDto;
    }

    public static BookResponseDto fromBookToBookResponseDto(Book book, BookResponseDto bookResponseDto) {
        bookResponseDto.setUuid(book.getId());
        bookResponseDto.setTitle(book.getTitle());
        bookResponseDto.setAuthor(book.getAuthor());
        bookResponseDto.setPublisher(book.getPublisher());
        bookResponseDto.setGenreTypes(book.getGenreTypes());
        bookResponseDto.setBookStatus(book.getBookStatus());
        bookResponseDto.setIsbn(book.getIsbn());
        bookResponseDto.setPageSize(book.getPageSize());
        return bookResponseDto;
    }
}
