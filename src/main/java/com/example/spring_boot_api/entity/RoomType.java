package com.example.spring_boot_api.entity;

import lombok.Data;

import javax.persistence.*;
import java.util.List;

@Entity
@Data
public class RoomType {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "room_id")
    private Room room;

    private String name;
    private double price;
    private double area;
    private String description;

    @ElementCollection
    private List<String> amenities;

    private String status;

    @ElementCollection
    private List<String> images;

    @ManyToOne
    @JoinColumn(name = "user_id")
    private User user;
}
