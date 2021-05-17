package com.exercise.newsarticle.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.exercise.newsarticle.model.NewsArticle;

public interface NewsArticleMonitoringRepository extends JpaRepository<NewsArticle, Long> {
  //TODO Implement custom api
}