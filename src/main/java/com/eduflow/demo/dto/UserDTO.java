package com.eduflow.demo.dto;

import lombok.Builder;

@Builder
public record UserDTO(Long id, String name, String email) {}
