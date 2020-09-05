
package com.bartek.projekt.jdo.model;

import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.jdo.annotations.*;
import java.io.Serializable;

@PersistenceCapable(table = "sequence_table")
public class Sequence implements Serializable {


	@PrimaryKey
	@Persistent(valueStrategy = IdGeneratorStrategy.INCREMENT)
	@Column(name = "SEQUENCE_NAME")
	private String SEQUENCE_NAME;

	@Column(name = "NEXT_VAL")
	private Integer NEXT_VAL;

	public String getSEQUENCE_NAME() {
		return SEQUENCE_NAME;
	}

	public Integer getNEXT_VAL() {
		return NEXT_VAL;
	}


}