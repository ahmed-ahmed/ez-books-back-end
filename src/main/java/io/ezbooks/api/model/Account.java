package io.ezbooks.api.model;

import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import java.math.BigInteger;
import java.util.Objects;

@Entity
public class Account {
    private long id;
    private BigInteger debtBalance;
    private BigInteger creditBalance;
    private BigInteger totalBalance;
    private String name;

    @Id
    @Column(name = "id")
    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    @Basic
    @Column(name = "debtBalance")
    public BigInteger getDebtBalance() {
        return debtBalance;
    }

    public void setDebtBalance(BigInteger debtBalance) {
        this.debtBalance = debtBalance;
    }

    @Basic
    @Column(name = "creditBalance")
    public BigInteger getCreditBalance() {
        return creditBalance;
    }

    public void setCreditBalance(BigInteger creditBalance) {
        this.creditBalance = creditBalance;
    }

    @Basic
    @Column(name = "totalBalance")
    public BigInteger getTotalBalance() {
        return totalBalance;
    }

    public void setTotalBalance(BigInteger totalBalance) {
        this.totalBalance = totalBalance;
    }

    @Basic
    @Column(name = "name")
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Account account = (Account) o;
        return id == account.id &&
                Objects.equals(debtBalance, account.debtBalance) &&
                Objects.equals(creditBalance, account.creditBalance) &&
                Objects.equals(totalBalance, account.totalBalance) &&
                Objects.equals(name, account.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, debtBalance, creditBalance, totalBalance, name);
    }
}
