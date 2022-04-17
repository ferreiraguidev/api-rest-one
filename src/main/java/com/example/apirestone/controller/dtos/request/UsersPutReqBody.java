package com.example.apirestone.controller.dtos.request;

import lombok.Data;

@Data
public class UsersPutReqBody {

    private Long id;

    private String nome;
    private String email;
    private String senha;

}
