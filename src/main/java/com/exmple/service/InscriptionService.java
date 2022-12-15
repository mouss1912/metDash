package com.exmple.service;

import org.springframework.stereotype.Service;

import com.exmple.dto.RegisterDtoRequest;

@Service
public class InscriptionService {
	
	//private PasswordEncoder passwordEncoder;
	
	
	
	public void encodePassword(RegisterDtoRequest dtoRequest) {
	//	dtoRequest.setPassword(this.passwordEncoder.encode(dtoRequest.getPassword()));
	}
}
