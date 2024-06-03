package com.example.spring_boot_api.controller;

import com.example.spring_boot_api.entity.User;
import com.example.spring_boot_api.request.UserStatusRequest;
import com.example.spring_boot_api.request.UserUpdateRequest;
import com.example.spring_boot_api.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/users")
public class UserController {

    @Autowired
    private UserService userService;

    @GetMapping
    public ResponseEntity<List<User>> getAllUsers() {
        List<User> users = userService.getAllUsers();
        return ResponseEntity.ok(users);
    }

    @GetMapping("/{userId}")
    public ResponseEntity<User> getUserById(@PathVariable Long userId) {
        User user = userService.getUserById(userId);
        return ResponseEntity.ok(user);
    }

    @PutMapping("/{userId}/status")
    public ResponseEntity<User> updateUserStatus(@PathVariable Long userId, @RequestBody UserStatusRequest request) {
        User updatedUser = userService.updateUserStatus(userId, request.isLocked());
        return ResponseEntity.ok(updatedUser);
    }

    @PutMapping("/{userId}")
    public ResponseEntity<User> updateUser(@PathVariable Long userId, @RequestBody UserUpdateRequest request) {
        User updatedUser = userService.updateUser(userId, request);
        return ResponseEntity.ok(updatedUser);
    }
}
