package com.example.apirestone.service;

import com.example.apirestone.model.Answers;
import com.example.apirestone.controller.dtos.request.AnswersPostReqBody;
import com.example.apirestone.controller.dtos.request.AnswersPutReqBody;
import com.example.apirestone.repository.AnswersRepository;
import com.example.apirestone.repository.TopicRepository;
import com.example.apirestone.repository.UsersRepository;
import org.springframework.stereotype.Service;

import javax.validation.ValidationException;
import java.util.List;

@Service
public class AnswersService {

    private final AnswersRepository answersRepository;

    private final UsersRepository usersRepository;

    private final TopicRepository topicRepository;

    public AnswersService(AnswersRepository answersRepository, UsersRepository usersRepository, TopicRepository topicRepository) {
        this.answersRepository = answersRepository;
        this.usersRepository = usersRepository;
        this.topicRepository = topicRepository;
    }

    public List<Answers> findAll() {
        return answersRepository.findAll();
    }

    public Answers findById(Long id) {
        return answersRepository.findById(id).orElseThrow(() -> new ValidationException("Could not find id"));
    }

    public Answers save(AnswersPostReqBody answersPostReqBody) {

        Answers answers = Answers.builder()
                .mensagem(answersPostReqBody.getMensagem())
                .dataCriacao(answersPostReqBody.getDataCriacao())
                .solucao(answersPostReqBody.getSolucao())
                .autor(usersRepository.findById(answersPostReqBody.getAutorId())
                        .orElseThrow(RuntimeException::new)).
                topics(topicRepository.findById(answersPostReqBody.getTopicsId())
                        .orElseThrow(RuntimeException::new)).build();

        return answersRepository.save(answers);

    }

    public void update(AnswersPutReqBody answersPutReqBody) {

        Answers savedAnswers = findById(answersPutReqBody.getId());

        Answers answers = Answers.builder()
                .id(answersPutReqBody.getId())
                .mensagem(answersPutReqBody.getMensagem())
                .dataCriacao(answersPutReqBody.getDataCriacao())
                .solucao(answersPutReqBody.getSolucao())
                .autor(usersRepository.findById(answersPutReqBody.getAutorId())
                        .orElseThrow(RuntimeException::new))
                .topics(topicRepository.findById(answersPutReqBody.getTopicsId())
                        .orElseThrow(RuntimeException::new)).build();
        answersRepository.save(answers);

    }

    public void delete(Long id) {
        answersRepository.deleteById(id);
    }

}
