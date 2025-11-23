package com.eduflow.demo.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.eduflow.demo.dto.StudentDTO;
import com.eduflow.demo.entity.Student;
import com.eduflow.demo.exception.NotFoundException;
import com.eduflow.demo.mapper.StudentMapper;
import com.eduflow.demo.repository.StudentRepository;

@Service
public class StudentService {
    @Autowired
    private StudentRepository studentRepository;

    public List<StudentDTO> getAllStudents() {
        return studentRepository.findAll().stream().map(StudentMapper::toDTO).toList();
    }

    public StudentDTO getStudentById(Long id) {
        Student studentFound = studentRepository.findById(id)
        .orElseThrow(() -> new NotFoundException("Student not found"));

        return StudentMapper.toDTO(studentFound);
    }

    public StudentDTO saveStudent(Student student) {
        // TODO: Crear "CreateStudentRequest"
        return StudentMapper.toDTO(studentRepository.save(student));
    }

    public void deleteStudent(Long id) {
        studentRepository.findById(id)
        .orElseThrow(() -> new NotFoundException("Student not found"));

        studentRepository.deleteById(id);
    }
}
