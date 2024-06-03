package com.example.spring_boot_api.repository;

import com.example.spring_boot_api.entity.RoomType;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface RoomTypeRepository extends JpaRepository<RoomType, Long> {
    List<RoomType> findByNameContainingIgnoreCase(String keyword);
    List<RoomType> findByUserId(Long userId);
    List<RoomType> findByRoomId(Long roomId);

}
