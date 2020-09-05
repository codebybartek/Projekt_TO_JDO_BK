package com.bartek.projekt.jdo.model;

import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.jdo.annotations.*;

@PersistenceCapable(detachable = "true")
public class CustommerAcount {
	@PrimaryKey
	@Persistent(valueStrategy = IdGeneratorStrategy.INCREMENT)
	private Long id;

	@JsonIgnore
	@Column(name = "personId")
	private Person person;

	@Persistent
	private Long discount;

	public CustommerAcount() {
		super();
	}

	public Long getId() {
		return id;
	}

	public Person getPerson() {
		return person;
	}

	public Long getDiscount() {
		return discount;
	}


	public void setPerson(Person person) {
		this.person = person;
	}

	public void setDiscount(Long discount) {
		this.discount = discount;
	}

}