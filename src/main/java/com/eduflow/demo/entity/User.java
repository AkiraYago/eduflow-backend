package com.eduflow.demo.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity(name = "eduflow_user")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class User {
    @Id @GeneratedValue
    private Long id;

    @NotBlank
    @Size(max = 50, message = "El nombre de usuario no debe contener más de 50 carácteres")
    private String name;

    @NotBlank
    @Email
    @Size(max = 50, message = "El email no debe tener más 50 carácteres")
    private String email;

    @NotBlank
    @Size(min = 8, max = 50, message = "La contraseña debe tener más de 8 carácteres")
    private String password;
}
