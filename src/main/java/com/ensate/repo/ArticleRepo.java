package com.ensate.repo;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.ensate.entity.Article;

public interface ArticleRepo extends JpaRepository<Article, Integer> {
	
	@Query("select c from Article c where c.active =1")
	List<Article> findByActiveTrue();

	}


