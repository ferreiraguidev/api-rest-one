package com.example.apirestone.controller.dtos.response;

import com.example.apirestone.model.Answers;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Getter
@Setter
public class TopicPostResponseDTO {

    private String titulo;
    private String mensagem;
    private String status;
    private LocalDateTime dataCriacao;
    private Long autorId;
    private Long courseId;
    private List<Answers> answers = new ArrayList<>();
}
