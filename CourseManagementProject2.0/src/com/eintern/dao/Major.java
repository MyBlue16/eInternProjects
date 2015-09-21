package com.eintern.dao;

import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table
public class Major {
	@Id
	private String name;
	
	@Column
	private int numClassesToDegree;
	
	@OneToMany(cascade=CascadeType.ALL)
	private Set<Courses> requiredCourses;

	public String getname() {
		return name;
	}

	public int getNumClassesToDegree() {
		return numClassesToDegree;
	}

	public Set<Courses> getRequiredCourses() {
		return requiredCourses;
	}

	public void setname(String name) {
		this.name = name;
	}

	public void setNumClassesToDegree(int numClassesToDegree) {
		this.numClassesToDegree = numClassesToDegree;
	}

	public void setRequiredCourses(Set<Courses> requiredCourses) {
		this.requiredCourses = requiredCourses;
	}
	
	
}
