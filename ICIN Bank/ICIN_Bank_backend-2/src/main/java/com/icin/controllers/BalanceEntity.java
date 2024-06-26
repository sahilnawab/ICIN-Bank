package com.icin.controllers;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;

public class BalanceEntity {

	private double amount;

	public double getAmount() {
		return amount;
	}

	public void setAmount(double amount) {
		this.amount = amount;
	}


}
