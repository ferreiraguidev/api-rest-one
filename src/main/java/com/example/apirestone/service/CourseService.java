package com.example.apirestone.service;

import com.example.apirestone.model.Course;
import com.example.apirestone.controller.dtos.request.CoursePostReqBody;
import com.example.apirestone.controller.dtos.request.CoursePutReqBody;
import com.example.apirestone.repository.CourseRepository;
import org.springframework.stereotype.Service;

import javax.validation.ValidationException;
import java.util.List;

@Service
public class CourseService {

    private  final CourseRepository courseRepository;


    public CourseService(CourseRepository courseRepository) {
        this.courseRepository = courseRepository;

    }

    public List<Course> findAll() {
        return courseRepository.findAll();
    }

    public Course findById(Long id) {
        return courseRepository.findById(id)
                .orElseThrow(() -> new ValidationException("Could not find id"));
    }

    public List<Course> findByNome(String nome) {
        return courseRepository.findByNome(nome);
    }

    public Course save(CoursePostReqBody coursePostReqBody) {

        Course course = Course.builder()
                .nome(coursePostReqBody.getNome())
                .categoria(coursePostReqBody.getCategoria())
                .build();
        return courseRepository.save(course);

    }
    public void update(CoursePutReqBody coursePutReqBody){

        Course savedCourse = findById(coursePutReqBody.getId());

        Course topic = Course.builder()
                .id(coursePutReqBody.getId())
                .nome(coursePutReqBody.getNome())
                .categoria(coursePutReqBody.getCategoria())
                .build();
        courseRepository.save(topic);
    }
    public void delete(Long id){
        courseRepository.deleteById(id);
    }

}
