package io.ezbook.api.entity;

// Generated Sep 30, 2019 11:02:40 PM by Hibernate Tools 5.0.6.Final

import java.math.BigDecimal;
import java.util.List;

import javax.persistence.*;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import com.fasterxml.jackson.annotation.JsonProperty;

@Entity
@Table(name = "account")
//@ToString
public class Account implements java.io.Serializable {

	private static final long serialVersionUID = 3660651733680541216L;
	private long id;

	private double creditBalance;
	private double debtBalance;
	private String name;

	private boolean isUserDefined;

	private Account parentAccount;
	private List<Account> children;

	private boolean isCategoryAccount;

	private AccountType accountType;

	private String description;

	public Account() {
	}

	public Account(long id) {
		this.id = id;
	}

	public Account(long id, double creditBalance, double debtBalance,
			String name, boolean isUserDefined) {
		this.id = id;
//		this.accountCategories = accountCategories;
		this.creditBalance = creditBalance;
		this.debtBalance = debtBalance;
		this.name = name;
		this.isUserDefined = isUserDefined;
	}

	@Id
	@Column(name = "id", unique = true, nullable = false)
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	public long getId() {
		return this.id;
	}

	public void setId(long id) {
		this.id = id;
	}

	@Column(name = "creditBalance")
	@JsonProperty("credit")
	public double getCreditBalance() {
		return this.creditBalance;
	}

	public void setCreditBalance(double creditBalance) {
		this.creditBalance = creditBalance;
	}

	@Column(name = "debtBalance")
	@JsonProperty("debt")
	public double getDebtBalance() {
		return this.debtBalance;
	}

	public void setDebtBalance(double debtBalance) {
		this.debtBalance = debtBalance;
	}

	@Column(name = "name")
	public String getName() {
		return this.name;
	}

	public void setName(String name) {
		this.name = name;
	}

	@Column(name = "isUserDefined")
	@JsonProperty("isUserDefined")
	public boolean isUserDefined() {
		return isUserDefined;
	}

	public void setUserDefined(boolean userDefined) {
		isUserDefined = userDefined;
	}

	@Column(name = "isCategoryAccount")
	@JsonProperty("isCategoryAccount")
	public boolean isCategoryAccount() {
		return isCategoryAccount;
	}

	public void setCategoryAccount(boolean categoryAccount) {
		isCategoryAccount = categoryAccount;
	}

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "parentId")
	@JsonIgnore
	public Account getParentAccount() {
		return parentAccount;
	}

	public void setParentAccount(Account parentAccount) {
		this.parentAccount = parentAccount;
	}

	@OneToMany(mappedBy="parentAccount", fetch = FetchType.LAZY)
	@JsonIgnore
	public List<Account> getChildren() {
		return children;
	}

	public void setChildren(List<Account> children) {
		this.children = children;
	}

	@Column(name = "accountType")
	@JsonProperty("accountType")
	public AccountType getAccountType() {
		return accountType;
	}

	public void setAccountType(AccountType accountType) {
		this.accountType = accountType;
	}

	@Column(name = "description")
	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}
}
