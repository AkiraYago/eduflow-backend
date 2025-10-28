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
public class Enrollment {
    @Id @GeneratedValue
    private Long id;

    @ManyToOne
    private User student;

    @ManyToOne
    private Course course;
}
