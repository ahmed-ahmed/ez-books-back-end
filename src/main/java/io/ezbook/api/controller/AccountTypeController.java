package io.ezbook.api.controller;

import io.ezbook.api.annotation.LogExecutionTime;
import io.ezbook.api.entity.Account;
import io.ezbook.api.service.AccountService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/accountTypes")
@CrossOrigin
public class AccountTypeController {
    @Autowired
    private AccountService accountService;

    @GetMapping
    @LogExecutionTime
    public List<Account> findAllAccounts() {
        return accountService.getAccountTypes();
    }
}
