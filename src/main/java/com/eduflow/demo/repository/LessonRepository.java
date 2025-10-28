package com.eduflow.demo.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.eduflow.demo.entity.Lesson;

public interface LessonRepository extends JpaRepository<Lesson, Long> {
    List<Lesson> findByCourseId(Long courseId);
}
