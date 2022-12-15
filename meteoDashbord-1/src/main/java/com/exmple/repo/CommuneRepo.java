package com.exmple.repo;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.exmple.model.Commune;


public interface CommuneRepo extends JpaRepository<Commune, Integer>{
	
	Optional<Commune> findByCodeInseeCommune(String codeInsee);
	
	@Query( nativeQuery = true, value =
			"SELECT * FROM commune c  WHERE c.nom_commune LIKE :nomAlike LIMIT 5")
	List<Commune> findByNomAlike(@Param("nomAlike") String nomAlike);
	
	@Query( nativeQuery = true, value = "DELETE FROM commune WHERE commune.id IN ( SELECT c.id FROM commune c JOIN departement d ON d.id = c.departement JOIN region r ON r.id = d.region_id WHERE r.id != 5")
	void deleteAllHorsOccitanie();
}