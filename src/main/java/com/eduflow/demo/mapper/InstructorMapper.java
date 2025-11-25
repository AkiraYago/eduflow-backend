package com.eduflow.demo.mapper;

import com.eduflow.demo.dto.InstructorDTO;
import com.eduflow.demo.entity.Instructor;

public class InstructorMapper {
    public static InstructorDTO toDTO(Instructor instructor) {
        if (instructor == null) return null;

        return InstructorDTO.builder()
                .id(instructor.getId())
                .description(instructor.getDescription())
                .rating(instructor.getRating())
                .user(UserMapper.toDTO(instructor.getUser()))
                .build();
    }
}
