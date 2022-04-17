package com.example.apirestone.controller.dtos.request;

import lombok.Data;

@Data
public class UsersPostReqBody {

    private String nome;
    private String email;
    private String senha;

}
