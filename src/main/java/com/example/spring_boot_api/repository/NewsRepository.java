package com.example.spring_boot_api.repository;

import com.example.spring_boot_api.entity.News;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface NewsRepository extends JpaRepository<News, Long> {
    List<News> findByNameContainingIgnoreCase(String keyword);

}

