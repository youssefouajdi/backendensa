package com.ensate.entity;

import java.sql.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Table(name="article")
	public class Article extends publication{
	@Column(name="lien_article")
	private String lien_article;
	public String getLien_article() {
		return lien_article;
	}
	public void setLien_article(String lien_article) {
		this.lien_article = lien_article;
	}
	public Article(boolean status, String titre, String desc, Date created_at, Date updated_at, String lien_article) {
		super(status, titre, desc, created_at, updated_at);
		this.lien_article = lien_article;
	}
	public Article() {
	}
	
}