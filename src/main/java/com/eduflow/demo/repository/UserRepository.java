package com.eduflow.demo.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.eduflow.demo.entity.User;

public interface UserRepository extends JpaRepository<User, Long> {
    
}
