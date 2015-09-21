package com.eintern.budgetracker.model.delegate;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.eintern.budgetracker.dao.UserDAO;
import com.eintern.budgetracker.entity.User;

@Component
public class UserDelegate {
	@Autowired
	UserDAO userDAO;
	public long addUser(User u)
	{
		return userDAO.saveUser(u);
		
	}
	public void removeUser(User user) {
		userDAO.delete(user);
	}
}
