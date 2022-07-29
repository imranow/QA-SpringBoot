package com.example.service;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.example.account.Account;
import com.example.repo.AccountRepo;


@Service
public class AccountService {
	private AccountRepo repo;
	
	
	public AccountService(AccountRepo repo) {
		super();
		this.repo = repo;
	}
	public Account addAccount(Account acc){
		return this.repo.save(acc);
	}
	public List<Account> readAccount() {
		return this.repo.findAll();
	
	}
	public Account updateAccount(int id, Account acc){
		Optional<Account> myTempAccount = this.repo.findById(id);
		Account existing=myTempAccount.get();		
		existing.setAccountNumber(acc.getAccountNumber());
		existing.setName(acc.getName());
		return this.repo.save(existing);
	}
	public boolean deleteAccount(int id) {
		this.repo.deleteById(id);
		boolean exists=this.repo.existsById(id);
		return !exists;
	}
	
	public List<Account> getProductByAccount(String AccountName){
		return this.repo.findAccountByAccountName(AccountName);
	}
	public List<Account> getAccountByName(String name){
		return this.repo.findAccountByName(name);
	}

	
	

}
