package com.example.spring_boot_api.controller;

import com.example.spring_boot_api.entity.RoomCategory;
import com.example.spring_boot_api.service.RoomCategoryService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/room-categories")
@Api(tags = "Room Category Management")
public class RoomCategoryController {

    @Autowired
    private RoomCategoryService roomCategoryService;

    @PostMapping("/create")
    public ResponseEntity<RoomCategory> createRoomCategory(@RequestBody RoomCategory roomCategory) {
        RoomCategory createdRoomCategory = roomCategoryService.createRoomCategory(roomCategory);
        return new ResponseEntity<>(createdRoomCategory, HttpStatus.CREATED);
    }

    @PutMapping("/update/{id}")
    public ResponseEntity<RoomCategory> updateRoomCategory(@PathVariable Long id, @RequestBody RoomCategory roomCategory) {
        RoomCategory updatedRoomCategory = roomCategoryService.updateRoomCategory(id, roomCategory);
        return new ResponseEntity<>(updatedRoomCategory, HttpStatus.OK);
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<?> deleteRoomCategory(@PathVariable Long id) {
        roomCategoryService.deleteRoomCategory(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }

    @GetMapping("/search")
    public ResponseEntity<List<RoomCategory>> searchRoomCategories(@RequestParam(required = false) String keyword) {
        List<RoomCategory> roomCategories = roomCategoryService.searchRoomCategories(keyword);
        return new ResponseEntity<>(roomCategories, HttpStatus.OK);
    }

    @GetMapping("/all")
    public ResponseEntity<List<RoomCategory>> getAllRoomCategories() {
        List<RoomCategory> roomCategories = roomCategoryService.getAllRoomCategories();
        return new ResponseEntity<>(roomCategories, HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<RoomCategory> getRoomCategoryById(@PathVariable Long id) {
        RoomCategory roomCategory = roomCategoryService.getRoomCategoryById(id);
        return new ResponseEntity<>(roomCategory, HttpStatus.OK);
    }
}

