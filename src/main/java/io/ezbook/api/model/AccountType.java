package io.ezbook.api.model;
// Generated Sep 30, 2019 11:02:40 PM by Hibernate Tools 5.0.6.Final

import java.util.HashSet;
import java.util.Set;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

/**
 * AccountType generated by hbm2java
 */
@Entity
@Table(name = "account_type")
public class AccountType implements java.io.Serializable {

	private static final long serialVersionUID = 7192716695864610526L;
	private long id;
	private String name;
	private boolean type;
	private Set<AccountCategory> accountCategorieses = new HashSet<AccountCategory>(0);

	public AccountType() {
	}

	public AccountType(long id, String name, boolean type) {
		this.id = id;
		this.name = name;
		this.type = type;
	}

	public AccountType(long id, String name, boolean type, Set<AccountCategory> accountCategorieses) {
		this.id = id;
		this.name = name;
		this.type = type;
		this.accountCategorieses = accountCategorieses;
	}

	@Id

	@Column(name = "id", unique = true, nullable = false)
	public long getId() {
		return this.id;
	}

	public void setId(long id) {
		this.id = id;
	}

	@Column(name = "name", nullable = false)
	public String getName() {
		return this.name;
	}

	public void setName(String name) {
		this.name = name;
	}

	@Column(name = "type", nullable = false)
	public boolean isType() {
		return this.type;
	}

	public void setType(boolean type) {
		this.type = type;
	}

	@OneToMany(fetch = FetchType.LAZY, mappedBy = "accountType")
	public Set<AccountCategory> getAccountCategorieses() {
		return this.accountCategorieses;
	}

	public void setAccountCategorieses(Set<AccountCategory> accountCategorieses) {
		this.accountCategorieses = accountCategorieses;
	}

}
