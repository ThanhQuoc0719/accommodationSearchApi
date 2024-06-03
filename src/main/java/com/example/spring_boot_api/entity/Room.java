package com.example.spring_boot_api.entity;

import lombok.Data;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import javax.persistence.*;
import java.time.Instant;
import java.util.Date;
import java.util.List;

@Entity
@Data
public class Room {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "id_user")
    private User user;

    private String city;
    private String ward;
    private String preciseAddress;
    private Double latitude;
    private Double longitude;

    @ManyToOne
    @JoinColumn(name = "category_id")
    private RoomCategory category;

    private String title;
    private String description;
    private String contactInfo;
    private double price;
    private double area;

    @ElementCollection
    private List<String> images;

    @ElementCollection
    private List<String> videos;

    @ElementCollection
    private List<String> amenities;

    private String target;

    private boolean approved;
    private double minPrice;
    private double maxPrice;
    private double minArea;
    private double maxArea;
    private double quantity;
    @CreationTimestamp
    @Column(name = "created_at", updatable = false)
    private Instant createdAt;
    @UpdateTimestamp
    @Column(name = "updated_at")
    private Instant updatedAt;
}
