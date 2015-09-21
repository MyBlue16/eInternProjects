package com.eintern.budgetracker.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.Pattern;

@Entity
@Table(name = "FinancialUsers")
public class User {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;

	@Column
	private String name;

	@Column(unique = true)
	@Pattern(regexp="[a-zA-Z0-9]+$", message="Username must be alphanumeric with no spaces")
	private String username;

	@Column
	private String password;

	@Column(unique = true)
	@Pattern(regexp="[A-Za-z0-9._%+-]+@[A-Za-z0-9.-]+.[A-Za-z]{2,4}", message="Invalid email address")
	private String email;
	
	@Column(nullable=false)
	private String authorities;

	public Long getId() {
		return id;
	}

	public String getName() {
		return name;
	}

	public String getUsername() {
		return username;
	}

	public String getPassword() {
		return password;
	}

	public String getEmail() {
		return email;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public void setName(String name) {
		this.name = name;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getAuthorities() {
		return authorities;
	}

	public void setAuthorities(String authorities) {
		this.authorities = authorities;
	}

	@Override
	public String toString() {
		return "User [id=" + id + ", name=" + name + ", username=" + username
				+ ", password=" + password + ", email=" + email + "]";
	}

}
