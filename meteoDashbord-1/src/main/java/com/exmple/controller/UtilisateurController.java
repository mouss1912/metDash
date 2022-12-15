package com.exmple.controller;


import java.text.ParseException;
import java.util.List;
import java.util.stream.Collectors;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.exmple.dto.RegisterDtoRequest;
import com.exmple.dto.RegisterDtoResponse;
import com.exmple.dto.UpdatateDtoResponse;
import com.exmple.dto.UtilisateurDto;
import com.exmple.dto.UtilisateurWithPasswordDto;
import com.exmple.exception.FormulaireIncompletException;
import com.exmple.exception.RequeteErreurException;
import com.exmple.exception.UtilisateurNotFoundException;
import com.exmple.model.User;
import com.exmple.service.InscriptionManager;
import com.exmple.service.UtilisateurService;


@RestController
@RequestMapping("dashbord")
public class UtilisateurController {
	
	@Autowired
	private  UtilisateurService utilisateurService;
	
	@Autowired
	private InscriptionManager inscriptionManager;

	
	private ModelMapper modelMapper;
	
	/*
	 * Méthodes de Conversion de Entité -> Dto et Dto -> Entity Trouver une solution
	 * et le sortir du controller Interface fonctionnelle à cause du ::
	 */
	
	private UtilisateurDto convertToDto(User utilisateur) {
		UtilisateurDto utilisateurDto = modelMapper.map(utilisateur, UtilisateurDto.class);
		return utilisateurDto;
	}

	private User convertToEntity(UtilisateurWithPasswordDto passwordDto) throws UtilisateurNotFoundException {
		User utilisateur = modelMapper.map(passwordDto, User.class);
		if (passwordDto.getId() != null) {
			User ancienUtilisateur = utilisateurService.getUtilisateur(passwordDto.getId());
		}
		return utilisateur;
	}
	
	/**
	 * inscription
	 * @param dtoRequest
	 * @param resValid
	 * @return
	 * @throws ParseException
	 */
	@PostMapping("register")
	public ResponseEntity<?> register(@RequestBody RegisterDtoRequest dtoRequest, BindingResult resValid)
			throws ParseException {
		if (!resValid.hasErrors()) {
			if (this.inscriptionManager.controleInscriptionProprietes(dtoRequest)) {
				RegisterDtoResponse response = this.inscriptionManager.inscription(dtoRequest);
				return ResponseEntity.ok(response);
			} else {
				return ResponseEntity.badRequest()
						.body(new FormulaireIncompletException("Le formulaire est incomplet."));
			}
		} else {
			return ResponseEntity.badRequest().body(new RequeteErreurException("Une erreur est survenue"));
		}
	}
	
	/*
	 * Affiche la liste des utilisateurs inscrits
	 */
	
	@GetMapping("/utilisateurs")
	@ResponseBody
	public List<UtilisateurDto> getListeUtilisateurs() {
		List<User> utilisateurs = utilisateurService.getAllUtilisateurs();
		return utilisateurs.stream().map(this::convertToDto).collect(Collectors.toList());
	}

	/*
	 * Affiche un utilisateur à partir de son id
	 */

	@GetMapping("utilisateur/{id}")
	@ResponseBody
	public UtilisateurDto getUnUtilisateur(@PathVariable("id") Integer id) throws UtilisateurNotFoundException {	
		return convertToDto(utilisateurService.getUtilisateur(id));
	}
	

	@PutMapping(value = "updateUtilisateur/{id}")
	public ResponseEntity<?> updateUtilisateur(@RequestBody UtilisateurWithPasswordDto passwordDto)
			throws UtilisateurNotFoundException {
		User utilisateur = convertToEntity(passwordDto);
		utilisateurService.updateUtilisateur(utilisateur);
		UpdatateDtoResponse reponseDto = new UpdatateDtoResponse("Utilisateur mis à jour");
		return ResponseEntity.ok(reponseDto);
	}
	
	// Methode avoir supprimer un utilisateur
	@DeleteMapping("deleteUtilisateur/{id}")
	public void deleteUnUtilisateur(@PathVariable("id") Integer id) {
		this.utilisateurService.deleteUtilisateur(id);
	}
	
}
