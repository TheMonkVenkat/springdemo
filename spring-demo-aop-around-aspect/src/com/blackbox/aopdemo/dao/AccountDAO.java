package com.blackbox.aopdemo.dao;

import org.springframework.stereotype.Component;

import com.blackbox.aopdemo.Account;

@Component
public class AccountDAO {
	
	private String name;
	private double amount;
	
	public void addAccount(Account account, int balance) {
		System.out.println(getClass() +": Doing My DB Work: Adding an account");
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public double getAmount() {
		System.out.println("Getter:");
		return amount;
	}

	public void setAmount(double amount) {
		System.out.println("Setter:");
		this.amount = amount;
	}

}
