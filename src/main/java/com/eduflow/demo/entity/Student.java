package com.eduflow.demo.entity;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToOne;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Student {
    @Id @GeneratedValue
    private Long id;

    @OneToOne(
        cascade = CascadeType.PERSIST
    )
    @JoinColumn(
        name = "user_id",
        referencedColumnName = "id"
    )
    private User user;
}
