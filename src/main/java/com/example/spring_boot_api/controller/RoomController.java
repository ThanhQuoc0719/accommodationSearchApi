package com.example.spring_boot_api.controller;

import com.example.spring_boot_api.entity.Room;
import com.example.spring_boot_api.service.RoomService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/rooms")
public class RoomController {

    @Autowired
    private RoomService roomService;

    @PostMapping
    public ResponseEntity<Room> addRoom(@RequestBody Room room) {
        Room newRoom = roomService.addRoom(room);
        return ResponseEntity.status(HttpStatus.CREATED).body(newRoom);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Room> updateRoom(@PathVariable Long id, @RequestBody Room room) {
        Room updatedRoom = roomService.updateRoom(id, room);
        return ResponseEntity.ok(updatedRoom);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteRoom(@PathVariable Long id) {
        roomService.deleteRoom(id);
        return ResponseEntity.noContent().build();
    }

    @GetMapping("/search")
    public ResponseEntity<List<Room>> searchRooms(@RequestParam String keyword) {
        List<Room> rooms = roomService.searchRooms(keyword);
        return ResponseEntity.ok(rooms);
    }

    @GetMapping
    public ResponseEntity<List<Room>> getAllRooms() {
        List<Room> rooms = roomService.getAllRooms();
        return ResponseEntity.ok(rooms);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Room> getRoomById(@PathVariable Long id) {
        Room room = roomService.getRoomById(id);
        return ResponseEntity.ok(room);
    }

    @PutMapping("/approve/{id}")
    public ResponseEntity<Room> approveRoom(@PathVariable Long id) {
        Room approvedRoom = roomService.approveRoom(id);
        return ResponseEntity.ok(approvedRoom);
    }

    @PutMapping("/deny/{id}")
    public ResponseEntity<Room> denyRoom(@PathVariable Long id) {
        Room deniedRoom = roomService.denyRoom(id);
        return ResponseEntity.ok(deniedRoom);
    }

    @GetMapping("/category/{categoryId}")
    public ResponseEntity<List<Room>> getRoomsByCategory(@PathVariable Long categoryId) {
        List<Room> rooms = roomService.getRoomsByCategory(categoryId);
        return ResponseEntity.ok(rooms);
    }

    @GetMapping("/user/{userId}")
    public ResponseEntity<List<Room>> getRoomsByUser(@PathVariable Long userId) {
        List<Room> rooms = roomService.getRoomsByUser(userId);
        return ResponseEntity.ok(rooms);
    }

    @GetMapping("/searchByUserAndKeyword")
    public ResponseEntity<List<Room>> searchRoomsByUserAndKeyword(@RequestParam Long userId, @RequestParam String keyword) {
        List<Room> rooms = roomService.searchRoomsByUserAndKeyword(userId, keyword);
        return ResponseEntity.ok(rooms);
    }

}
