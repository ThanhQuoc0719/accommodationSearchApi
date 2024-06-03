package com.example.spring_boot_api.repository;

import com.example.spring_boot_api.entity.RoomReview;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface RoomReviewRepository extends JpaRepository<RoomReview, Long> {
    List<RoomReview> findByRoomId(Long roomId);
}
