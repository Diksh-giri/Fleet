package com.hway.fleet.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

import jakarta.servlet.http.HttpSession;

@Controller
public class ProfileController {
	
	@GetMapping("/profile")
	public String getProfile( HttpSession session) {
		
		if(session.getAttribute("activeuser") == null) {
			return "Login";
			}
		
		return "Profile";
		
	}

}
