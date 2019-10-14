package io.ezbook.api.controller;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import com.google.common.collect.Lists;
import io.ezbook.api.entity.JournalEntity;
import io.ezbook.api.model.AccountPost;
import io.ezbook.api.model.ChartOfAccount;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import io.ezbook.api.annotation.LogExecutionTime;
import io.ezbook.api.entity.Account;
import io.ezbook.api.service.AccountService;

@RestController
@RequestMapping("/accounts")
@CrossOrigin
public class AccountController {

	@Autowired
	private AccountService accountService;

    @GetMapping(path = "allAccounts")
    @LogExecutionTime
    public List<Account> findAllAccounts() {
        return accountService.findAll();
    }

        @GetMapping
    @LogExecutionTime
    public List<ChartOfAccount> findAll() {
        return accountService.findAll().stream()
                .filter(account -> account.getParentAccount() != null)
                .map(account -> new ChartOfAccount(account.getId(), account.getName() ,account.getParentAccount().getName(), account.getChildren()))
                .collect(Collectors.toList());
    }

    @PostMapping
    public Account addAccount(@RequestBody AccountPost account) {
        Optional<Account> parentAccount = accountService.findById(account.getParentId());

        Account account1 = new Account();
        account1.setName(account.getName());
        account1.setAccountType(parentAccount.get().getAccountType());
        account1.setParentAccount(parentAccount.get());
        account1.setUserDefined(true);

        accountService.addAccount(account1);

        return account1;
//        return accountService.addAccount(account);
    }


    @GetMapping(path = "authorized")
    @LogExecutionTime
    @PreAuthorize("hasRole('ADMIN_USER')")
    public List<Account> findAllAuthorized() {
        return accountService.findAll();
    }

}
