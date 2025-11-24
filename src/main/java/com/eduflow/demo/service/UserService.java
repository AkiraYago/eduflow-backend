package com.eduflow.demo.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;

import com.eduflow.demo.repository.UserRepository;
import com.eduflow.demo.dto.UserDTO;
import com.eduflow.demo.entity.User;
import com.eduflow.demo.mapper.UserMapper;

@Service
public class UserService {
    @Autowired
    private UserRepository userRepository;

    public List<UserDTO> getAllUsers() {
        return userRepository.findAll().stream().map(UserMapper::toDTO).toList();
    }

    public UserDTO getUserById(Long id) {
        return UserMapper.toDTO(userRepository.findById(id).orElse(null));
    }

    public UserDTO createUser(User user) {
        return UserMapper.toDTO(userRepository.save(user));
    }

    public UserDTO updateUser(Long id, User userDetails) {
        User user = userRepository.findById(id)
            .orElseThrow(() -> new RuntimeException("User not found with id: " + id));

        user.setName(userDetails.getName());
        user.setEmail(userDetails.getEmail());
        user.setPassword(userDetails.getPassword());

        return UserMapper.toDTO(userRepository.save(user));
    }

    public void deleteUser(Long id) {
        User user = userRepository.findById(id)
            .orElseThrow(() -> new RuntimeException("User not found with id: " + id));
        userRepository.delete(user);
    }
}
