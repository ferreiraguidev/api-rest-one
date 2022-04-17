package com.example.apirestone.controller;

import com.example.apirestone.controller.dtos.request.AnswersPostReqBody;
import com.example.apirestone.controller.dtos.request.AnswersPutReqBody;
import com.example.apirestone.model.*;
import com.example.apirestone.service.AnswersService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RequiredArgsConstructor
@RestController
@RequestMapping("/v3")
public class AnswersController {

    private final AnswersService answersService;

    @ResponseStatus(HttpStatus.OK)
    @GetMapping("/answers")
    public List<Answers> list() {
        return answersService.findAll();
    }

    @ResponseStatus(HttpStatus.CREATED)
    @PostMapping("answers/new")
    public ResponseEntity<Answers> save(@RequestBody @Valid AnswersPostReqBody answersPostReqBody) {
        answersService.save(answersPostReqBody);
        return new ResponseEntity<>(answersService.save(answersPostReqBody), HttpStatus.CREATED);
    }

    @ResponseStatus(HttpStatus.OK)
    @RequestMapping(value = "answer/{id}", method = RequestMethod.GET)
    public ResponseEntity<Answers> findById(@PathVariable Long id) {
        return ResponseEntity.ok(answersService.findById(id));
    }

    @PutMapping("answers")
    public ResponseEntity<Void> update(@Valid @RequestBody AnswersPutReqBody answersPutReqBody) {
        answersService.update(answersPutReqBody);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @DeleteMapping(path = "/answers/{id}")
    public ResponseEntity<Void> delete(@PathVariable Long id) {
        answersService.delete(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
}
