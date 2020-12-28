package com.ensate.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.ensate.entity.Article;
import com.ensate.repo.ArticleRepo;

@Service
public class ArticleService {
	private static final Article Excepetion = null;
	@Autowired
	ArticleRepo repository;
	public List<Article> getAllArticle()
    {
        List<Article> articleList = repository.findAll();
         
        if(articleList.size() > 0) {
            return articleList;
        } else {
            return new ArrayList<Article>();
        }
    }
	
	public List<Article> getUserArticle()
    {
        List<Article> articleList = repository.findByActiveTrue();
         
        if(articleList.size() > 0) {
            return articleList;
        } else {
            return new ArrayList<Article>();
        }
    }
     
    public Article getArticleById(Integer id)
    {
        Optional<Article> article = repository.findById(id);
         
        if(article.isPresent()) {
            return article.get();
        }
		return null; 
    }
     
    public Article createOrUpdateArticle(Article entiteArticle)  
    {
        Optional<Article> article = repository.findById(entiteArticle.getId());
         
        if(article.isPresent()) 
        {
            Article newArticle = article.get();
            newArticle.setTitre(entiteArticle.getTitre());
            newArticle.setDesc(entiteArticle.getDesc());
            newArticle.setLien_article(entiteArticle.getLien_article());
            newArticle.setStatus(entiteArticle.isStatus());
            newArticle = repository.save(newArticle);
             
            return newArticle;
        } else {
        	entiteArticle = repository.save(entiteArticle);
             
            return entiteArticle;
        }
    } 
     
    public Article deleteArticleById(Integer id) 
    {
        Optional<Article> article = repository.findById(id);
         
        if(article.isPresent()) 
        {
        	Article newArticle = article.get();
        	newArticle.setStatus(false);
        	newArticle = repository.save(newArticle);
        	 return newArticle;
        }
       return Excepetion ;
    } 

	
}
