package io.ezbooks.api.model;

import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import java.math.BigInteger;
import java.util.Objects;

@Entity
public class JournalDetail {
    private long id;
    private BigInteger debt;
    private BigInteger credit;

    @Id
    @Column(name = "id")
    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    @Basic
    @Column(name = "debt")
    public BigInteger getDebt() {
        return debt;
    }

    public void setDebt(BigInteger debt) {
        this.debt = debt;
    }

    @Basic
    @Column(name = "credit")
    public BigInteger getCredit() {
        return credit;
    }

    public void setCredit(BigInteger credit) {
        this.credit = credit;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        JournalDetail that = (JournalDetail) o;
        return id == that.id &&
                Objects.equals(debt, that.debt) &&
                Objects.equals(credit, that.credit);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, debt, credit);
    }
}
