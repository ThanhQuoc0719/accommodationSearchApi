package com.example.spring_boot_api.repository;

import com.example.spring_boot_api.entity.Bookmark;
import com.example.spring_boot_api.entity.Room;
import com.example.spring_boot_api.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface BookmarkRepository extends JpaRepository<Bookmark, Long> {
    List<Bookmark> findByUser(User user);
    void deleteByUserAndRoom(User user, Room room);
    boolean existsByUserAndRoom(User user, Room room);
}
