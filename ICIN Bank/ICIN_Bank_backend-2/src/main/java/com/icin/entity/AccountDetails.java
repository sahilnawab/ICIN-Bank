package com.icin.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToOne;

@Entity
public class AccountDetails {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int accid;
	private long accountNumber;
	private String IFSC;
	private double balance;
	@OneToOne(mappedBy = "accountDetails")
	private User user;

	
	
	
	
	public long getAccountNumber() {
		return accountNumber;
	}

	public void setAccountNumber(long accountNumber) {
		this.accountNumber = accountNumber;
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	public void setAccid(int accid) {
		this.accid = accid;
	}

	public AccountDetails() {
		// TODO Auto-generated constructor stub
	}

	public String getIFSC() {
		return IFSC;
	}

	public void setIFSC(String iFSC) {
		IFSC = iFSC;
	}

	public double getBalance() {
		return balance;
	}

	public void setBalance(double balance) {
		this.balance = balance;
	}

	public int getAccid() {
		return accid;
	}

	public long getAccount_number() {
		return accountNumber;
	}

	public AccountDetails(long accountNumber, String iFSC, double balance) {
		super();
		this.accountNumber = accountNumber;
		IFSC = iFSC;
		this.balance = balance;
	}

	
	 
	
	
	
}
