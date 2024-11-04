package com.zerotoismail.librarymanagement.dto;

import lombok.*;

@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class ResponseDto {
    private int statusCode;
    private String message;
}
