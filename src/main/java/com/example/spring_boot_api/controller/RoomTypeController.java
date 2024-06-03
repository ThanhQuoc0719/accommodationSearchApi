package com.example.spring_boot_api.controller;

import com.example.spring_boot_api.entity.RoomType;
import com.example.spring_boot_api.service.RoomTypeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/roomTypes")
public class RoomTypeController {

    @Autowired
    private RoomTypeService roomTypeService;

    @PostMapping
    public ResponseEntity<RoomType> addRoomType(@RequestBody RoomType roomType) {
        RoomType newRoomType = roomTypeService.addRoomType(roomType);
        return ResponseEntity.status(HttpStatus.CREATED).body(newRoomType);
    }

    @PutMapping("/{id}")
    public ResponseEntity<RoomType> updateRoomType(@PathVariable Long id, @RequestBody RoomType roomType) {
        RoomType updatedRoomType = roomTypeService.updateRoomType(id, roomType);
        return ResponseEntity.ok(updatedRoomType);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteRoomType(@PathVariable Long id) {
        roomTypeService.deleteRoomType(id);
        return ResponseEntity.noContent().build();
    }

    @GetMapping("/{id}")
    public ResponseEntity<RoomType> getRoomTypeById(@PathVariable Long id) {
        RoomType roomType = roomTypeService.getRoomTypeById(id);
        return ResponseEntity.ok(roomType);
    }

    @GetMapping
    public ResponseEntity<List<RoomType>> getAllRoomTypes() {
        List<RoomType> roomTypes = roomTypeService.getAllRoomTypes();
        return ResponseEntity.ok(roomTypes);
    }

    @GetMapping("/search")
    public ResponseEntity<List<RoomType>> searchRoomTypes(@RequestParam String keyword) {
        List<RoomType> roomTypes = roomTypeService.searchRoomTypes(keyword);
        return ResponseEntity.ok(roomTypes);
    }

    @GetMapping("/user/{userId}")
    public ResponseEntity<List<RoomType>> getRoomTypesByUser(@PathVariable Long userId) {
        List<RoomType> roomTypes = roomTypeService.getRoomTypesByUser(userId);
        return ResponseEntity.ok(roomTypes);
    }

    @GetMapping("/room/{roomId}")
    public ResponseEntity<List<RoomType>> getRoomTypesByRoomId(@PathVariable Long roomId) {
        List<RoomType> roomTypes = roomTypeService.getRoomTypesByRoomId(roomId);
        return ResponseEntity.ok(roomTypes);
    }
}
