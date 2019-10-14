package io.ezbook.api.model;

import io.ezbook.api.entity.AccountType;

public class AccountBalance {
    private final long id;
    private final String name;

    private final double creditBalance;
    private final double debtBalance;

    private final AccountType accountType;

    public AccountBalance(long id, String name, double creditBalance, double debtBalance, AccountType accountType) {
        this.id = id;
        this.name = name;
        this.creditBalance = creditBalance;
        this.debtBalance = debtBalance;
        this.accountType = accountType;
    }

    public long getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public double getCreditBalance() {
        return creditBalance;
    }

    public double getDebtBalance() {
        return debtBalance;
    }

    public AccountType getAccountType() {
        return accountType;
    }
}
