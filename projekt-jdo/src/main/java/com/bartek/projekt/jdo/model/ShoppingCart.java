
package com.bartek.projekt.jdo.model;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.jdo.annotations.*;


@PersistenceCapable(table = "shopping_cart")
public class ShoppingCart implements Serializable {

	private static final long serialVersionUID = -3898880301582195848L;

	@PrimaryKey
	@Persistent(valueStrategy = IdGeneratorStrategy.INCREMENT)
	private String cartId;


	@Persistent
	private Person person;

	@Persistent
	private Long personId;

	@Persistent(mappedBy = "shoppingCart")
	private List<CartItem> items;

	public ShoppingCart() {
		super();
	}

	public String getCartId() {
		return cartId;
	}

	public void setCartId(String cartId) {
		this.cartId = cartId;
	}

	public Long getPersonId() {
		return personId;
	}

	public Person getPerson() {
		return person;
	}

	public void setPersonId(Long personId) {
		this.personId = personId;
	}

	public void setPerson(Person person) {
		this.person = person;
	}

	public List<CartItem> getItems() {
		return items;
	}

	public void setItems(List<CartItem> items) {
		this.items = items;
	}

	public List<CartItem> addItem(CartItem item) {
		if (items == null) {
			items = new ArrayList<CartItem>();
		}
		item.setShoppingCart(this);
		items.add(item);
		return items;
	}

	public List<CartItem> removeItem(CartItem item) {
		items.remove(item);
		return items;
	}
}