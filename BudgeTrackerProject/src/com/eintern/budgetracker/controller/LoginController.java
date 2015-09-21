package com.eintern.budgetracker.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.eintern.budgetracker.entity.User;
import com.eintern.budgetracker.model.delegate.LoginDelegate;

@Controller
@RequestMapping("/login")
public class LoginController {
	@Autowired
	private LoginDelegate loginDelegate;
	
	@RequestMapping(method=RequestMethod.GET)
	public String login(Model model) {
		model.addAttribute(new User());
		return "login";
	}
	
	@RequestMapping(value="/submit", method=RequestMethod.GET)
	public String submit() {
		return "directory";
	}
}
