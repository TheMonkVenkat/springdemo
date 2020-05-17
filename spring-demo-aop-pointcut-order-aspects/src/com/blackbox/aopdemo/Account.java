package com.blackbox.aopdemo;

public class Account {
	
	private int amount;
	
	private int accountNumber;
	
	public Account() {
		
	}

	public Account(int amount, int accountNumber) {
		super();
		this.amount = amount;
		this.accountNumber = accountNumber;
	}

	public int getAmount() {
		return amount;
	}

	public void setAmount(int amount) {
		this.amount = amount;
	}

	public int getAccountNumber() {
		return accountNumber;
	}

	public void setAccountNumber(int accountNumber) {
		this.accountNumber = accountNumber;
	}

	@Override
	public String toString() {
		return "Account [amount=" + amount + ", accountNumber=" + accountNumber + "]";
	}
	
	

}
