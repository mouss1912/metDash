package com.exmple.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.exmple.dto.RegisterDtoRequest;
import com.exmple.exception.UtilisateurNotFoundException;
import com.exmple.model.User;
import com.exmple.repo.UserRepo;


@Service
public class UtilisateurService {
	@Autowired
	private UserRepo utilisateurRepo;

	//private PasswordEncoder passwordEncoder;

	/*
	 * Methode de recuperation de la liste d'utilisateur
	 */

	public List<User> getAllUtilisateurs() {
		return this.utilisateurRepo.findAll();

	}

	/*
	 * Methode de creation d' un utilisateur
	 */
	public User creerUtilisateur(RegisterDtoRequest dtoRequest) {
		return new User(dtoRequest);

	}

	public User persist(User utilisateur) {
		return this.utilisateurRepo.save(utilisateur);

	}

	/*
	 * Methode de recuperation d'un utilisateur
	 */

	public User getUtilisateur(Integer id) throws UtilisateurNotFoundException {
		Optional<User> optionalUtilisateur = utilisateurRepo.findById(id);

		if (!optionalUtilisateur.isPresent()) {
			throw new UtilisateurNotFoundException("Utilisateur inexistant veuillé le créer...");
		}
		return optionalUtilisateur.get();
	}

	/*
	 * Methode de supression d'un utilisateur
	 */
	public void deleteUtilisateur(Integer id) {
		this.utilisateurRepo.deleteById(id);
	}

	/*
	 * Encode Mot de passe utilisateur
	 * 
	 */

	//public void encodePassword(User utilisateur) {
	//	utilisateur.setMotDePasse(this.passwordEncoder.encode(utilisateur.getMotDePasse()));
	//}

	/*
	 * Methode de mise à jour d'un utilisateur Encode le mot de passe
	 * passwordEncoder Puis met à jour le mot de passe en BD UpdateUtilisateur et
	 * Update je teste les deux
	 */

	// Methode Update 1
	public User updateUtilisateur(User utilisateur) {
	//	this.encodePassword(utilisateur);
		return this.utilisateurRepo.save(utilisateur);
	}

	// Methode Update 2
	public User update(Integer id, User utilisateur) {
		if (!utilisateurRepo.existsById(id)) {
			throw new RuntimeException("Utilisateur n'existe pas en base");
		}
		utilisateur.setId(id);
		return this.utilisateurRepo.save(utilisateur);
	}

}
