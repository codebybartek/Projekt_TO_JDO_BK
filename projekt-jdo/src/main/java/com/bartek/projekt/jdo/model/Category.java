
package com.bartek.projekt.jdo.model;

import javax.jdo.annotations.*;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

@PersistenceCapable(table = "category")
public class Category implements Serializable {

	private static final long serialVersionUID = -3898880301582195848L;

	@PrimaryKey
	@Persistent(valueStrategy = IdGeneratorStrategy.INCREMENT)
	private Long categoryId;

	private String name;

	@Persistent(mappedBy = "category")
	private List<Product> products;


	public Category() {
		super();
	}

	public Long getCategoryId() {
		return categoryId;
	}

	public void setCategoryName(String name) {
		this.name = name;
	}

	public String getCategoryName() {
		return name;
	}

	public void setCategoryId(Long categoryId) {
		this.categoryId = categoryId;
	}

	public List<Product> getProducts() {
		return products;
	}

	public void setProducts(List<Product> products) {
		this.products = products;
	}

	public List<Product> addItem(Product product) {
		if (products == null) {
			products = new ArrayList<Product>();
		}
		product.setCategory(this);
		products.add(product);
		return products;

	}

	public List<Product> removeItem(Product product) {
		products.remove(product);
		return products;
	}

	public void clearList() {
		products.clear();
	}
}