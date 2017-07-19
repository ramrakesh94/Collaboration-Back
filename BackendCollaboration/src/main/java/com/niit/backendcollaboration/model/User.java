package com.niit.backendcollaboration.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

import org.springframework.stereotype.Component;

@Component
@Entity
@Table(name = "user123")
public class User {
	
	@Id
	@GeneratedValue
	private int cusId;
	private String name;
	
	private String username;
	private String role;

	private String email;
	
	private String password;
	private String address;
	private String zip;
	private String mobile;
	
	@Column(name="loggedIn")
    private String loggedIn;
    
    
	
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getLoggedIn() {
		return loggedIn;
	}
	public void setLoggedIn(String loggedIn) {
		this.loggedIn = loggedIn;
	}
	public String getUsername() {
		return username;
	}
	public int getCusId() {
		return cusId;
	}
	public void setCusId(int cusId) {
		this.cusId = cusId;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	
	
	public String getRole() {
		return role;
	}
	public void setRole(String role) {
		this.role = role;
	}
	
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	public String getZip() {
		return zip;
	}
	public void setZip(String zip) {
		this.zip = zip;
	}
	public String getMobile() {
		return mobile;
	}
	public void setMobile(String mobile) {
		this.mobile = mobile;
	}

    
}
