package com.zerotoismail.librarymanagement.dto;

import lombok.*;

@Data
@Builder
public class ResponseDto {
    private int statusCode;
    private String message;
}
