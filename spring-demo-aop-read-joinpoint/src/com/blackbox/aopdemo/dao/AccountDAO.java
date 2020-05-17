package com.blackbox.aopdemo.dao;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Component;

import com.blackbox.aopdemo.Account;

@Component
public class AccountDAO {
	
	public void addAccount(Account account, boolean isActive) {
		System.out.println(getClass() +": Doing My DB Work: Adding an account");
	}

	public List<Account> findAccounts(){
		
		List<Account> myAccounts = new ArrayList<>();
		
		myAccounts.add(new Account("John", "Silver"));
		myAccounts.add(new Account("Silva", "Gold"));
		myAccounts.add(new Account("Beth", "Platinam"));
		
		return myAccounts;
	}
}
