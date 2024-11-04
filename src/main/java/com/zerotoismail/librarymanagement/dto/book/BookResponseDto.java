package com.zerotoismail.librarymanagement.dto.book;

import com.zerotoismail.librarymanagement.enums.BookGenreType;
import com.zerotoismail.librarymanagement.enums.BookStatus;
import lombok.*;

import java.util.List;
import java.util.UUID;

@Setter
@Getter
@ToString
@AllArgsConstructor
@NoArgsConstructor
public class BookResponseDto {
    private UUID uuid;
    private String title;
    private String author;
    private String publisher;
    private List<BookGenreType> genreTypes;
    private BookStatus bookStatus;
    private String isbn;
    private double pageSize;
}
