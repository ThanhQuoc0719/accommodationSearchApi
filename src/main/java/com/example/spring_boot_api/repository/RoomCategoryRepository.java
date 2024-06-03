package com.example.spring_boot_api.repository;

import com.example.spring_boot_api.entity.RoomCategory;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface RoomCategoryRepository extends JpaRepository<RoomCategory, Long> {
    List<RoomCategory> findByNameContainingIgnoreCase(String keyword);
}
