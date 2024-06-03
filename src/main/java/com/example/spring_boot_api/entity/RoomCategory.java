package com.example.spring_boot_api.entity;

import lombok.Data;

import javax.persistence.*;

@Entity
@Table(name = "room_categories")
@Data
public class RoomCategory {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false, unique = true)
    private String name;

    private String description;

}
