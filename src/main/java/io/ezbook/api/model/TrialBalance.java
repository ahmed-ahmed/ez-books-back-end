package io.ezbook.api.model;

import io.ezbook.api.entity.AccountType;

public class TrialBalance {
    private final long id;
    private final String name;

    private double creditBalance;
    private double debtBalance;

    private final AccountType accountType;

    public TrialBalance(long id, String name, double debtBalance, double creditBalance, AccountType accountType) {
        this.id = id;
        this.name = name;
        this.accountType = accountType;

        switch (accountType) {
            case Assets:
            case Expense:
                this.debtBalance = debtBalance - creditBalance;
                break;
            case Liability:
            case Equity:
            case Income:
                this.creditBalance = creditBalance - debtBalance;
                break;
        }

//        this.creditBalance = creditBalance;
//        this.debtBalance = debtBalance;
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
