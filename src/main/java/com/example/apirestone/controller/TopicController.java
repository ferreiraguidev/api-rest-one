package com.example.apirestone.controller;

import com.example.apirestone.controller.dtos.request.TopicPostReqDTO;
import com.example.apirestone.controller.mappers.TopicMapper;
import com.example.apirestone.model.Topic;
import com.example.apirestone.controller.dtos.request.TopicPutReqDTO;
import com.example.apirestone.service.TopicService;
import lombok.RequiredArgsConstructor;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RequiredArgsConstructor
@RestController
@RequestMapping("/v1")
public class TopicController {

    private final TopicService topicService;

    private final TopicMapper topicMapper;

    // look for Paginator...
    @ResponseStatus(HttpStatus.OK)
    @GetMapping("/topics")
    @Cacheable(value = "topicos")
    public List<Topic> list() {
        return topicService.findAll();
    }

    @ResponseStatus(HttpStatus.CREATED)
    @PostMapping("topics/new")
    @CacheEvict(value = "topicos", allEntries = true)
    public Topic save(@RequestBody @Valid final TopicPostReqDTO topic) {
        return topicService.save(topicMapper.toDomain(topic));
    }


    @ResponseStatus(HttpStatus.OK)
    @RequestMapping(value = "topic/{id}", method = RequestMethod.GET)
    @CacheEvict(value = "topicos", allEntries = true)
    public ResponseEntity<Topic> findById(@PathVariable Long id) {
        return ResponseEntity.ok(topicService.findById(id));
    }

    @RequestMapping(value = "topics/{titulo}", method = RequestMethod.GET)
    @CacheEvict(value = "topicos", allEntries = true)
    public ResponseEntity<List<Topic>> findByTitulo(@PathVariable String titulo) {
        return ResponseEntity.ok(topicService.findByTitulo(titulo));
    }

    @PutMapping("topics")
    public ResponseEntity<Void> update(@Valid @RequestBody TopicPutReqDTO topicPutReqBody) {
        topicService.update(topicPutReqBody);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @DeleteMapping(path = "/topics/{id}")
    @CacheEvict(value = "topicos", allEntries = true)
    public ResponseEntity<Void> delete(@PathVariable Long id) {
        topicService.delete(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
}
