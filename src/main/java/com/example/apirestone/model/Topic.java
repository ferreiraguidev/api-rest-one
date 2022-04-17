package com.example.apirestone.model;

import lombok.*;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class Topic {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotBlank
    private String titulo;

    private String mensagem;

    private LocalDateTime dataCriacao = LocalDateTime.now();

    private TopicStatus status = TopicStatus.NAO_RESPONDIDO;

    @ManyToOne
    private Users autor;

    @ManyToOne
    private Course course;

    @OneToMany
    private List<Answers> respostas = new ArrayList<>();

}
