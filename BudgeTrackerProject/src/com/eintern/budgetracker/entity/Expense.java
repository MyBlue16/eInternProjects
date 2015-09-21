package com.eintern.budgetracker.entity;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Expense {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;

	@Column(nullable = false)
	private Date dateSpent;

	@Column(nullable = false)
	private double amount;

	@Column(nullable = false)
	private String expenseType;

	public Long getId() {
		return id;
	}

	public Date getDateSpent() {
		return dateSpent;
	}

	public double getAmount() {
		return amount;
	}

	public String getExpenseType() {
		return expenseType;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public void setDateSpent(Date date) {
		this.dateSpent = date;
	}

	public void setAmount(double amount) {
		this.amount = amount;
	}

	public void setExpenseType(String expenseType) {
		this.expenseType = expenseType;
	}

	@Override
	public String toString() {
		return "Expenses [id=" + id + ", dateSpent=" + dateSpent + ", amount="
				+ amount + ", expenseType=" + expenseType + "]";
	}

}
