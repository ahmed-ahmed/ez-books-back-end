package io.ezbook.api.model;
// Generated Sep 30, 2019 11:02:40 PM by Hibernate Tools 5.0.6.Final

import java.util.Date;
import java.util.HashSet;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import lombok.ToString;


/**
 * Journal generated by hbm2java
 */
@Entity
@Table(name = "journal")
@ToString
public class Journal implements java.io.Serializable {

	private static final long serialVersionUID = 1714010091805070070L;
	private long id;
	private Date date;
	private Set<JournalDetail> journalDetails = new HashSet<JournalDetail>(0);

	public Journal() {
	}

	public Journal(long id, Date date) {
		this.id = id;
		this.date = date;
	}

	public Journal(long id, Date date, Set<JournalDetail> journalDetails) {
		this.id = id;
		this.date = date;
		this.journalDetails = journalDetails;
	}

	@Id

	@Column(name = "id", unique = true, nullable = false)
	public long getId() {
		return this.id;
	}

	public void setId(long id) {
		this.id = id;
	}

	@Temporal(TemporalType.DATE)
	@Column(name = "date", nullable = false, length = 13)
	public Date getDate() {
		return this.date;
	}

	public void setDate(Date date) {
		this.date = date;
	}

	@OneToMany(fetch = FetchType.LAZY, mappedBy = "journal")
	public Set<JournalDetail> getJournalDetails() {
		return this.journalDetails;
	}

	public void setJournalDetails(Set<JournalDetail> journalDetails) {
		this.journalDetails = journalDetails;
	}

}
