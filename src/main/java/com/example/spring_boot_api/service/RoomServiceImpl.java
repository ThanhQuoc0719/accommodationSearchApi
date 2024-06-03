package com.example.spring_boot_api.service;

import com.example.spring_boot_api.entity.Room;
import com.example.spring_boot_api.repository.RoomRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class RoomServiceImpl implements RoomService {

    @Autowired
    private RoomRepository roomRepository;

    @Override
    public Room addRoom(Room room) {
        return roomRepository.save(room);
    }

    @Override
    public Room updateRoom(Long id, Room room) {
        room.setId(id);
        return roomRepository.save(room);
    }

    @Override
    public void deleteRoom(Long id) {
        roomRepository.deleteById(id);
    }

    @Override
    public List<Room> searchRooms(String keyword) {
        // Implement search logic based on your requirements
        return roomRepository.findByTitleContainingIgnoreCase(keyword);
    }

    @Override
    public List<Room> getAllRooms() {
        return roomRepository.findAll();
    }

    @Override
    public Room getRoomById(Long id) {
        Optional<Room> roomOptional = roomRepository.findById(id);
        return roomOptional.orElse(null);
    }

    @Override
    public Room approveRoom(Long id) {
        Room room = getRoomById(id);
        if (room != null) {
            room.setApproved(true);
            return roomRepository.save(room);
        }
        return null;
    }

    @Override
    public Room denyRoom(Long id) {
        Room room = getRoomById(id);
        if (room != null) {
            room.setApproved(false);
            return roomRepository.save(room);
        }
        return null;
    }

    @Override
    public List<Room> getRoomsByCategory(Long categoryId) {
        return roomRepository.findByCategoryId(categoryId);
    }

    @Override
    public List<Room> getRoomsByUser(Long userId) {
        return roomRepository.findByUserId(userId);
    }

    @Override
    public List<Room> searchRoomsByUserAndKeyword(Long userId, String keyword) {
        return roomRepository.findByUserIdAndTitleContainingIgnoreCase(userId, keyword);
    }

}
