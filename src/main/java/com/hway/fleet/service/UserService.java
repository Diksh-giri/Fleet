package com.hway.fleet.service;

import com.hway.fleet.model.User;

public interface UserService {
	
	void signup (User user);
	User login (String email, String psw);

}
