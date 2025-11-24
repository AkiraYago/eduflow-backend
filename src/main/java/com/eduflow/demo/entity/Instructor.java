package com.eduflow.demo.entity;

import jakarta.persistence.*;
import jakarta.validation.Valid;
import jakarta.validation.constraints.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@NoArgsConstructor
@AllArgsConstructor
@Data
public class Instructor {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Size(min = 3, max = 255, message = "La descripción debe tener entre 3 y 255 carácteres")
    private String description;

    @Positive
    @DecimalMin(value = "1.0", message = "El rating debe tener un valor igual o mayor a 1.0")
    @DecimalMax(value = "5.0", message = "El rating debe tener un valor igual o menor a 5.0")
    private Double rating;

    @Valid
    @OneToOne(
            cascade = CascadeType.PERSIST
    )
    @JoinColumn(
            name = "user_id",
            referencedColumnName = "id"
    )
    private User user;
}
