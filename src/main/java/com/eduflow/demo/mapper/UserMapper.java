package com.eduflow.demo.mapper;

import com.eduflow.demo.dto.UserDTO;
import com.eduflow.demo.entity.User;

public class UserMapper {
    public static UserDTO toDTO(User user) {
        if (user == null) return null;

        return UserDTO.builder()
        .id(user.getId())
        .name(user.getName())
        .email(user.getEmail())
        .build();
    }
}
