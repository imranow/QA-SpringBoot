package com.example.account;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Account {
	
	@Column(unique = true, nullable = false)
	private String accountNumber;
	
	private int id;

	private String name;

	public String getAccountNumber() {
		return accountNumber;
	}

	public void setAccountNumber(String accountNumber) {
		this.accountNumber = accountNumber;
	}
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Account(String accountNumber, int id, String name) {
		super();
		this.accountNumber = accountNumber;
		this.id = id;
		this.name = name;
	}

	public Account() {
		super();
	}
	
	
	
	
	
}