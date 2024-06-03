package com.example.spring_boot_api.response;

import lombok.Data;

@Data
public class RoomReviewDTO {
    private String comment;
    private int rating;
    private Long userId;
}

