package com.example.spring_boot_api.service;

import com.example.spring_boot_api.entity.News;
import com.example.spring_boot_api.repository.NewsRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class NewsService {

    @Autowired
    private NewsRepository newsRepository;

    public News addNews(News news) {
        return newsRepository.save(news);
    }

    public News updateNews(Long id, News updatedNews) {
        Optional<News> existingNewsOptional = newsRepository.findById(id);
        if (existingNewsOptional.isPresent()) {
            updatedNews.setId(id);
            return newsRepository.save(updatedNews);
        } else {
            // Handle the case where news with the given id is not found
            return null;
        }
    }

    public void deleteNews(Long id) {
        newsRepository.deleteById(id);
    }

    public News getNewsById(Long id) {
        return newsRepository.findById(id).orElse(null);
    }

    public List<News> getAllNews() {
        return newsRepository.findAll();
    }

    public List<News> searchNews(String keyword) {
        return newsRepository.findByNameContainingIgnoreCase(keyword);
    }
}

