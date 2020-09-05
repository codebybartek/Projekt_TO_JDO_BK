package com.bartek.projekt.jdo.model;

import java.io.Serializable;

import javax.jdo.annotations.Column;
import javax.jdo.annotations.IdGeneratorStrategy;
import javax.jdo.annotations.PersistenceCapable;
import javax.jdo.annotations.Persistent;
import javax.jdo.annotations.PrimaryKey;

import com.fasterxml.jackson.annotation.JsonIgnore;

@PersistenceCapable(table = "cart_item")
public class CartItem implements Serializable {

	private static final long serialVersionUID = 7178402473309473944L;

	@PrimaryKey
	@Persistent(valueStrategy = IdGeneratorStrategy.INCREMENT)
	private Long cartItemId;

	@Persistent
	private Long productId;

	@Persistent
	private Integer quantity;

	@JsonIgnore
	@Column(name = "cartId")
	private ShoppingCart shoppingCart;


	@Persistent
	private Long shoppingCartId;

	public CartItem() {
		super();
	}

	public CartItem(Long productId, Integer quantity, Double price, Long cartId, Integer ITEMS_INTEGER_IDX) {
		super();
		this.productId = productId;
		this.quantity = quantity;
		this.shoppingCartId = cartId;
	}

	public Long getCartItemId() {
		return cartItemId;
	}

	public Long getShoppingCartId() {
		return shoppingCartId;
	}

	public void setCartItemId(Long cartItemId) {
		this.cartItemId = cartItemId;
	}

	public ShoppingCart getShoppingCart() {
		return shoppingCart;
	}

	public void setShoppingCart(ShoppingCart shoppingCart) {
		this.shoppingCart = shoppingCart;
	}

	public Long getProductId() {
		return productId;
	}

	public void setProductId(Long productId) {
		this.productId = productId;
	}

	public Integer getQuantity() {
		return quantity;
	}

	public void setQuantity(Integer quantity) {
		this.quantity = quantity;
	}


	public void setShoppingCartId(Long soppingCartId) {
		this.shoppingCartId = soppingCartId;
	}
}