package com.example.demo.model;

import com.example.demo.Enums.Role;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor

public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    private Role role;
    private String name;
    private String password;
    private String email;
    @OneToOne (cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    private Cart cart;

}
