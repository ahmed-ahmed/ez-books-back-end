package io.ezbook.api.entity;
// Generated Sep 30, 2019 11:02:40 PM by Hibernate Tools 5.0.6.Final

import java.math.BigDecimal;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonBackReference;

import lombok.ToString;


/**
 * JournalDetail generated by hbm2java
 */
@Entity
@Table(name = "journal_detail")
@ToString
public class JournalDetail implements java.io.Serializable {

	private static final long serialVersionUID = -4808758304212711781L;
	private long id;
	private JournalEntity journalEntity;
	private double debt;
	private double credit;
//	private Long accountId;

	private Account account;

	public JournalDetail() {
	}

	public JournalDetail(long id) {
		this.id = id;
	}

	public JournalDetail(long id, JournalEntity journalEntity, double debt, double credit) {
		this.id = id;
		this.journalEntity = journalEntity;
		this.debt = debt;
		this.credit = credit;
//		this.accountId = accountId;
	}

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name = "id", unique = true, nullable = false)
	public long getId() {
		return this.id;
	}

	public void setId(long id) {
		this.id = id;
	}

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "journalId")
	@JsonBackReference
	public JournalEntity getJournalEntity() {
		return this.journalEntity;
	}

	public void setJournalEntity(JournalEntity journalEntity) {
		this.journalEntity = journalEntity;
	}

	@Column(name = "debt", precision = 131089, scale = 0)
	public double getDebt() {
		return this.debt;
	}

	public void setDebt(double debt) {
		this.debt = debt;
	}

	@Column(name = "credit", precision = 131089, scale = 0)
	public double getCredit() {
		return this.credit;
	}

	public void setCredit(double credit) {
		this.credit = credit;
	}

//	@Column(name = "accountId")
//	public Long getAccountId() {
//		return this.accountId;
//	}
//
//	public void setAccountId(Long accountId) {
//		this.accountId = accountId;
//	}

	@OneToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "accountId", referencedColumnName = "id")
	public Account getAccount() {
		return account;
	}

	public void setAccount(Account account) {
		this.account = account;
	}
}
