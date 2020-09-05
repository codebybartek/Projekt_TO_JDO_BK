
package com.bartek.projekt.jdo.model;

import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.jdo.annotations.*;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;


@PersistenceCapable(table = "shop")
public class Shop implements Serializable {

	private static final long serialVersionUID = -3898880301582195848L;

	@PrimaryKey
	@Persistent(valueStrategy = IdGeneratorStrategy.INCREMENT)
	private String shopId;

	private String name;

	private String address;

	public Shop(String name, String address) {
		this.name = name;
		this.address = address;
	}

	public String getShopId() {
		return shopId;
	}

	public void setShopId(String shopId) {
		this.shopId = shopId;
	}

	public String getShopName() {
		return name;
	}

	public void setShopName(String name) {
		this.name = name;
	}

	public String getShopAddress() {
		return address;
	}

	public void setShopAddress(String address) {
		this.address = address;
	}




}