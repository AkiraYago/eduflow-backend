package com.eduflow.demo.dto;

import lombok.Builder;

@Builder
public record InstructorDTO(Long id, String description, Double rating, UserDTO user) {}
