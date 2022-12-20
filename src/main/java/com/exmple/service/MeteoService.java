package com.exmple.service;

import java.util.List;
import java.util.Optional;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import com.exmple.exception.MeteoIntrouvableException;
import com.exmple.model.Commune;
import com.exmple.model.Meteo;
import com.exmple.repo.MeteoRepo;


@Service
public class MeteoService {
	
	private static final Logger LOG = LoggerFactory.getLogger(ExtractMeteoApiManager.class);
	private MeteoRepo meteoRepository;

	public MeteoService(MeteoRepo meteoRepository) {
		this.meteoRepository = meteoRepository;
	}

	public Meteo save(Meteo meteoIndicateur) {
		return this.meteoRepository.save(meteoIndicateur);
	}

	public Meteo getMeteoByID(int id) {
		return this.meteoRepository.findById(id).get();
	}

	public List<Meteo> getMeteoByCommune(Commune commune) {
		return this.meteoRepository.findByCommuneId(commune.getId());
	}

	public List<Meteo> getMeteos() {
		return this.meteoRepository.findAll().subList(4, 10);
	}
	
	public List<Meteo> meteoDuJour() {
		return this.meteoRepository.findLastMeteo();
	}
	
	public Meteo getLastMeteoCommuneById(int idCommune) throws MeteoIntrouvableException {

		Optional<Meteo> lastMeteo = this.meteoRepository.findLastMeteoByCommune(idCommune);
		Meteo retour = null;
		if (lastMeteo.isEmpty()) {
			//throw new MeteoIntrouvableException("Aucun relevé Météo trouvé pour la commune à l'ID : " + idCommune);
			LOG.info("Aucun relevé Météo trouvé pour la commune à l'ID : " + idCommune);
		} else {
			retour = lastMeteo.get();
		}
		return retour;
	}

	public void deleteMeteo(Meteo meteoParam) {
		this.meteoRepository.delete(meteoParam);
	}

	/**
	 * Permet de vérifier l'existence d'un releveMeteo en BDD pour éviter les
	 * doublons
	 * 
	 * @param meteoParam
	 * @return TRUE si le relevé Meteo en Param est trouvé en BDD, FALSE sinon.
	 */
	public boolean checkExistenceReleveMeteo(Meteo meteoParam) {
		List<Meteo> listeMeteoBDD = this.meteoRepository.findByDateAndCommuneId(meteoParam.getDate(),
				meteoParam.getCommune().getId());
		if (listeMeteoBDD.size() > 0) {
			if (listeMeteoBDD.get(0).getVitesseMoyVent() == meteoParam.getVitesseMoyVent()) {
				return true;
			}
		}
		return false;
	}

}
