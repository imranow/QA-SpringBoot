package com.example.controller;

import java.util.List;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.account.Account;

import com.example.service.AccountService;

@RestController
public class AccountController {
	private AccountService service;


	public AccountController(AccountService service) {
		super();
		this.service = service;
	}
	@PostMapping("/create")
	public Account create(@RequestBody Account acc){ 
	
		return this.service.addAccount(acc);
	}
	@GetMapping("/account")
	public List<Account> getList() {
		return this.service.readAccount();
	
	}
	@PutMapping("/update/{id}")
	public Account update (@PathVariable int id,@RequestBody Account acc) {
	
		return this.service.updateAccount(id, acc);
	}
	@DeleteMapping("/delete/{id}")
	public void delete (@PathVariable int id) {
		this.service.deleteAccount(id);
	}
	@GetMapping("/read/{accountname}")
	public List<Account> read(@PathVariable String AccountName){
		return this.service.getProductByAccount(AccountName);
	}
	@GetMapping("/read/{name}")
	public List<Account> readName(@PathVariable String name){
		return this.service.getAccountByName(name);
	}
	@GetMapping("/home")
	public String home() {
		return "My home";
	}

	

}
