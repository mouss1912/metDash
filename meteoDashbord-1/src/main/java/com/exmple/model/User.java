package com.exmple.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import com.exmple.dto.RegisterDtoRequest;

@Entity
public class User {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	private String nom;
	private String prenom;
	private String username;
	private String email;
	private String motDePasse;
	
	public User() {
		
	}

	public User(Integer id, String nom, String prenom, String username, String email, String motDePasse) {
		this.id = id;
		this.nom = nom;
		this.prenom = prenom;
		this.username = username;
		this.email = email;
		this.motDePasse = motDePasse;
	}

	public User(RegisterDtoRequest dtoRequest) {
		this.nom = dtoRequest.getNom();
		this.prenom = dtoRequest.getPrenom();
		this.username = dtoRequest.getUsername();
		this.email = dtoRequest.getEmail();
		this.motDePasse = dtoRequest.getPassword();
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getNom() {
		return nom;
	}

	public void setNom(String nom) {
		this.nom = nom;
	}

	public String getPrenom() {
		return prenom;
	}

	public void setPrenom(String prenom) {
		this.prenom = prenom;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getMotDePasse() {
		return motDePasse;
	}

	public void setMotDePasse(String motDePasse) {
		this.motDePasse = motDePasse;
	}
	
	
}
