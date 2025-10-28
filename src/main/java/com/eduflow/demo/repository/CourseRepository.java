package com.eduflow.demo.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.eduflow.demo.entity.Course;

public interface CourseRepository extends JpaRepository<Course, Long> {
    
}
