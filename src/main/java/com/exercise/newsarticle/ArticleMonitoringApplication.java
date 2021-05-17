package com.exercise.newsarticle;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@ComponentScan(basePackages="com.exercise.newsarticle.controller")
@SpringBootApplication
public class ArticleMonitoringApplication {

	public static void main(String[] args) {
		SpringApplication.run(ArticleMonitoringApplication.class, args);
	}

}