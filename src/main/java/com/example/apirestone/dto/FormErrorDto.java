package com.example.apirestone.dto;

import lombok.Data;


@Data
public class FormErrorDto {

    private String message;
    private String error;

    public FormErrorDto(String message, String error) {
        this.message = message;
        this.error = error;
    }
}
