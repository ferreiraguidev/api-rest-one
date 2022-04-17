package com.example.apirestone.controller.dtos.request;

import lombok.Data;

@Data
public class CoursePutReqBody {

    private Long id;

    private String nome;
    private String categoria;
}
