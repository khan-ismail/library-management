package com.zerotoismail.librarymanagement.common.mapper;

import com.zerotoismail.librarymanagement.dto.UserResponseBorrowBookDto;
import com.zerotoismail.librarymanagement.dto.book.BookResponseDto;
import com.zerotoismail.librarymanagement.dto.user.UserRequestDto;
import com.zerotoismail.librarymanagement.dto.user.UserResponseDto;
import com.zerotoismail.librarymanagement.models.User;
import com.zerotoismail.librarymanagement.models.UserBorrowBook;

import java.util.ArrayList;
import java.util.List;

public class UserMapper {

    public static User fromUserToUserRequestDto(UserRequestDto userRequestDto, User user) {
        user.setFirstName(userRequestDto.getFirstName());
        user.setLastName(userRequestDto.getLastName());
        user.setEmail(userRequestDto.getEmail());
        user.setPassword(userRequestDto.getPassword());
        user.setStatus(userRequestDto.getStatus());
        return user;
    }

    public static UserRequestDto fromUserToUserRequestDto(User user, UserRequestDto userRequestDto) {
        userRequestDto.setFirstName(user.getFirstName());
        userRequestDto.setLastName(user.getLastName());
        userRequestDto.setEmail(user.getEmail());
        userRequestDto.setPassword(user.getPassword());
        userRequestDto.setStatus(user.getStatus());
        return userRequestDto;
    }

    public static UserResponseDto fromUserToUserResponseDto(User user, UserResponseDto userResponseDto) {
        userResponseDto.setUuid(user.getId());
        userResponseDto.setFirstName(user.getFirstName());
        userResponseDto.setLastName(user.getLastName());
        userResponseDto.setEmail(user.getEmail());
        userResponseDto.setStatus(user.getStatus());

        List<UserResponseBorrowBookDto> userResponseBorrowBookDtos = new ArrayList<>();
        List<UserBorrowBook> userBorrowBooks = user.getBorrowedBooks();


        for (UserBorrowBook userBorrowBook : userBorrowBooks) {
            BookResponseDto updatedBook = BookMapper.fromBookToBookResponseDto(userBorrowBook.getBook(), new BookResponseDto());
            userResponseBorrowBookDtos.add(new UserResponseBorrowBookDto(
                    userBorrowBook.getId(),
                    updatedBook,
                    userBorrowBook.getBorrowDate(),
                    userBorrowBook.getReturnDate()
            ));
        }

        userResponseDto.setBorrowedBooks(user.getBorrowedBooks() == null ? new ArrayList<>() : userResponseBorrowBookDtos);
        return userResponseDto;
    }
}
