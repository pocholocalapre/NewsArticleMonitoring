package com.exercise.newsarticle.model;

import javax.persistence.*;

@Entity(name = "newsarticle")
public class NewsArticle {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private long id;

	@Column(name = "title")
	private String title;

	@Column(name = "text")
	private String text;
	 
    public NewsArticle() {
 
    }
 
    public NewsArticle(String title, String text) {
        this.title = title;
        this.text = text;
    }
	
    public long getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getText() {
		return text;
	}

	public void setText(String text) {
		this.text = text;
	}

    @Override
    public String toString() {
        return "NewsArticle [id=" + id + ", title=" + title + ", text=" + text + "]";
    }
}