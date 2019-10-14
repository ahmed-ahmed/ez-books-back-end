package io.ezbook.api.service;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

import io.ezbook.api.model.AccountBalance;
import io.ezbook.api.model.ChartOfAccount;
import org.springframework.beans.factory.annotation.Autowired;

import io.ezbook.api.entity.Account;
import io.ezbook.api.entity.AccountType;
import io.ezbook.api.repository.AccountRepository;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Service;
//import io.ezbook.api.repository.AccountTypeRepository;

@Service
public class AccountService extends AbstractService<Account>{

	@Autowired
	private AccountRepository accountRepository;

//	@Autowired
//	private AccountTypeRepository accountTypeRepository;

	public Account addAccount(Account account) {
		return accountRepository.save(account);
	}

//	public List<Account> findAll() {
//		return accountRepository.findAll();
//	}

	public List<Account> getAccountTypes() {
		return accountRepository.findAccountByCategoryAccountIsTrue();
	}

	public List<ChartOfAccount> findLeafAccounts() {
		return accountRepository.getLeadAccounts();
	}

	public List<AccountBalance> getAccountBalances() {
		return accountRepository.getAccountBalances();
	}

	@Override
	public CrudRepository getRepo() {
		return accountRepository;
	}




//	public List<AccountType> findAllAccountTypes(){
//		return accountTypeRepository.findAll();
//	}

//	public List<AccountType> findAccountByType(String... accountTypes){
//		return accountTypeRepository.findByNameIn(Arrays.asList(accountTypes));
//	}
}
