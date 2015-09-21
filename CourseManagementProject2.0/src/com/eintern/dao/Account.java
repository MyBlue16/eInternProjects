package com.eintern.dao;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

@Entity
@Table(name="Accounts")
public class Account {

		@Id
		@GeneratedValue(generator="acctgen")
		@SequenceGenerator(name="acctgen", sequenceName="ACCTGEN", allocationSize=1)
		private int account_id;
		@Column
		private String username;
		@Column
		private String password;
		
		@Column
		private String role;
		
		@OneToOne(mappedBy="account",cascade=CascadeType.ALL)
		private Administrator admin;
		
		
		@OneToOne(mappedBy="account", cascade=CascadeType.ALL)
		private Student stud;
		
		@OneToOne(mappedBy="account", cascade=CascadeType.ALL)
		private Advisor advisor;
			
		
		public int getAccount_id() {
			return account_id;
		}
		public String getUsername() {
			return username;
		}
		public String getPassword() {
			return password;
		}
		public void setAccount_id(int account_id) {
			this.account_id = account_id;
		}
		public void setUsername(String username) {
			this.username = username;
		}
		public void setPassword(String password) {
			this.password = password;
		}
		public Administrator getAdmin() {
			return admin;
		}
		public void setAdmin(Administrator admin) {
			this.admin = admin;
		}
		public String getRole() {
			return role;
		}
		public void setRole(String role) {
			this.role = role;
		}
		
		public Student getStud() {
			return stud;
		}
		public void setStud(Student stud) {
			this.stud = stud;
		}
		public Advisor getAdvisor() {
			return advisor;
		}
		public void setAdvisor(Advisor advisor) {
			this.advisor = advisor;
		}
		
		
		
		
		
	
}
