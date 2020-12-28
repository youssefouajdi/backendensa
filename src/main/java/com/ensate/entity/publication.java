package com.ensate.entity;

import java.util.Date;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;


@Entity
@Inheritance(strategy = InheritanceType.JOINED)
@Table(name="publication")
public class publication {
	@Id
	@GeneratedValue
	@Column(name="id")
	protected int id;
	@Column(name="etat")
	protected boolean active ;
	@Column(name="titre")
	protected String titre;
	@Column(name="description")
	protected String desc;
	@Column(name="created_at")
	@CreationTimestamp
	@Temporal(TemporalType.TIMESTAMP)
	protected Date created_at;
	@UpdateTimestamp
	@Temporal(TemporalType.TIMESTAMP)
	@Column(name="updated_at")
	protected Date updated_at;

	public publication(boolean active, String titre, String desc, Date created_at, Date updated_at) {
		super();
		this.active = active;
		this.titre = titre;
		this.desc = desc;
		this.created_at = created_at;
		this.updated_at = updated_at;
	}
	public boolean isStatus() {
		return active;
	}
	public void setStatus(boolean active) {
		this.active = active;
	}
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getTitre() {
		return titre;
	}
	public void setTitre(String titre) {
		this.titre = titre;
	}
	public String getDesc() {
		return desc;
	}
	public void setDesc(String desc) {
		this.desc = desc;
	}
	public Date getCreated_at() {
		return created_at;
	}
	public void setCreated_at(Date created_at) {
		this.created_at = created_at;
	}
	public Date getUpdated_at() {
		return updated_at;
	}
	public void setUpdated_at(Date updated_at) {
		this.updated_at = updated_at;
	}
	public publication() {
	}

	

}
