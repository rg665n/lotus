package com.space.lotus.model;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.PrePersist;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;


@Entity
@Table(name = "transporters")
public class Transporter {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	private String name;
	private String gstin;
	private Boolean showOnInvoice;
	
	@Temporal(TemporalType.DATE)
	@Column(name = "create_at")
	private Date creationDate;
	
	@PrePersist
	public void prePersist() {
		creationDate = new Date();
	}

	/*----- Getters & Setters -----*/
	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getGstin() {
		return gstin;
	}

	public void setGstin(String gstin) {
		this.gstin = gstin;
	}

	public Boolean getShowOnInvoice() {
		return showOnInvoice;
	}

	public void setShowOnInvoice(Boolean showOnInvoice) {
		this.showOnInvoice = showOnInvoice;
	}

	public Date getCreationDate() {
		return creationDate;
	}

	public void setCreationDate(Date creationDate) {
		this.creationDate = creationDate;
	}
	/*----- Getters & Setters -----*/
	
}
