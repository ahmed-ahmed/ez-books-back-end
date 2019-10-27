package io.ezbook.api.controller;

import io.ezbook.api.annotation.LogExecutionTime;
import io.ezbook.api.entity.Account;
import io.ezbook.api.model.AccountPost;
import io.ezbook.api.model.ChartOfAccount;
import io.ezbook.api.service.AccountService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/accounts")
@CrossOrigin
public class AccountController {

    @Autowired
    private AccountService accountService;

//    @GetMapping(path = "allAccounts")
//    @LogExecutionTime
//    public List<Account> findAllAccounts() {
//        return accountService.findAll();
//    }

    @GetMapping
    @LogExecutionTime
    public List<ChartOfAccount> findAll() {
        return accountService.findLeafAccounts();
//                .stream()
//                .filter(account -> account.getParentAccount() != null)
//                .map(account -> new ChartOfAccount(account.getId(), account.getName(), account.getParentAccount().getName()))
//                .collect(Collectors.toList());
    }

    @PostMapping
    public Account addAccount(@RequestBody AccountPost input) {
        Optional<Account> parentAccount = accountService.findById(input.getParentId());

        Account account = new Account();
        account.setName(input.getName());
        account.setAccountType(parentAccount.get().getAccountType());
        account.setParentAccount(parentAccount.get());
        account.setUserDefined(true);
        account.setDescription(input.getDescription());

        accountService.addAccount(account);

        return account;
    }


//    @GetMapping(path = "authorized")
//    @LogExecutionTime
//    @PreAuthorize("hasRole('ADMIN_USER')")
//    public List<Account> findAllAuthorized() {
//        return accountService.findAll();
//    }

}
