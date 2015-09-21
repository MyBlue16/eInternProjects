package com.eintern.budgetracker.controller;

import java.text.SimpleDateFormat;
import java.util.Date;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.propertyeditors.CustomDateEditor;
import org.springframework.security.access.annotation.Secured;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.eintern.budgetracker.entity.Revenue;
import com.eintern.budgetracker.model.delegate.RevenueDelegate;

@Controller
@Secured("ROLE_ADMIN")
public class RevenueController {
	@Autowired
	RevenueDelegate revenueDelegate;

	@RequestMapping(value="/revenues", method = RequestMethod.GET)
	public String addRevenue(Model model) {
		model.addAttribute(new Revenue());
		model.addAttribute("revenues", revenueDelegate.getAllRevenue());
		return "revenues";

	}

	@RequestMapping(value = "/addRevenue/submit", method = RequestMethod.POST)
	public String submitAdd(@Valid Revenue revenue, BindingResult bindingResult, Model model) {

		if (bindingResult.hasErrors()) {
			return "failure";
		}

		revenueDelegate.newRevenue(revenue);
		model.addAttribute("revenues", revenueDelegate.getAllRevenue());
		return "revenues";
	}

	@InitBinder
	public void binder(WebDataBinder binder) {
		binder.registerCustomEditor(Date.class, new CustomDateEditor(new SimpleDateFormat("yyyy-MM-dd"), false));
	}
	

	@RequestMapping(value = "/removeRevenue/submit", method = RequestMethod.POST)
	public String submitRemove(@Valid Revenue revenue, BindingResult bindingResult, Model model) {

		if (bindingResult.hasErrors()) {
			return "failure";
		}

		revenueDelegate.deleteRevenue(revenue);
		model.addAttribute("revenues", revenueDelegate.getAllRevenue());
		return "revenues";
	}
	
	
	@RequestMapping(value="/selectRevenue/submit", method=RequestMethod.POST)
	public String submitSelectRevenue(@Valid Revenue revenue, BindingResult bindingResult, Model model)
	{
		if (bindingResult.hasErrors()) {
			return "failure";
		}

		model.addAttribute("revenues", revenueDelegate.selectRange(revenue.getClient()));
		return "revenues";
	}

}
