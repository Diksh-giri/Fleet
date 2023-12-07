package com.hway.fleet.controller;

import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.util.DigestUtils;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import com.hway.fleet.controller.UserController;
import com.hway.fleet.service.UserService;
import com.hway.fleet.model.User;

import ch.qos.logback.classic.Logger;
import jakarta.servlet.http.HttpSession;

@Controller
public class UserController {

	private static final Logger log = (Logger) LoggerFactory.getLogger(UserController.class);

	@Autowired
	private UserService userService;
	
	@GetMapping({"/login","/"})
	public String getlogin() {
		
		return "Login";
		
	}
	
	@PostMapping("/login")
	public String postlogin(@ModelAttribute User user ,Model model, HttpSession session) {

		user.setPassword(DigestUtils.md5DigestAsHex(user.getPassword().getBytes()));
		User usr = userService.login(user.getEmail(),  user.getPassword());
		
		if(usr != null) {
			
			log.info("---------------Login Success-----------");
			
			session.setAttribute("activeuser", usr);
			session.setMaxInactiveInterval(200);
		//	model.addAttribute("name",usr.getFirstName());
			return "Home";
		}
		model.addAttribute("message","user not found!!");
		return "Login";
		
	}
		@GetMapping("/signup")
		public String getSignup() {
			log.info("----------SignUp file loaded------------");

			
			return "Signup";
					
		}
		
		@PostMapping("/signup")
		public String postSignup(@ModelAttribute User user) {
			
			user.setPassword(DigestUtils.md5DigestAsHex(user.getPassword().getBytes()));
			userService.signup(user);
			
			return "Login";
		}
		
		@GetMapping("/home")
		public String getHome(HttpSession session) {
			
			if(session.getAttribute("activeuser") == null) {
				return "Login";
				}
			return "Home";
		}
		
		@GetMapping("/logout")
		public String logout(HttpSession session) {
			
			if(session.getAttribute("activeuser") == null) {
				return "Login";
				}
			return "Login";
		}
		
	
	
}
