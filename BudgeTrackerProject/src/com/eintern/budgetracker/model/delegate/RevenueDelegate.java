package com.eintern.budgetracker.model.delegate;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.eintern.budgetracker.dao.UserDAO;
import com.eintern.budgetracker.entity.Revenue;

@Component
public class RevenueDelegate {
	@Autowired
	UserDAO userDAO;
		
	public long newRevenue(Revenue r )
	{
		return userDAO.addRevenue(r);
	}

	public void deleteRevenue(Revenue revenue) {
		userDAO.removeRevenue(revenue);
	}
	
	public List<Revenue> getAllRevenue(){
		return userDAO.getAllRevenue();
	}

	public List<Revenue> selectRange(String client) {
		return userDAO.getRevenueByClient(client);
	}
}
