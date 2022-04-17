package com.example.apirestone.controller.dtos.request;

import com.example.apirestone.model.Answers;
import lombok.Data;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Data
public class TopicPostReqDTO {

    private String titulo;

    private String mensagem;

    private String status;

    private LocalDateTime dataCriacao;

    private Long autorId;

    private Long courseId;

    private List<Answers> asdada= new ArrayList<>();






}
