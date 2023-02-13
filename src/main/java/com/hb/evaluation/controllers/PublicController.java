package com.hb.evaluation.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class PublicController {
	
	@GetMapping("/")
	public String homePage() {
		
		return "home";
	}

}
