package com.example.apirestone.repository;

import com.example.apirestone.model.Answers;
import com.example.apirestone.model.Course;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CourseRepository extends JpaRepository<Course, Long> {

    List<Course> findByNome(String nome);



}
