package com.eintern.budgetracker.controller;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.annotation.Secured;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.eintern.budgetracker.entity.User;
import com.eintern.budgetracker.model.delegate.LoginDelegate;
import com.eintern.budgetracker.model.delegate.UserDelegate;


@Controller
@Secured("ROLE_ADMIN")
public class UserController {
	@Autowired
	UserDelegate userDelegate;
	@Autowired
	LoginDelegate loginDelegate;
	
	@RequestMapping(value="/registerUser", method=RequestMethod.GET)
	public String registerUser(Model model){
		model.addAttribute(new User());
		return "registerUser";
		
	}
	
	@RequestMapping(value="/registerUser/submit", method = RequestMethod.POST)
	public String submitRegister(@Valid User user, BindingResult bindingResult,
			Model model) 
{
		if (bindingResult.hasErrors()){
		
			return "registerUser";
		}
		
		userDelegate.addUser(user);		
		return "directory";
	}
	
	
	@RequestMapping(value="/removeUser", method=RequestMethod.GET)
	public String removeUser(Model model){
		model.addAttribute(new User());
		return "removeUser";
		
	}
	
	@RequestMapping(value="/removeUser/submit", method = RequestMethod.POST)
	public String submitRemove(@Valid User user, BindingResult bindingResult,
			Model model) 
{
		if (bindingResult.hasErrors()){
		
			return "removeUser";
		}
		
		userDelegate.removeUser(user);	
		return "directory";
	}
}



