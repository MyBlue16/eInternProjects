package com.eintern.budgetracker.dao;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Order;
import org.hibernate.criterion.Restrictions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.eintern.budgetracker.entity.Expense;
import com.eintern.budgetracker.entity.Revenue;
import com.eintern.budgetracker.entity.User;


@Repository
public class UserDAO {
	@Autowired
	private SessionFactory sessionFactory;

	public SessionFactory getSessionFactory() {
		return sessionFactory;
	}

	public void setSessionFactory(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}
	
	@Transactional
	public Long saveUser(User user){
		User newU = user;
		newU.setAuthorities("ADMIN");
		return (Long)sessionFactory.getCurrentSession().save(newU);
	}
	
	@Transactional(readOnly=true)
	public User getUserByName(String name){
		return (User)sessionFactory.getCurrentSession().createCriteria(User.class).add(Restrictions.eq("name", name)).uniqueResult();
	}
	
	@Transactional(readOnly=true)
	public User getUserByUsernameAndPassword(String username, String password){
		return (User)sessionFactory.getCurrentSession().createCriteria(User.class).add(Restrictions.eq("username", username)).add(Restrictions.eq("password", password)).uniqueResult();
	}
	
	@Transactional
	public void deleteById(Long id) {
		Session s = sessionFactory.getCurrentSession();
		delete((User) s.get(User.class, id));
	}

	@Transactional
	public void delete(User u) {
		sessionFactory.getCurrentSession().delete(u);
	}

	@Transactional
	public Long addExpense(Expense e){
		return (Long)sessionFactory.getCurrentSession().save(e);
		
	}
	
	@Transactional
	public Long addRevenue(Revenue r)
	{
		return (Long)sessionFactory.getCurrentSession().save(r);
	}

	@Transactional(readOnly=true)
	public Expense getExpenseByID(Long id){
		return (Expense)sessionFactory.getCurrentSession().createCriteria(Expense.class)
				.add(Restrictions.eq("id", id)).uniqueResult();
	}
	
	@Transactional(readOnly=true)
	public Revenue getRevenueByID(Long id){
		return (Revenue)sessionFactory.getCurrentSession().createCriteria(Revenue.class)
				.add(Restrictions.eq("id", id)).uniqueResult();
	}

	@Transactional
	public void removeExpense(Expense expense) {
		sessionFactory.getCurrentSession().delete(expense);
	}

	@Transactional
	public void removeRevenue(Revenue revenue) {
		sessionFactory.getCurrentSession().delete(revenue);
	}

	@Transactional(readOnly=true)
	public List<Expense> getAllExpenses() {
		Criteria expenseCriteria = sessionFactory.getCurrentSession().createCriteria(Expense.class).addOrder(Order.asc("id"));
		List<Expense> expenses = expenseCriteria.list();
		return expenses;
		
	}
	
	@Transactional(readOnly=true)
	public List<Revenue> getAllRevenue() {
		Criteria revenueCriteria = sessionFactory.getCurrentSession().createCriteria(Revenue.class).addOrder(Order.asc("id"));
		List<Revenue> revenue = revenueCriteria.list();
		return revenue;
		
	}
	
	@Transactional(readOnly=true)
	public List<Revenue> getRevenueByClient(String client)
	{
		return sessionFactory.getCurrentSession().createCriteria(Revenue.class).add(Restrictions.eq("client", client)).addOrder(Order.asc("id")).list();
	}
	
	@Transactional(readOnly=true)
	public List<Expense> getExpenseByType(String type)
	{
		return sessionFactory.getCurrentSession().createCriteria(Expense.class).add(Restrictions.eq("expenseType", type)).addOrder(Order.asc("id")).list();
	}

}


