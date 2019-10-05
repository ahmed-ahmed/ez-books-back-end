package io.ezbook.api.service;

import java.util.Arrays;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import io.ezbook.api.model.Account;
import io.ezbook.api.model.AccountType;
import io.ezbook.api.repository.AccountRepository;
import io.ezbook.api.repository.AccountTypeRepository;

@Service
public class AccountService {

	@Autowired
	private AccountRepository accountRepository;
	
	@Autowired
	private AccountTypeRepository accountTypeRepository;

	public List<Account> findAll() {
		return accountRepository.findAll();
	}

	public List<AccountType> findAllAccountTypes(){
		return accountTypeRepository.findAll();
	}
	
	public List<AccountType> findAccountByType(String... accountTypes){
		return accountTypeRepository.findByNameIn(Arrays.asList(accountTypes));
	}
}
