package com.eintern.dao;

import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToMany;
import javax.persistence.OneToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

@Entity
@Table(name="UniversityStudents")
public class Student {
	
	@Id
	@GeneratedValue(generator="uStudgen")
	@SequenceGenerator(name="uStudgen", sequenceName="USTUDGEN", allocationSize=1)
	private int id;
	
	@Column
	private String name;
	
	@Column
	private String email;
	
	@Column
	private String classification;
	
	@Column
	private String major;
	
	@Column
	private boolean approved = false;
	
	
	@OneToOne(cascade=CascadeType.ALL)
	@JoinColumn(name="AccountID")
	private Account account;

	@ManyToMany(cascade=CascadeType.ALL)
	private Set<Courses> classSchedule;
	
	

	public int getId() {
		return id;
	}

	public String getName() {
		return name;
	}

	public String getEmail() {
		return email;
	}

	public String getClassification() {
		return classification;
	}

	public String getMajor() {
		return major;
	}

	public void setId(int student_id) {
		this.id = student_id;
	}

	public void setName(String name) {
		this.name = name;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public void setClassification(String class_status) {
		this.classification = class_status;
	}

	public void setMajor(String major) {
		this.major = major;
	}

	
	public Account getAccount() {
		return account;
	}

	public void setAccount(Account account) {
		this.account = account;
	}
	

	public boolean isApproved() {
		return approved;
	}

	public void setApproved(boolean approved) {
		this.approved = approved;
	}

	
	public Set<Courses> getClassSchedule() {
		return classSchedule;
	}

	public void setClassSchedule(Set<Courses> classSchedule) {
		this.classSchedule = classSchedule;
	}
	
	
	

}
