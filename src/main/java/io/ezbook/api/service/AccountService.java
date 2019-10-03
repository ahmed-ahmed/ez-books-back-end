package io.ezbook.api.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import io.ezbook.api.model.Account;
import io.ezbook.api.model.AccountType;
import io.ezbook.api.repo.AccountRepo;
import io.ezbook.api.repo.AccountTypeRepo;

@Service
public class AccountService {

	@Autowired
	private AccountRepo accountRepository;
	
	@Autowired
	private AccountTypeRepo accountTypeRepository;

	public List<Account> findAll() {
		return accountRepository.findAll();
	}

	public List<AccountType> findAllAccountTypes(){
		return accountTypeRepository.findAll();
	}
}
