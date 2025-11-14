package com.eduflow.demo.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.EntityGraph;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.eduflow.demo.entity.Student;

@Repository
public interface StudentRepository extends JpaRepository<Student, Long> {
    @Override
    @EntityGraph(attributePaths = {"user"})
    List<Student> findAll();

    @EntityGraph(attributePaths = {"user"})
    Optional<Student> findById(Long id);
}
