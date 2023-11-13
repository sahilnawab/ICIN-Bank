package com.icin.entity;

import java.time.Instant;
import java.util.Date;

import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.SourceType;
import org.hibernate.annotations.UpdateTimestamp;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToOne;


@Entity
public class User {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id ;
	private String firstName;
	private String lastName;
	@Column(unique = true)
	private String email;
	private String phone;
	private String password;
	private int age;
	private boolean isAdmin=false;
	@CreationTimestamp
	private Instant createdOn;
	@UpdateTimestamp
	private Instant UpdatedOn;
	@OneToOne(fetch = FetchType.EAGER,cascade = CascadeType.ALL)
	private AccountDetails accountDetails;
	
	

public User() {
	// TODO Auto-generated constructor stub
}



public User(String firstName, String lastName, String email, String phone, String password, int age, AccountDetails accountDetails, boolean isAdmin) {
	super();
	this.firstName = firstName;
	this.lastName = lastName;
	this.email = email;
	this.phone = phone;
	this.password = password;
	this.age = age;
	this.accountDetails = accountDetails;
	this.isAdmin=isAdmin;
}



public String getEmail() {
	return email;
}

public void setEmail(String email) {
	this.email = email;
}

public String getPhone() {
	return phone;
}

public void setPhone(String phone) {
	this.phone = phone;
}

public String getPassword() {
	return password;
}

public void setPassword(String password) {
	this.password = password;
}

public int getId() {
	return id;
}

public void setId(int id) {
	this.id = id;
}

public String getFirstName() {
	return firstName;
}

public void setFirstName(String firstName) {
	this.firstName = firstName;
}

public String getLastName() {
	return lastName;
}

public void setLastName(String lastName) {
	this.lastName = lastName;
}

public int getAge() {
	return age;
}

public void setAge(int age) {
	this.age = age;
}



public AccountDetails getAccountDetails() {
	return accountDetails;
}



public void setAccountDetails(AccountDetails accountDetails) {
	this.accountDetails = accountDetails;
}



public boolean isAdmin() {
	return isAdmin;
}



public void setAdmin(boolean isAdmin) {
	this.isAdmin = isAdmin;
}



public Instant getCreatedOn() {
	return createdOn;
}



public Instant getUpdatedOn() {
	return UpdatedOn;
}





}
