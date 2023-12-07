package com.hway.fleet.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.hway.fleet.model.User;

public interface UserRepository extends JpaRepository<User, Integer> {

	//For Login by email and password
		User findByEmailAndPassword(String email, String psw);
}
