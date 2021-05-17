package com.exercise.newsarticle.controller;
 
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.exercise.newsarticle.model.NewsArticle;
import com.exercise.newsarticle.repository.NewsArticleMonitoringRepository;
 
@RestController
@RequestMapping("/newsArticleMonitoring")
public class NewsArticleController
{	
    @Autowired
    private NewsArticleMonitoringRepository newsArticleMonitoringRepository;
    
	@PostMapping("/NewsArticle")
	public ResponseEntity<NewsArticle> createNewsArticle(@RequestBody NewsArticle newsArticle) {
		try {
			NewsArticle _newsArticle = newsArticleMonitoringRepository
					.save(new NewsArticle(newsArticle.getTitle(), newsArticle.getText()));
			return new ResponseEntity<>(_newsArticle, HttpStatus.CREATED);
		} catch (Exception e) {
			return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
	
	@GetMapping("/listAllNewsArticle")
	public ResponseEntity<List<NewsArticle>> getAllNewsArticle(@RequestParam(required = false) String title) {
		try {
			List<NewsArticle> newsArticles = new ArrayList<NewsArticle>();

			newsArticleMonitoringRepository.findAll().forEach(newsArticles::add);

			if (newsArticles.isEmpty()) {
				return new ResponseEntity<>(HttpStatus.NO_CONTENT);
			}

			return new ResponseEntity<>(newsArticles, HttpStatus.OK);
		} catch (Exception e) {
			return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}

	@GetMapping("/NewsArticle/{id}")
	public ResponseEntity<NewsArticle> getNewsArticleById(@PathVariable("id") long id) {
		Optional<NewsArticle> newsArticleData = newsArticleMonitoringRepository.findById(id);

		if (newsArticleData.isPresent()) {
			return new ResponseEntity<>(newsArticleData.get(), HttpStatus.OK);
		} else {
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}
	}
	
	@PutMapping("/NewsArticle/{id}")
	public ResponseEntity<NewsArticle> updateNewsArticle(@PathVariable("id") long id, @RequestBody NewsArticle newsArticle) {
		Optional<NewsArticle> newsArticleData = newsArticleMonitoringRepository.findById(id);

		if (newsArticleData.isPresent()) {
			NewsArticle _newsArticle = newsArticleData.get();
			_newsArticle.setTitle(newsArticle.getTitle());
			_newsArticle.setText(newsArticle.getText());
			return new ResponseEntity<>(newsArticleMonitoringRepository.save(_newsArticle), HttpStatus.OK);
		} else {
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}
	}
	
	@DeleteMapping("/NewsArticle/{id}")
	public ResponseEntity<HttpStatus> deleteNewsArticle(@PathVariable("id") long id) {
		try {
			newsArticleMonitoringRepository.deleteById(id);
			return new ResponseEntity<>(HttpStatus.NO_CONTENT);
		} catch (Exception e) {
			return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
}