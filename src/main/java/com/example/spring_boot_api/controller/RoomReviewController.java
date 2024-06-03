package com.example.spring_boot_api.controller;

import com.example.spring_boot_api.entity.RoomReview;
import com.example.spring_boot_api.response.RoomReviewDTO;
import com.example.spring_boot_api.service.RoomReviewService;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/room-reviews")
public class RoomReviewController {

    @Autowired
    private RoomReviewService roomReviewService;

    @PostMapping("/{roomId}")
    public ResponseEntity<String> addRoomReview(@PathVariable Long roomId, @RequestBody RoomReviewDTO roomReviewDTO) {
        roomReviewService.addRoomReview(roomId, roomReviewDTO);
        return ResponseEntity.ok("Room review added successfully.");
    }

    @GetMapping("/room/{roomId}")
    public ResponseEntity<List<RoomReview>> getRoomReviews(@PathVariable Long roomId) {
        List<RoomReview> roomReviews = roomReviewService.getRoomReviews(roomId);
        return ResponseEntity.ok(roomReviews);
    }
}

