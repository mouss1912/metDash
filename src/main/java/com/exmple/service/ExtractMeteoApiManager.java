package com.exmple.service;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.List;

import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.context.annotation.Bean;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.exmple.dto.ApiMeteoResponse;
import com.exmple.dto.Forecast;
import com.exmple.model.Commune;
import com.exmple.model.Meteo;



@Service
public class ExtractMeteoApiManager {
	
	private static final Logger LOG = LoggerFactory.getLogger(ExtractMeteoApiManager.class);
	private static final String TOKEN = "8c7d59aba8b61f1963ff816bd5cc05abbd35ee37cbe0848b2862a18a46973402";
	
	private MeteoService meteoService;
	private CommuneService communeService;
	private DateUtils dateUtils;
	RestTemplate restTemplate;
	
	public ExtractMeteoApiManager(CommuneService communeService, MeteoService meteoService, DateUtils dateUtils, RestTemplate restTemplate) {
		this.communeService = communeService;
		this.meteoService = meteoService;
		this.dateUtils = dateUtils;
		this.restTemplate = restTemplate;
	}
	
	
	public void extract() {
		
		long start = System.currentTimeMillis();
		LOG.info("Debut de Extraction API Meteo");
	
		// RECUPERER TOP 50 VILLE	
		//List<Commune> communesList = this.communeService.getTop50Population();
		
		List<Commune> communesList = this.communeService.listCommune();

		this.everyDayExtract(restTemplate, communesList);
		long tempsExecution = System.currentTimeMillis() - start;

		LOG.info("Fin Extraction API Meteo");
		LOG.info("Temps d'execution " + tempsExecution);
		LOG.info("--------------------------------------");
	}
	
	public void everyDayExtract(RestTemplate restTemplate, List<Commune> communesList) {
		// PARCOURIRE LE TOP 50
		for(Commune commune : communesList) {
			//LOG.info("TRAITEMENT " + commune.getNomCommune());
			// POUR CHAQUE COMMUNE PREND LE CODE INSEE ET LE METTRE EN PARAM DE LA REQUETE
			String url = "https://api.meteo-concept.com/api/forecast/nextHours?token=" + TOKEN + "&insee=" + commune.getCodeInseeCommune();
			
			//String url = "https://api.meteo-concept.com/api/forecast/nextHours?token=" + TOKEN + "&insee=" + "54318";

			
			ApiMeteoResponse meteoListe = restTemplate.getForObject(url, ApiMeteoResponse.class);
			for(Forecast forecast : meteoListe.getForecast()) {
				LocalDateTime date = this.parseAndConverteForcaste(forecast.getDatetime());
				// CREER UN OBJET METEO INDICATEUR
				// LE LIER A UNE COMMUNE
				Meteo meteoIndicateur = new Meteo(date, forecast.getWind10m(), forecast.getRr10(), forecast.getTsoil2(), commune);
				
				// EVITER LES DOUBLONS
				if ( !this.meteoService.checkExistenceReleveMeteo(meteoIndicateur) ) {
					this.meteoService.save(meteoIndicateur);
					//LOG.info("FORECAST CREE ET PERSISTER");
				} else {
					LOG.info("MeteoIndicateur deja en BDD");
				}
				
	
			}
		}
	}
	
	public void fullExtract(RestTemplate restTemplate, List<Commune> communesList) {
		// PARCOURIRE LE TOP 50
		for(Commune commune : communesList) {
			LOG.info("TRAITEMENT " + commune.getNomCommune());
			// POUR CHAQUE COMMUNE PREND LE CODE INSEE ET LE METTRE EN PARAM DE LA REQUETE
			String url = "https://api.meteo-concept.com/api/forecast/nextHours?token=" + TOKEN + "&insee=" + commune.getCodeInseeCommune();
			ApiMeteoResponse meteoListe = restTemplate.getForObject(url, ApiMeteoResponse.class);
			for(Forecast forecast : meteoListe.getForecast()) {
				LOG.info("CREATION FORECAST");
				LocalDateTime date = this.parseAndConverteForcaste(forecast.getDatetime());
				// CREER UN OBJET METEO INDICATEUR
				// LE LIER A UNE COMMUNE
				Meteo meteoIndicateur = new Meteo(date, forecast.getDirwind10m(), forecast.getRr10(), forecast.getTsoil2(), commune);
				// LE PERSISTER EN BASE
				this.meteoService.save(meteoIndicateur);
				LOG.info("FORECAST CREE ET PERSISTER");
			}
		}
	}
	
	/**
	 * A MODIFIER
	 */
	public LocalDateTime parseAndConverteForcaste(String dateAtraiter) {
		DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss"); 
		String date = this.dateUtils.parseDate(dateAtraiter);
		String newDate = date.replace("T", " ");
		return LocalDateTime.parse(newDate, formatter);
	}
	


}
