package io.ezbook.api.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import io.ezbook.api.model.Account;
import io.ezbook.api.repo.AccountRepo;

@Service
public class AccountService {

	@Autowired
    private AccountRepo accountRepo;
	
	 public List<Account> findAll() {
       return accountRepo.findAll();
   }
	
}
