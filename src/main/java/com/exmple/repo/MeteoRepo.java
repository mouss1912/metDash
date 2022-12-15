package com.exmple.repo;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.exmple.model.Meteo;


public interface MeteoRepo extends JpaRepository<Meteo, Integer> {

	public List<Meteo> findByCommuneId (Integer idCommune);
	

	public List<Meteo> findByDateAndCommuneId(LocalDateTime localDateTime, int idCommune);

	@Query(value="SELECT * FROM meteo WHERE meteo.commune_id = :communeId ORDER BY meteo.date DESC LIMIT 1", nativeQuery = true)
	public Optional<Meteo> findLastMeteoByCommune(@Param ("communeId") Integer communeId);
	
	public List<Meteo> findByDateBetweenAndCommuneIdOrderByDateDesc(LocalDateTime dateDebut, LocalDateTime dateFin, Integer communeId);
}