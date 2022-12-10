package com.exmple.repo;

import org.springframework.data.jpa.repository.JpaRepository;

import com.exmple.model.User;

public interface UserRepo extends JpaRepository<User,Integer >{

}
