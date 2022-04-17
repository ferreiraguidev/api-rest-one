package com.example.apirestone.controller.dtos.request;

import lombok.Data;

import java.time.LocalDateTime;
@Data
public class AnswersPostReqBody {


    private String mensagem;

    private LocalDateTime dataCriacao;

    private Boolean solucao;

    private Long autorId;

    private Long topicsId;


}
