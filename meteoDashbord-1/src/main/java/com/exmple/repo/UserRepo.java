package com.exmple.repo;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.exmple.model.User;

public interface UserRepo extends JpaRepository<User,Integer >{
	public Optional<User> findByEmail(String email);
	public Optional<User> findByUsername(String username);
}
