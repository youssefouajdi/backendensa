package com.ensate.entity;

import java.sql.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Table(name="lien")
	public class Lien extends publication{
	@Column(name="lien_lien")
	private String lien_lien;
	public String getLien_lien() {
		return lien_lien;
	}
	public void setLien_lien(String lien_lien) {
		this.lien_lien = lien_lien;
	}
	public Lien(boolean status, String titre, String desc, Date created_at, Date updated_at, String lien_lien) {
		super(status, titre, desc, created_at, updated_at);
		this.lien_lien = lien_lien;
	}
	public Lien() {
	}
}
