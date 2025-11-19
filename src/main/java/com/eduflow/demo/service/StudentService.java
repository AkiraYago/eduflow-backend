package com.eduflow.demo.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.eduflow.demo.dto.StudentDTO;
import com.eduflow.demo.entity.Student;
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
        return StudentMapper.toDTO(studentRepository.findById(id).orElse(null));
    }

    public StudentDTO saveStudent(Student student) {
        return StudentMapper.toDTO(studentRepository.save(student));
    }

    public StudentDTO updateStudent(Long id, Student studentDetails) {
        Student student = studentRepository.findById(id)
        .orElseThrow(() -> new RuntimeException("Student not found with id: " + id));

        student.setUser(studentDetails.getUser());

        return StudentMapper.toDTO(studentRepository.save(student));
    }

    public void deleteStudent(Long id) {
        studentRepository.deleteById(id);
    }
}
