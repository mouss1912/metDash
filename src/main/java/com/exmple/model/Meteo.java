package com.exmple.model;

import java.time.LocalDateTime;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

import lombok.NoArgsConstructor;

@Entity
public class Meteo {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	
	private LocalDateTime date;
	/**
	 * Vent moyen à 10 mètres en km/h
	 */
	private Integer vitesseMoyVent;
	/**
	 * 	Température du sol entre 10 et 40 cm en °C.
	 */
	private double cumulPluie;
	/**
	 * Température du sol entre 10 et 40 cm en °C.
	 */
	private Integer tempatureSol;
	
	@ManyToOne
	@JoinColumn(name="commune_id")
	private Commune commune;
	
	public Meteo() {
		
	}

	public Meteo( LocalDateTime date, Integer vitesseMoyVent, double cumulPluie, Integer tempatureSol,
			Commune commune) {
		this.date = date;
		this.vitesseMoyVent = vitesseMoyVent;
		this.cumulPluie = cumulPluie;
		this.tempatureSol = tempatureSol;
		this.commune = commune;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public LocalDateTime getDate() {
		return date;
	}

	public void setDate(LocalDateTime date) {
		this.date = date;
	}

	public Integer getVitesseMoyVent() {
		return vitesseMoyVent;
	}

	public void setVitesseMoyVent(Integer vitesseMoyVent) {
		this.vitesseMoyVent = vitesseMoyVent;
	}

	public double getCumulPluie() {
		return cumulPluie;
	}

	public void setCumulPluie(double cumulPluie) {
		this.cumulPluie = cumulPluie;
	}

	public Integer getTempatureSol() {
		return tempatureSol;
	}

	public void setTempatureSol(Integer tempatureSol) {
		this.tempatureSol = tempatureSol;
	}

	public Commune getCommune() {
		return commune;
	}

	public void setCommune(Commune commune) {
		this.commune = commune;
	}

	
	
}
