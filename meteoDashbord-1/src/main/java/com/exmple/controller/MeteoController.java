package com.exmple.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.exmple.dto.MeteoDtoResponse;
import com.exmple.exception.MeteoIntrouvableException;
import com.exmple.model.Meteo;
import com.exmple.service.MeteoService;


@RestController
@RequestMapping("/meteo")
public class MeteoController {
	@Autowired
	MeteoService meteoServ;
	
	public MeteoController () {}
		
		
		@GetMapping("{idCommune}")
		public  ResponseEntity<?> getLastMeteoByCommuneId (@PathVariable int idCommune) throws MeteoIntrouvableException {
			
			Meteo fromRepo = this.meteoServ.getLastMeteoCommuneById(idCommune);
			
			if ( fromRepo == null ) {
				return ResponseEntity.ok("Aucun Relevé Météo n'a été trouvé pour la commune ID: " + idCommune);
			} else {
				MeteoDtoResponse dto = new MeteoDtoResponse(fromRepo);
				return ResponseEntity.ok(dto);
			}
			
		}

}
