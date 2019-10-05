package io.ezbook.api.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import io.ezbook.api.model.Account;
import io.ezbook.api.service.AccountService;

@RestController
@RequestMapping("/accounts")
@CrossOrigin
public class AccountController {

	@Autowired
	private AccountService accountService;

    @GetMapping
    public List<Account> findAll() {
        return accountService.findAll();
    }

}
