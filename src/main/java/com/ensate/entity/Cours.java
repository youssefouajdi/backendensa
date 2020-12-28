package com.ensate.entity;

import java.util.Date;


import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Table(name="cours")
public class Cours extends publication{
	@Column(name="lien_cours")
	private String lien_cours;

	public String getLien_cours() {
		return lien_cours;
	}

	public void setLien_cours(String lien_cours) {
		this.lien_cours = lien_cours;
	}

	public Cours(boolean status, String titre, String desc, Date created_at, Date updated_at, String lien_cours) {
		super(status, titre, desc, created_at, updated_at);
		this.lien_cours = lien_cours;
	}

	public Cours() {
	}

}
