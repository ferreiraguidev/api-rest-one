package com.example.apirestone.controller;

import com.example.apirestone.model.Course;
import com.example.apirestone.controller.dtos.request.CoursePostReqBody;
import com.example.apirestone.controller.dtos.request.CoursePutReqBody;
import com.example.apirestone.service.CourseService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RequiredArgsConstructor
@RestController
@RequestMapping("/v2")
public class CourseController {

    private final CourseService courseService;

    @ResponseStatus(HttpStatus.OK)
    @GetMapping("/courses")
    public List<Course> list() {
        return courseService.findAll();
    }

    @ResponseStatus(HttpStatus.CREATED)
    @PostMapping("courses/new")
    public ResponseEntity<Course> save(@RequestBody @Valid CoursePostReqBody coursePostReqBody) {
        return new ResponseEntity<>(courseService.save(coursePostReqBody), HttpStatus.CREATED);
    }

    @ResponseStatus(HttpStatus.OK)
    @RequestMapping(value = "course/{id}", method = RequestMethod.GET)
    public ResponseEntity<Course> findById(@PathVariable Long id) {
        return ResponseEntity.ok(courseService.findById(id));
    }

    @RequestMapping(value = "courses/{nome}", method = RequestMethod.GET)
    public ResponseEntity<List<Course>> findByNome(@PathVariable String nome) {
        return ResponseEntity.ok(courseService.findByNome(nome));
    }

    @PutMapping("courses")
    public ResponseEntity<Void> update(@Valid @RequestBody CoursePutReqBody coursePutReqBody) {
        courseService.update(coursePutReqBody);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @DeleteMapping(path = "/courses/{id}")
    public ResponseEntity<Void> delete(@PathVariable Long id) {
        courseService.delete(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
}
