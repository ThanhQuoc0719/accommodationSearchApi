package com.example.spring_boot_api.service;
import org.springframework.transaction.annotation.Transactional;

import com.example.spring_boot_api.entity.Bookmark;
import com.example.spring_boot_api.entity.Room;
import com.example.spring_boot_api.entity.User;
import com.example.spring_boot_api.repository.BookmarkRepository;
import com.example.spring_boot_api.repository.RoomRepository;
import com.example.spring_boot_api.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BookmarkService {
    @Autowired
    private BookmarkRepository bookmarkRepository;

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private RoomRepository roomRepository;

    public void bookmarkRoom(Long userId, Long roomId) {
        User user = userRepository.findById(userId).orElseThrow(() -> new RuntimeException("User not found"));
        Room room = roomRepository.findById(roomId).orElseThrow(() -> new RuntimeException("Room not found"));

        if (!bookmarkRepository.existsByUserAndRoom(user, room)) {
            Bookmark bookmark = new Bookmark();
            bookmark.setUser(user);
            bookmark.setRoom(room);
            bookmarkRepository.save(bookmark);
        }
    }
    @Transactional
    public void unbookmarkRoom(Long userId, Long roomId) {
        User user = userRepository.findById(userId).orElseThrow(() -> new RuntimeException("User not found"));
        Room room = roomRepository.findById(roomId).orElseThrow(() -> new RuntimeException("Room not found"));

        bookmarkRepository.deleteByUserAndRoom(user, room);
    }

    public List<Bookmark> getBookmarksByUser(Long userId) {
        User user = userRepository.findById(userId).orElseThrow(() -> new RuntimeException("User not found"));
        return bookmarkRepository.findByUser(user);
    }
}
