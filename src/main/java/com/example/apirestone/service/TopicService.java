package com.example.apirestone.service;

import com.example.apirestone.exceptions.UserNotFoundException;
import com.example.apirestone.model.Topic;
import com.example.apirestone.controller.dtos.request.TopicPutReqDTO;
import com.example.apirestone.repository.AnswersRepository;
import com.example.apirestone.repository.CourseRepository;
import com.example.apirestone.repository.TopicRepository;
import com.example.apirestone.repository.UsersRepository;
import com.example.apirestone.service.factories.TopicFactory;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import javax.validation.ValidationException;
import java.util.List;

@Service
@RequiredArgsConstructor
public class TopicService {

    private final UsersRepository usersRepository;

    private final CourseRepository courseRepository;

    private final TopicRepository topicRepository;

    private final AnswersRepository answersRepository;

    private final TopicFactory  topicFactory;

    public List<Topic> findAll() {
        return topicRepository.findAll();
    }

    public Topic findById(Long id) {
        return topicRepository.findById(id)
                .orElseThrow(() -> new ValidationException("Could not find id"));
    }

    public List<Topic> findByTitulo(String titulo) {
        return topicRepository.findByTitulo(titulo);
    }

    public Topic save(final Topic topic) {
        return topicRepository.save(topicFactory.topicFactory(topic));
    }

    public void update(TopicPutReqDTO topicPutReqBody) {

        Topic savedTopic = findById(topicPutReqBody.getId());

        Topic topic = Topic.builder()
                .id(topicPutReqBody.getId())
                .dataCriacao(topicPutReqBody.getDataCriacao())
                .mensagem(topicPutReqBody.getMensagem())
                .titulo(topicPutReqBody.getTitulo())
                .autor(usersRepository.findById(topicPutReqBody.getAutorId())
                        .orElseThrow(UserNotFoundException::new))
                .course(courseRepository.findById(topicPutReqBody.getAutorId())
                        .orElseThrow(RuntimeException::new))
                .build();
        topicRepository.save(topic);

    }

    public void delete(Long id) {
        topicRepository.deleteById(id);
    }
}
