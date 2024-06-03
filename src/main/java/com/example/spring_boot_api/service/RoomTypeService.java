package com.example.spring_boot_api.service;

import com.example.spring_boot_api.entity.RoomType;

import java.util.List;

public interface RoomTypeService {
    RoomType addRoomType(RoomType roomType);
    RoomType updateRoomType(Long id, RoomType roomType);
    void deleteRoomType(Long id);
    RoomType getRoomTypeById(Long id);
    List<RoomType> getAllRoomTypes();
    List<RoomType> searchRoomTypes(String keyword);
    List<RoomType> getRoomTypesByUser(Long userId);
    List<RoomType> getRoomTypesByRoomId(Long roomId);

}
