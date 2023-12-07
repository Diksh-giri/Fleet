package com.hway.fleet.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.hway.fleet.model.User;
import com.hway.fleet.repository.UserRepository;
import com.hway.fleet.service.UserService;

@Service
public class UserServiceImpl implements UserService {

	@Autowired
	private UserRepository userRepo;
	
	@Override
	public void signup(User user) {
		
		userRepo.save(user);
	}

	@Override
	public User login(String email, String psw) {

		return userRepo.findByEmailAndPassword(email, psw);
	}

}
