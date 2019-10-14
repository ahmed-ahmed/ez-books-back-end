package io.ezbook.api.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import io.ezbook.api.entity.Account;
import io.ezbook.api.entity.AccountType;
import io.ezbook.api.service.AccountService;

@RestController
@RequestMapping("/reports")
@CrossOrigin
public class ReportController {

	@Autowired
	private AccountService accountService;

	@GetMapping(path = "trialBalance")
	public Map<String, Map<String,Set<Account>>> getTrialBalanaceReport(){

		Map<String,Map<String,Set<Account>>> trialBalanceReport = new HashMap<>();
		Map<String,Set<Account>> accountByCategoryMap = new HashMap<>();

//		List<AccountType> accountTypes = accountService.findAllAccountTypes();

//		for(AccountType type : accountTypes) {
			accountByCategoryMap = new HashMap<>();
//			for(AccountCategory category: type.getAccountCategorieses()) {
//				accountByCategoryMap.put(category.getName(), category.getAccounts());
//			}
//			trialBalanceReport.put(type.getName(),  accountByCategoryMap);
//		}
		return trialBalanceReport;

	}

	@GetMapping(path = "balanceSheet")
	public Map<String, Map<String,Set<Account>>> getBalanaceSheetReport(){

		Map<String,Map<String,Set<Account>>> balanceSheetReport = new HashMap<>();
		Map<String,Set<Account>> accountByCategoryMap = new HashMap<>();

//		List<AccountType> accountTypes = accountService.findAccountByType("Assets","Liabilties", "Equity");

//		for(AccountType type : accountTypes) {
			accountByCategoryMap = new HashMap<>();
//			for(AccountCategory category: type.getAccountCategorieses()) {
////				accountByCategoryMap.put(category.getName(), category.getAccounts());
//			}
//			balanceSheetReport.put(type.getName(),  accountByCategoryMap);
//		}
		return balanceSheetReport;
	}


	@GetMapping(path = "generalLedger")
	public List<Account> getGeneralLedgerReport(){
		return accountService.findAll().stream()
				.filter(account -> account.getChildren().size() == 0 && account.getParentAccount() != null)
				.collect(Collectors.toList());
	}


}
