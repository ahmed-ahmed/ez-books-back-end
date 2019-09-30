package io.ezbook.api.controller;

import io.ezbook.api.repo.AccountRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/accounts")
public class AccountController {
    @Autowired
    private AccountRepo accountRepo;

    @GetMapping
    public List findAll() {
//        return "hi";
        return accountRepo.findAll();
    }

}
