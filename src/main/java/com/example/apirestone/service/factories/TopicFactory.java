package com.example.apirestone.service.factories;

import com.example.apirestone.model.Topic;
import com.example.apirestone.service.AutorService;
import com.example.apirestone.service.CourseService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

@RequiredArgsConstructor
@Component
public class TopicFactory {

    private final AutorService autorService;

    private final CourseService courseService;

    public Topic topicFactory(final Topic topic) {

        return Topic.builder()
                .dataCriacao(topic.getDataCriacao())
                .mensagem(topic.getMensagem())
                .titulo(topic.getTitulo())
                .autor(autorService.findById(topic.getAutor().getId()))
                .course(courseService.findById(topic.getCourse().getId()))
                .build();
    }
}
