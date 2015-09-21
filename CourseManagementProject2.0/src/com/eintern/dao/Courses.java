package com.eintern.dao;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table
public class Courses {
	@Id
	private int id;
	
	@Column
	private String courseName;
	
	@Column
	private String location;
	
	@Column 
	private int capSize;
	
	@Column
	private String startTime;
	
	@Column
	private String endTime;
	
	@Column
	private String semesterOffered;
	
	@ManyToOne(cascade=CascadeType.ALL)
	private Major majors;
	
/*	@ManyToMany(cascade=CascadeType.ALL)
	private Set<Student> students;
*/
	public int getId() {
		return id;
	}

	public String getCourseName() {
		return courseName;
	}

	public String getLocation() {
		return location;
	}

	public int getCapSize() {
		return capSize;
	}

	public String getStartTime() {
		return startTime;
	}

	public String getEndTime() {
		return endTime;
	}

	public String getSemesterOffered() {
		return semesterOffered;
	}

	public Major getMajors() {
		return majors;
	}

	public void setId(int id) {
		this.id = id;
	}

	public void setCourseName(String courseName) {
		this.courseName = courseName;
	}

	public void setLocation(String location) {
		this.location = location;
	}

	public void setCapSize(int capSize) {
		this.capSize = capSize;
	}

	public void setStartTime(String startTime) {
		this.startTime = startTime;
	}

	public void setEndTime(String endTime) {
		this.endTime = endTime;
	}

	public void setSemesterOffered(String semesterOffered) {
		this.semesterOffered = semesterOffered;
	}

	public void setMajors(Major majors) {
		this.majors = majors;
	}
		
}
