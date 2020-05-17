package com.blackbox.aopdemo.dao;

import org.springframework.stereotype.Component;

import com.blackbox.aopdemo.Account;

@Component
public class AccountDAO {
	
	public void addAccount(Account account, int balance) {
		System.out.println(getClass() +": Doing My DB Work: Adding an account");
	}

}
