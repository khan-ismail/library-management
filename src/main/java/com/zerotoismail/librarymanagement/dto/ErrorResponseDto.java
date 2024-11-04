package com.zerotoismail.librarymanagement.dto;

import lombok.*;

import java.time.LocalDateTime;

@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class ErrorResponseDto {
    private int statusCode;
    private String apiPath;
    private String message;
    private LocalDateTime timestamp;
}
