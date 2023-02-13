package com.hb.evaluation.controllers;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;

import com.hb.evaluation.dtos.UserDTO;
import com.hb.evaluation.dtos.UserFormDTO;
import com.hb.evaluation.services.UserService;

@Controller
public class UserController {

	private UserService userService;

	public UserController(UserService userService) {
		this.userService = userService;
	}
	
	@GetMapping("private/user/{userId}")
	public ModelAndView profilPage(@PathVariable String userId) {		
		Integer id = Integer.parseInt(userId);
		UserDTO user = userService.getUserById(id);
		ModelAndView mav = new ModelAndView("profil");
		mav.addObject("userForm", new UserFormDTO("", "", new ArrayList<>()));
		mav.addObject("user", user);		
		return mav;
	}
	
	@PostMapping("private/user/{userId}")
	public ModelAndView profilPage(@ModelAttribute UserFormDTO user) {		
		userService.updateUser(user);
		ModelAndView mav = new ModelAndView("redirect:/login");
		return mav;
	}

	@GetMapping("/signUp")
	public ModelAndView getRegistrationForm() {
		ModelAndView mav = new ModelAndView("register");
		mav.addObject("user", new UserFormDTO("", "", new ArrayList<>()));
		return mav;
	}

	@PostMapping("/signUp")
	public ModelAndView registerUser(@ModelAttribute UserFormDTO user) {
		userService.saveUser(user);
		ModelAndView mav = new ModelAndView("redirect:/login");
		return mav;
	}

}
