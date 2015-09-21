package com.eintern.budgetracker.entity;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Revenue {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;

	@Column(nullable=false)
	private Date datePaid;

	@Column(nullable=false)
	private String client;

	@Column(nullable=false)
	private double amount;

	public Long getId() {
		return id;
	}

	public Date getDatePaid() {
		return datePaid;
	}

	public String getClient() {
		return client;
	}

	public double getAmount() {
		return amount;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public void setDatePaid(Date datePaid) {
		this.datePaid = datePaid;
	}

	public void setClient(String client) {
		this.client = client;
	}

	public void setAmount(double amount) {
		this.amount = amount;
	}

	@Override
	public String toString() {
		return "Revenue [id=" + id + ", datePaid=" + datePaid + ", client="
				+ client + ", amount=" + amount + "]";
	}

}
