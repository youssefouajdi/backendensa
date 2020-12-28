package com.ensate.entity;

import java.sql.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;


@Entity
@Table(name="application")
public class Application extends publication{
	@Column(name="lien_application")
	private String lien_application;
	public String getLien_application() {
		return lien_application;
	}

	public void setLien_application(String lien_application) {
		this.lien_application = lien_application;
	}

	public Application(boolean status, String titre, String desc, Date created_at, Date updated_at, String lien_application) {
		super(status, titre, desc, created_at, updated_at);
		this.lien_application = lien_application;
	}

	public Application() {
	}

}
