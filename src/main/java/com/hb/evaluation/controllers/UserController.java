package com.hb.evaluation.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;

import com.hb.evaluation.dtos.UserFormDTO;
import com.hb.evaluation.services.UserService;

@Controller
public class UserController {

private UserService userService;
	
	public UserController(UserService userService) {
		this.userService = userService;		
	}
	
	
	@GetMapping("/signUp")
	public ModelAndView getRegistrationForm() {		
		ModelAndView mav = new ModelAndView("register");
		mav.addObject("user", new UserFormDTO("", ""));
		return mav;
	}
	
	@PostMapping("/signUp")
	public ModelAndView registerUser(@ModelAttribute UserFormDTO user) {		
		userService.saveUser(user);		
		ModelAndView mav = new ModelAndView("redirect:/login");
		return mav;		
	}
	
}
