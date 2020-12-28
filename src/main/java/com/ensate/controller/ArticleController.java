package com.ensate.controller;

import java.util.List;

import com.ensate.entity.Article;
import com.ensate.service.ArticleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@CrossOrigin(origins="http://localhost:4200")
@RequestMapping("/article")
public class ArticleController {
	
	@Autowired
	ArticleService service;
	@GetMapping("/admin/show")
	public ResponseEntity<List<Article>> getAllArticle() {
		List<Article> list = service.getAllArticle();
		return new ResponseEntity<List<Article>>(list, new HttpHeaders(), HttpStatus.OK);
	}

	@GetMapping("/user/show")
	public ResponseEntity<List<Article>> getUserArticle() {
		List<Article> list = service.getUserArticle();
		return new ResponseEntity<List<Article>>(list, new HttpHeaders(), HttpStatus.OK);
	}

	@PostMapping("/admin/add")
	public ResponseEntity<Article> createOrUpdateArticle(@RequestBody Article entiteArticle){
		Article updated = service.createOrUpdateArticle(entiteArticle);
		return new ResponseEntity<Article>(updated, new HttpHeaders(), HttpStatus.OK);
	}

	@GetMapping("/admin/{id}")
	public ResponseEntity<Article> getArticleById(@PathVariable("id") Integer id) {
		Article entity = service.getArticleById(id);

		return new ResponseEntity<Article>(entity, new HttpHeaders(), HttpStatus.OK);
	}

	@PutMapping("/admin/{id}")
	public HttpStatus deleteArticleById(@PathVariable("id") Integer id) {
		service.deleteArticleById(id);
		return HttpStatus.FORBIDDEN;
	}

}