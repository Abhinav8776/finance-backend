package com.example.finance_backend.entity;
import jakarta.persistence.*;
import lombok.*;


@Entity
@Data
@Table(name = "users")
@NoArgsConstructor
@AllArgsConstructor
public class User {

    @Id
    @GeneratedValue
    private Long id;

    private String username;
    private String password;

    @Enumerated(EnumType.STRING)
    private Role role;

    private boolean active;

}
