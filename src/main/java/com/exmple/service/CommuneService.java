package com.exmple.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.exmple.exception.CommuneIntrouvableException;
import com.exmple.model.Commune;
import com.exmple.repo.CommuneRepo;
import com.exmple.repo.MeteoRepo;


// TODO: Auto-generated Javadoc
/**
 * The Class CommuneService.
 */
@Service
public class CommuneService {
	
	@Autowired
	private CommuneRepo communeRepository;
	
	@Autowired
	private MeteoRepo meteoRepository;
	

	public CommuneService() {
		
	}
	
	public List<Commune> listCommune() {
		return this.communeRepository.findAll();
	}
	
	/**
	 * Retrouve une commune en BDD grâce à son code INSEE fourni en param
	 * @param codeInsee
	 * @return Un Objet Commune avec toutes ses informations
	 * @throws CommuneIntrouvableException
	 */
	public Commune findByCodeInsee(String codeInsee) throws CommuneIntrouvableException {
		Optional<Commune> commune = this.communeRepository.findByCodeInseeCommune(codeInsee);
		if(commune.isPresent()) {
			//Commune communeComplete = this.complementInfosCommune(commune.get());
			return commune.get();
		} else {
			throw new CommuneIntrouvableException("La commune dont le code INSEE est" + codeInsee + " est introuvable en BDD");
		}
	}
	
	
	public Commune save(Commune commune) {
		return this.communeRepository.save(commune);
	}
	
	
	public Commune getById(int idCommune) throws CommuneIntrouvableException{
		Optional<Commune> commune = this.communeRepository.findById(idCommune);
		if(commune.isPresent()) {
			return commune.get();
		} else {
			throw new CommuneIntrouvableException("La commune dont l'ID est" + idCommune + " est introuvable en BDD");
		}
	}
	
	public List<Commune> getByNomAlike(String nomAlike){
		
		String nomAlikeSQL = nomAlike.concat("%");	
		return this.communeRepository.findByNomAlike(nomAlikeSQL);
		
	}
	
	/**
	 * Void à utiliser en boot après le script SQL INSEE pour ne conserver que les communes d'Occitanie en BDD
	 */
	public void deleteAllCommunesHorsOccitanie() {
		this.communeRepository.deleteAllHorsOccitanie();
	}
	
	//public Commune getByNom(String nomCommune ) {
		
	//}
	

	
	/**
	 * Passe par les repo concernés pour fournir à l'objet commune placé en param les informations suivantes :
	 * - Liste des Stations liés à la commune
	 * - Liste des indicateurs Météos lié à la commune
	 * - Liste des favoris liés à la commune
	 * @param communeParam
	 * @return un Objet commune avec toutes les informations de la BDD lié à elle
	 */
//	public Commune complementInfosCommune(Commune communeParam) {
//		Commune fullCommune = communeParam;
//		
//		//Ajout des stations
//		List<Station> listeStationCommune = this.stationRepository.findByCommuneId(communeParam.getId());
//		for ( Station s : listeStationCommune ) {
//			fullCommune.getStations().add(s);
//		}
//		
//		//Ajout des indicateurs météos
//		List<MeteoIndicateur> listeRelevesMeteoCommune = this.meteoRepository.findByCommuneId(communeParam.getId());
//		for ( MeteoIndicateur m : listeRelevesMeteoCommune) {
//			fullCommune.getMeteoIndicateurs().add(m);
//		}
//		
//		
//		//Ajout des favoris
//		List<Favoris> listeFavorisCommune = this.favorisRepository.findByCommuneId(communeParam.getId());
//		for ( Favoris f : listeFavorisCommune ) {
//			fullCommune.getFavoris().add(f);
//		}
//		
//		return fullCommune;
//	}
}

