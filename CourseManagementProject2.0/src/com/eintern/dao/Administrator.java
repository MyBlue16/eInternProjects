package com.eintern.dao;

import javax.persistence.CascadeType; 
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

@Entity
@Table(name="Administrators")
public class Administrator {

	
	@Id
	@GeneratedValue(generator="admingen")
	@SequenceGenerator(name="admingen", sequenceName="ADMINGEN", allocationSize=1)
	private int id;
	
	@Column
	private String name;
	
	@Column
	private String email;
	
	@OneToOne(cascade=CascadeType.ALL)
	@JoinColumn(name="AccountID")
	private Account account;
	
	
	public int getAdministrator_id() {
		return id;
	}

	public String getName() {
		return name;
	}

	public String getEmail() {
		return email;
	}

	public Account getAccout() {
		return account;
	}

	public void setAdministrator_id(int administrator_id) {
		this.id = administrator_id;
	}

	public void setName(String name) {
		this.name = name;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public void setAccout(Account accout) {
		this.account = accout;
	}

	
}
