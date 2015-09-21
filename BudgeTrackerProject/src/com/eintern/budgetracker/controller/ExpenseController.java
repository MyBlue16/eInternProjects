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

import com.eintern.budgetracker.entity.Expense;
import com.eintern.budgetracker.model.delegate.ExpenseDelegate;

@Controller
@Secured("ROLE_ADMIN")
public class ExpenseController {
	@Autowired
	ExpenseDelegate expenseDelegate;
	

	@RequestMapping(value="/expenses", method = RequestMethod.GET)
	public String addExpense(Model model) {
		model.addAttribute(new Expense());
		model.addAttribute("expenses", expenseDelegate.getAllExpenses());
		return "expenses";

	}

	@RequestMapping(value="/addExpense/submit", method = RequestMethod.POST)
	public String submitNewExpense(@Valid Expense expense, BindingResult bindingResult,Model model) {

		if (bindingResult.hasErrors()) {
			return "failure";
		}
		expenseDelegate.newExpenses(expense);
		model.addAttribute("expenses", expenseDelegate.getAllExpenses());
		return "expenses";
	}

	@InitBinder
	public void binder(WebDataBinder binder) {
		binder.registerCustomEditor(Date.class, new CustomDateEditor(new SimpleDateFormat("yyyy-MM-dd"), false));
	}
	
	@RequestMapping(value="/removeExpense/submit", method = RequestMethod.POST)
	public String submitRemoveExpense(@Valid Expense expense, BindingResult bindingResult, Model model) {

		if (bindingResult.hasErrors()) {
			return "failure";
		}

		expenseDelegate.removeExpenses(expense);
		model.addAttribute("expenses", expenseDelegate.getAllExpenses());
		return "expenses";
	}
	
	@RequestMapping(value="/selectExpense/submit", method = RequestMethod.POST)
	public String submitSelectExpense(@Valid Expense expense, BindingResult bindingResult, Model model)
	{
		if (bindingResult.hasErrors()) {
			return "failure";
		}
		model.addAttribute("expenses", expenseDelegate.rangeOfExpenses(expense.getExpenseType()));
		return "expenses";
	}
	
	
}