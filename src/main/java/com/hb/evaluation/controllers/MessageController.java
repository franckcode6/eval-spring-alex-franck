package com.hb.evaluation.controllers;

import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;


import com.hb.evaluation.dtos.MessageDTO;
import com.hb.evaluation.services.MessageService;

@Controller
@RequestMapping(value = "/private/message")
public class MessageController {
	
	private MessageService messageService;

	public MessageController(MessageService messageService) {
		this.messageService = messageService;
	}
	
	@GetMapping("")
	public ModelAndView getMessages() {
		List<MessageDTO> messages = messageService.getMessages();
		ModelAndView mav = new ModelAndView("messages");
		mav.addObject("messages", messages);
		return mav;
	}
	
	
	@GetMapping("/add")
	public ModelAndView addMessage() {
		ModelAndView mav = new ModelAndView("addmessage");
		
		mav.addObject("message", new MessageDTO(0, "", ""));
		return mav;
	}
	
	@PostMapping("/add")
	public ModelAndView addMessage(@ModelAttribute MessageDTO message) {
		
		messageService.addMessage(message);
		List<MessageDTO> messages = messageService.getMessages();
		ModelAndView mav = new ModelAndView("messages");
		mav.addObject("messages", messages);
		return mav;
	}

}
