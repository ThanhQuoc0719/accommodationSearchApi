package com.example.spring_boot_api.service;

import com.example.spring_boot_api.entity.Room;

import java.util.List;

public interface RoomService {
    Room addRoom(Room room);
    Room updateRoom(Long id, Room room);
    void deleteRoom(Long id);
    List<Room> searchRooms(String keyword);
    List<Room> getAllRooms();
    Room getRoomById(Long id);
    Room approveRoom(Long id);
    Room denyRoom(Long id);
    List<Room> getRoomsByCategory(Long categoryId);
    List<Room> getRoomsByUser(Long userId);
    List<Room> searchRoomsByUserAndKeyword(Long userId, String keyword);
}
