package com.eduflow.demo.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Course {
    @Id @GeneratedValue
    private Long id;
    private String title;
    private String description;
    private Double rating;
    private String category; // name

    @ManyToOne
    private User instructor; // name, description
}
