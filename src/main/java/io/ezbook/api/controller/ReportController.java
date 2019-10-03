package io.ezbook.api.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import io.ezbook.api.model.Account;
import io.ezbook.api.model.AccountCategory;
import io.ezbook.api.model.AccountType;
import io.ezbook.api.service.AccountService;

@RestController
@RequestMapping("/reports")
public class ReportController {
	
	@Autowired
	private AccountService accountService;

	@GetMapping(path = "trialBalance")
	public Map<String, Map<String,Set<Account>>> getTrialBalanaceReport(){
		
		Map<String,Map<String,Set<Account>>> trialBalanceReport = new HashMap<>();
		Map<String,Set<Account>> accountByCategoryMap = new HashMap<>();
		
		List<AccountType> accountTypes = accountService.findAllAccountTypes();
		
		for(AccountType type : accountTypes) {
			accountByCategoryMap = new HashMap<>();
			for(AccountCategory category: type.getAccountCategorieses()) {
				accountByCategoryMap.put(category.getName(), category.getAccounts());
			}
			trialBalanceReport.put(type.getName(),  accountByCategoryMap);
		}
		return trialBalanceReport;
		
	}
	
}
