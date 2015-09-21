package com.eintern.budgetracker.model.delegate;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.eintern.budgetracker.dao.UserDAO;
import com.eintern.budgetracker.entity.User;

@Component
public class LoginDelegate {
	@Autowired
	UserDAO userDAO;
	
	public User authenticate(User user)
	{
		return userDAO.getUserByUsernameAndPassword(user.getUsername(), user.getPassword());
	}
	
}
