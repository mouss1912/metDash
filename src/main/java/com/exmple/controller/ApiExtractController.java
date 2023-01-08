package com.exmple.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Controller;

import com.exmple.pokemon.PokeApiReactorNonCachingConfiguration;
import com.exmple.service.ExtractMeteoApiManager;




/**
 * Controller qui gère l'extraction automatiques des informations des API
  API Meteo Concept pour les données météorologiques toutes les heures
 */
@Controller
public class ApiExtractController {

	@Autowired
	ExtractMeteoApiManager extractMeteoManager;
	
	@Autowired
	PokeApiReactorNonCachingConfiguration apiPochemon;


	
	@Scheduled(fixedRate = 60 * 60 * 1000)
	public void autoExtractMeteo() throws Exception {
		this.extractMeteoManager.extract();
	}
	
	
	@Scheduled(fixedRate = 60 * 60 * 1000)
	public void autoPochemon() throws Exception {
		this.apiPochemon.printPokemon();
	}
	

}
