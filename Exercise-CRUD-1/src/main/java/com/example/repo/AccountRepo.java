package com.example.repo;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.stereotype.Repository;

import com.example.account.Account;

@Repository
@EnableJpaRepositories
public interface AccountRepo extends JpaRepository<Account, Integer >{
	@Query(value="select * from account where account name=?1", nativeQuery=true)
	List<Account>findAccountByAccountName(String AccountName);
	
	@Query("SELECT a from Account a WHERE a.name = ?1")
    List<Account> findAccountByName(String name);
	

}
