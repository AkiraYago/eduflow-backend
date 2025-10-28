package com.eduflow.demo.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.eduflow.demo.entity.Enrollment;

public interface EnrollmentRepository extends JpaRepository<Enrollment, Long> {
    List<Enrollment> findByStudentId(Long studentId);
    List<Enrollment> findByCourseId(Long courseId);
}
