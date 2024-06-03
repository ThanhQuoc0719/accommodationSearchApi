package com.example.spring_boot_api.repository;

import com.example.spring_boot_api.entity.Room;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface RoomRepository extends JpaRepository<Room, Long> {
    List<Room> findByTitleContainingIgnoreCase(String keyword);
    List<Room> findByCategoryId(Long categoryId);
    List<Room> findByUserId(Long userId);
    List<Room> findByUserIdAndTitleContainingIgnoreCase(Long userId, String keyword);


}
