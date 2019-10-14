package io.ezbook.api.model;

import io.ezbook.api.entity.Account;

import java.util.List;

public class ChartOfAccount {
    private long id;
    private String name;
    private String accountType;

    private List<Account> children;

    public ChartOfAccount() {
    }

    public ChartOfAccount(long id, String name, String accountType, List<Account> children) {
        this.id = id;
        this.name = name;
        this.accountType = accountType;
        this.children = children;
    }

    public long getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getAccountType() {
        return accountType;
    }

    public List<Account> getChildren() {
        return children;
    }
}
