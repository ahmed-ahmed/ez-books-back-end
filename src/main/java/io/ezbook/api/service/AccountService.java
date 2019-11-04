package io.ezbook.api.service;

import java.util.List;

import io.ezbook.api.model.AccountBalance;
import io.ezbook.api.model.ChartOfAccount;
import io.ezbook.api.model.TrialBalance;
import org.springframework.beans.factory.annotation.Autowired;

import io.ezbook.api.entity.Account;
import io.ezbook.api.repository.AccountRepository;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Service;

@Service
public class AccountService extends AbstractService<Account> {

	@Autowired
	private AccountRepository accountRepository;

	public Account addAccount(Account account) {
		return accountRepository.save(account);
	}

	public List<Account> getAccountTypes() {
		return accountRepository.findAccountByCategoryAccountIsTrue();
	}

	public List<ChartOfAccount> findLeafAccounts() {
		return accountRepository.getLeafAccounts();
	}

	public ChartOfAccount findLeafAccount(long id) {
		return accountRepository.getLeafAccount(id);
	}


	public List<AccountBalance> getAccountBalances() {
		return accountRepository.getAccountBalances();
	}

	public List<TrialBalance> getTrialBalances() {
		return accountRepository.getTrialBalancess();
	}

	@Override
	public CrudRepository getRepo() {
		return accountRepository;
	}
}
