package com.bartek.projekt.jdo.model;

import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.jdo.annotations.*;

@PersistenceCapable(detachable = "true")
public class Person {
	@PrimaryKey
	@Persistent(valueStrategy = IdGeneratorStrategy.INCREMENT)
	private Long id;

	@Persistent
	private String name;

	@Persistent
	private String address;

	@Persistent
	private Long phone;

	@JsonIgnore
	@Column(name = "custommerAccountId")
	private CustommerAcount account;

	public Person() {
		super();
	}

	public Long getId() {
		return id;
	}

	public String getName() {
		return name;
	}

	public String getAddress() {
		return address;
	}

	public CustommerAcount getAccount() {
		return account;
	}

	public Long getPhone() {
		return phone;
	}

	public void setName(String name) {
		this.name = name;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public void setPhone(Long phone) {
		this.phone = phone;
	}

	public void setAccount(CustommerAcount account) {
		this.account = account;
	}

}