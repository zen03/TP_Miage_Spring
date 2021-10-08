package com.cours.tpmiagespring.entities;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

@Entity
public class Serveur implements Serializable {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	@Column(length=150)
	private String nomServ;
	@Column(length=15)
	private String adripServ;
	@OneToMany(mappedBy="serveur")
	private List<Service> services = new ArrayList<Service>();
	
	public Serveur() {
		super();
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	
	}

	public String getNomServ() {
		return nomServ;
	}

	public void setNomServ(String nomServ) {
		this.nomServ = nomServ;
	}

	public String getAdripServ() {
		return adripServ;
	}

	public void setAdripServ(String adripServ) {
		this.adripServ = adripServ;
	}

	public List<Service> getServices() {
		return services;
	}

	public void setServices(List<Service> services) {
		this.services = services;
	}
	
	
}
