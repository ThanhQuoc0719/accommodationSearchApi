package com.example.spring_boot_api.service;

import com.example.spring_boot_api.entity.RoomCategory;
import com.example.spring_boot_api.repository.RoomCategoryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Service
@Transactional
public class RoomCategoryService {
    @Autowired
    private RoomCategoryRepository roomCategoryRepository;

    public RoomCategory createRoomCategory(RoomCategory roomCategory) {
        return roomCategoryRepository.save(roomCategory);
    }

    public RoomCategory updateRoomCategory(Long id, RoomCategory roomCategory) {
        Optional<RoomCategory> existingRoomCategoryOptional = roomCategoryRepository.findById(id);
        if (existingRoomCategoryOptional.isPresent()) {
            RoomCategory existingRoomCategory = existingRoomCategoryOptional.get();
            existingRoomCategory.setName(roomCategory.getName());
            existingRoomCategory.setDescription(roomCategory.getDescription());
            return roomCategoryRepository.save(existingRoomCategory);
        } else {
            throw new RuntimeException("Room category not found with id: " + id);
        }
    }

    public void deleteRoomCategory(Long id) {
        roomCategoryRepository.deleteById(id);
    }

    public List<RoomCategory> searchRoomCategories(String keyword) {
        if (keyword != null) {
            return roomCategoryRepository.findByNameContainingIgnoreCase(keyword);
        } else {
            return roomCategoryRepository.findAll();
        }
    }

    public List<RoomCategory> getAllRoomCategories() {
        return roomCategoryRepository.findAll();
    }

    public RoomCategory getRoomCategoryById(Long id) {
        return roomCategoryRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Room category not found with id: " + id));
    }
}
