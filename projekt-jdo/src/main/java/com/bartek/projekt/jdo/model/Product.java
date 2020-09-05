
package com.bartek.projekt.jdo.model;

import com.fasterxml.jackson.annotation.JsonIgnore;

import java.io.Serializable;

import javax.jdo.annotations.*;

@PersistenceCapable(table = "product")
public class Product implements Serializable {

	private static final long serialVersionUID = -3448933197977350009L;

	@PrimaryKey
	@Persistent(valueStrategy = IdGeneratorStrategy.INCREMENT)
	private Long productId;

	@Persistent
	private String name;

	@Persistent
	private String description;

	@Persistent
	private Long categoryId;

	@Persistent
	private Double price;

	@JsonIgnore
	@Column(name = "categoryId")
	private Category category;

	public Product(Long productId, String name, String description, Double price, Long categoryId) {
		super();
		this.productId = productId;
		this.name = name;
		this.description = description;
		this.price = price;
		this.categoryId = categoryId;
	}

	public Long getProductId() {
		return productId;
	}

	public void setProductId(Long productId) {
		this.productId = productId;
	}

	public String getName() {
		return name;
	}

	public Long getCategoryId() {
		return categoryId;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public Double getPrice() {
		return price;
	}

	public void setPrice(Double price) {
		this.price = price;
	}

	public Category getCategory() {
		return category;
	}

	public void setCategory(Category category) {
		this.category = category;
	}
	public void setCategoryID(Long categoryId) {
		this.categoryId = categoryId;
	}
}