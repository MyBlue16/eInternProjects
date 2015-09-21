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
@Table(name="Advisors")
public class Advisor {
	
	@Id
	@GeneratedValue(generator="advisorgen")
	@SequenceGenerator(name="advisorgen", sequenceName="ADVISORGEN", allocationSize=1)
	private int id;
	
	@Column
	private String name;
	
	@Column
	private String email;
	
	@Column(name="Department")
	private String dept;
	
	@OneToOne(cascade=CascadeType.ALL)
	@JoinColumn(name="AccountID")
	private Account account;

	public int getAdvisorId() {
		return id;
	}

	public String getName() {
		return name;
	}

	public String getEmail() {
		return email;
	}

	public String getDept() {
		return dept;
	}

	public void setAdvisorId(int advisor_id) {
		this.id = advisor_id;
	}

	public void setName(String name) {
		this.name = name;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public void setDept(String dept) {
		this.dept = dept;
	}

	public Account getAccount() {
		return account;
	}

	public void setAccount(Account account) {
		this.account = account;
	}
	
	

}
