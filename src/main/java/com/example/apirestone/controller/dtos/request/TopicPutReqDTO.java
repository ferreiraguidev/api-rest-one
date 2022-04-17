package com.example.apirestone.controller.dtos.request;

import lombok.Data;

import java.time.LocalDateTime;

@Data
public class TopicPutReqDTO {

    private Long id;

    private String titulo;

    private String mensagem;

    private LocalDateTime dataCriacao;

    private Long autorId;

    private Long courseId;

}
