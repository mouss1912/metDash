package com.exmple.service;

import org.springframework.stereotype.Component;

import com.exmple.dto.RegisterDtoRequest;
import com.exmple.dto.RegisterDtoResponse;
import com.exmple.model.User;


@Component
public class InscriptionManager {
	private UtilisateurService utilisateurService;
	private InscriptionService inscriptionService;
	private CheckerInscriptionService checkerInscriptionService;
	
	public InscriptionManager(UtilisateurService utilisateurService, InscriptionService inscriptionService,
			CheckerInscriptionService checkerInscriptionService) {
		this.utilisateurService = utilisateurService;
		this.inscriptionService = inscriptionService;
		this.checkerInscriptionService = checkerInscriptionService;
	}
	
	public RegisterDtoResponse inscription(RegisterDtoRequest dtoRequest) {
		this.inscriptionService.encodePassword(dtoRequest);	
		User utilisateur = this.utilisateurService.creerUtilisateur(dtoRequest);
		User utilisateurDataBase = this.utilisateurService.persist(utilisateur);
		return new RegisterDtoResponse("Inscription réussie !");
	}
	
	public boolean controleInscriptionProprietes(RegisterDtoRequest dtoRequest) {
		return this.checkerInscriptionService.controleInscriptionProprietes(dtoRequest);
	}
}
