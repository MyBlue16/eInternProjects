package com.eintern.budgetracker.model.delegate;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.eintern.budgetracker.dao.UserDAO;
import com.eintern.budgetracker.entity.Expense;

@Component
public class ExpenseDelegate {
	@Autowired
	UserDAO userDAO;

	public long newExpenses(Expense e) {
		
		return userDAO.addExpense(e);
	}

	public void removeExpenses(Expense expense) {
		userDAO.removeExpense(expense);
	}
	
	public List<Expense> getAllExpenses(){
		
		return userDAO.getAllExpenses();
		
	}

	public List<Expense> rangeOfExpenses(String expenseType) {
		return userDAO.getExpenseByType(expenseType);
	}
}
