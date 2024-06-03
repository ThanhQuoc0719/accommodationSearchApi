package com.example.spring_boot_api.controller;

import com.example.spring_boot_api.entity.Bookmark;
import com.example.spring_boot_api.service.BookmarkService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/bookmarks")
public class BookmarkController {

    @Autowired
    private BookmarkService bookmarkService;

    @PostMapping("/bookmark")
    public void bookmarkRoom(@RequestParam Long userId, @RequestParam Long roomId) {
        bookmarkService.bookmarkRoom(userId, roomId);
    }

    @DeleteMapping("/unbookmark")
    public void unbookmarkRoom(@RequestParam Long userId, @RequestParam Long roomId) {
        bookmarkService.unbookmarkRoom(userId, roomId);
    }

    @GetMapping("/user/{userId}")
    public List<Bookmark> getBookmarksByUser(@PathVariable Long userId) {
        return bookmarkService.getBookmarksByUser(userId);
    }
}
