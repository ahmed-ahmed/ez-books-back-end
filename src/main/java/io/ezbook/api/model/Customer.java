package io.ezbook.api.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.ToString;

/**
 * Account generated by hbm2java
 */
@Entity
@Table(name = "customer")
@ToString
public class Customer implements java.io.Serializable {

	private static final long serialVersionUID = 3660651733680541216L;
	private long id;
	private String name;
	private String address;
	private String company;
	private String phoneNumber;
	private String emailAddress;
	
	
	public Customer() {
	}

	public Customer(long id) {
		this.id = id;
	}
	

	public Customer(long id, String name, String address, String company, String phoneNumber, String emailAddress) {
		super();
		this.id = id;
		this.name = name;
		this.address = address;
		this.company = company;
		this.phoneNumber = phoneNumber;
		this.emailAddress = emailAddress;
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
	
	@Column(name = "name")
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	@Column(name = "address")
	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	@Column(name = "company")
	public String getCompany() {
		return company;
	}

	public void setCompany(String company) {
		this.company = company;
	}

	@Column(name = "phoneNumber")
	public String getPhoneNumber() {
		return phoneNumber;
	}

	public void setPhoneNumber(String phoneNumber) {
		this.phoneNumber = phoneNumber;
	}

	@Column(name = "emailAddress")
	public String getEmailAddress() {
		return emailAddress;
	}

	public void setEmailAddress(String emailAddress) {
		this.emailAddress = emailAddress;
	}

}
