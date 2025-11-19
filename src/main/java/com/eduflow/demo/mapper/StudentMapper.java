package com.eduflow.demo.mapper;

import com.eduflow.demo.dto.StudentDTO;
import com.eduflow.demo.entity.Student;

public class StudentMapper {
    public static StudentDTO toDTO(Student student) {
        if (student == null) return null;

        return StudentDTO.builder()
        .id(student.getId())
        .user(UserMapper.toDTO(student.getUser()))
        .build();
    }
}
