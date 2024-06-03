package com.example.spring_boot_api.entity;

import javax.persistence.*;
import java.io.Serializable;
import lombok.*;

@Entity
@Table(name = "users")
@Data
public class User implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false, unique = true)
    private String username;

    @Column(nullable = false)
    private String password;

    @Column(nullable = false)
    private String role;
    private boolean locked;
    private String email;
    private String phoneNumber;
    private String avatar;
    private String selfIntroduction;
}

