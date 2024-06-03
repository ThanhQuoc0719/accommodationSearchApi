package com.example.spring_boot_api.entity;
import lombok.Data;

import javax.persistence.*;
@Entity
@Data
public class RoomReview {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String comment;
    private int rating;

    @ManyToOne
    @JoinColumn(name = "user_id")
    private User user;

    @ManyToOne
    @JoinColumn(name = "room_id")
    private Room room;


}
