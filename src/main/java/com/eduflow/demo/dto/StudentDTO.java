package com.eduflow.demo.dto;

import lombok.Builder;

@Builder
public record StudentDTO(Long id, UserDTO user) {}
