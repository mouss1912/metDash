package com.exmple.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.exmple.dto.MeteoDtoResponse;
import com.exmple.exception.MeteoIntrouvableException;
import com.exmple.model.Meteo;
import com.exmple.service.MeteoService;

@CrossOrigin
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
		
		@GetMapping("/villes")
		public List<MeteoDtoResponse> getLastMeteo () throws MeteoIntrouvableException {
			List<MeteoDtoResponse> response= new ArrayList<MeteoDtoResponse>();

			
		//	List<Meteo> fromRepo = this.meteoServ.getMeteos();
			List<Meteo> fromRepo = this.meteoServ.meteoDuJour();


			fromRepo.forEach(m -> {
				MeteoDtoResponse retour = new MeteoDtoResponse();
				retour.setId(m.getId()); 
				retour.setDate(m.getDate());
				retour.setCumulPluie(m.getCumulPluie());
				retour.setTempatureSol(m.getTempatureSol());
				retour.setVitesseMoyVent(m.getVitesseMoyVent());
				retour.setIdCommune(m.getCommune().getId());
				retour.setNomCommune(m.getCommune().getNomCommune());

				response.add(retour);
			});
	
			
			return response;
			
		}

}
