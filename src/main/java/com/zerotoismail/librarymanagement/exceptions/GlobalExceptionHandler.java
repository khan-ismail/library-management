package com.zerotoismail.librarymanagement.exceptions;

import com.zerotoismail.librarymanagement.dto.ErrorResponseDto;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.context.request.WebRequest;

import java.time.LocalDateTime;

@RestControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler(ResourceNotFoundException.class)
    public ResponseEntity<ErrorResponseDto> resourceNotFoundExceptionHandler(ResourceNotFoundException ex, WebRequest request) {
        ErrorResponseDto errorResponseDto = new ErrorResponseDto();
        errorResponseDto.setStatusCode(HttpStatus.NOT_FOUND.value());
        errorResponseDto.setApiPath(request.getDescription(false));
        errorResponseDto.setMessage(ex.getMessage());
        errorResponseDto.setTimestamp(LocalDateTime.now());

        return new ResponseEntity<>(errorResponseDto, HttpStatus.NOT_FOUND);
    }

    @ExceptionHandler(Exception.class)
    public ResponseEntity<ErrorResponseDto> parentExceptionHandler(Exception ex, WebRequest request) {
        ErrorResponseDto errorResponseDto = new ErrorResponseDto();
        errorResponseDto.setStatusCode(HttpStatus.NOT_FOUND.value());
        errorResponseDto.setApiPath(request.getDescription(false));
        errorResponseDto.setMessage(ex.getMessage());
        errorResponseDto.setTimestamp(LocalDateTime.now());

        return new ResponseEntity<>(errorResponseDto, HttpStatus.NOT_FOUND);
    }

//    @Override
//    protected ResponseEntity<Object> handleMethodArgumentNotValid(MethodArgumentNotValidException ex,
//                                                                  HttpHeaders headers, HttpStatusCode status,
//                                                                  WebRequest request) {
//        return super.handleMethodArgumentNotValid(ex, headers, status, request);
//    }
}
