package com.library.book.request;

import java.io.Serializable;

import javax.validation.constraints.NotNull;

import com.library.book.util.UserRole;

public class UserRequest{
	
	@NotNull(message="name cannot be null")
	private String name;
	private String address;
	private String email;
	private String phoneNo;
	private UserRole userStatus;
	private String username;
	private String password;
	
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getPhoneNo() {
		return phoneNo;
	}
	public void setPhoneNo(String phoneNo) {
		this.phoneNo = phoneNo;
	}
	public UserRole getUserStatus() {
		return userStatus;
	}
	public void setUserStatus(UserRole userStatus) {
		this.userStatus = userStatus;
	}
	
	

}
