package com.example.spring_boot_api.service;

import com.example.spring_boot_api.entity.Room;
import com.example.spring_boot_api.entity.RoomReview;
import com.example.spring_boot_api.entity.User;
import com.example.spring_boot_api.repository.RoomRepository;
import com.example.spring_boot_api.repository.RoomReviewRepository;
import com.example.spring_boot_api.repository.UserRepository;
import com.example.spring_boot_api.response.RoomReviewDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class RoomReviewService {

    @Autowired
    private RoomReviewRepository roomReviewRepository;

    @Autowired
    private RoomRepository roomRepository;

    @Autowired
    private UserRepository userRepository;

    public void addRoomReview(Long roomId, RoomReviewDTO roomReviewDTO) {
        Room room = roomRepository.findById(roomId).orElseThrow(() -> new RuntimeException("Room not found"));
        User user = userRepository.findById(roomReviewDTO.getUserId()).orElseThrow(() -> new RuntimeException("User not found"));

        RoomReview roomReview = new RoomReview();
        roomReview.setComment(roomReviewDTO.getComment());
        roomReview.setRating(roomReviewDTO.getRating());
        roomReview.setUser(user);
        roomReview.setRoom(room);

        roomReviewRepository.save(roomReview);
    }

    public List<RoomReview> getRoomReviews(Long roomId) {
        return roomReviewRepository.findByRoomId(roomId);
    }
}

