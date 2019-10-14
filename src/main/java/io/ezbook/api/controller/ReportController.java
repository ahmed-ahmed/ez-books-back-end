package io.ezbook.api.controller;

import io.ezbook.api.entity.Account;
import io.ezbook.api.model.AccountBalance;
import io.ezbook.api.service.AccountService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;

@RestController
@RequestMapping("/reports")
@CrossOrigin
public class ReportController {

    @Autowired
    private AccountService accountService;

    @GetMapping(path = "trialBalance")
    public Map<String, Map<String, Set<Account>>> getTrialBalanaceReport() {

        Map<String, Map<String, Set<Account>>> trialBalanceReport = new HashMap<>();
        Map<String, Set<Account>> accountByCategoryMap = new HashMap<>();

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
    public Map<String, Map<String, Set<Account>>> getBalanaceSheetReport() {

        Map<String, Map<String, Set<Account>>> balanceSheetReport = new HashMap<>();
        Map<String, Set<Account>> accountByCategoryMap = new HashMap<>();

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

    @GetMapping(path = "accountBalances")
    public List<AccountBalance> getGeneralLedgerReport() {
        return accountService.getAccountBalances();
    }
}