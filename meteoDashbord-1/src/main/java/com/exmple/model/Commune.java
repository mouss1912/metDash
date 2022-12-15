package com.exmple.model;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

@Entity
public class Commune {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	
	@Column(name = "nom_commune")
	private String nomCommune;
	
	@Column(name = "code_insee")
	private String codeInseeCommune;
	
	@OneToMany(mappedBy = "commune", fetch = FetchType.EAGER )
	Set<Meteo> meteo = new HashSet<>();
	

	public Commune() {
		
	}

	
	public Commune(Integer id, String nomCommune, String codeInseeCommune,Set<Meteo> meteo) {
		this.id = id;
		this.nomCommune = nomCommune;
		this.codeInseeCommune = codeInseeCommune;
		this.meteo = meteo;
	
	}


	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getNomCommune() {
		return nomCommune;
	}

	public void setNomCommune(String nomCommune) {
		this.nomCommune = nomCommune;
	}

	public String getCodeInseeCommune() {
		return codeInseeCommune;
	}

	public void setCodeInseeCommune(String codeInseeCommune) {
		this.codeInseeCommune = codeInseeCommune;
	}

	public Set<Meteo> getMeteo() {
		return meteo;
	}

	public void setMeteo(Set<Meteo> meteo) {
		this.meteo = meteo;
	}

	
	

}
