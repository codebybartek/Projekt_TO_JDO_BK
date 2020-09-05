
package com.bartek.projekt.jdo.model;

import javax.jdo.annotations.*;
import java.io.Serializable;

@PersistenceCapable(table = "shop_product")
public class ShopProduct implements Serializable {

	private static final long serialVersionUID = -3898880301582195848L;

	@PrimaryKey
	@Persistent(valueStrategy = IdGeneratorStrategy.INCREMENT)
	private String shopProductId;

	@Persistent
	@Column(name = "productId")
	private Product product;

	@Persistent
	@Column(name = "shopId")
	private Shop shop;

	@Persistent
	private Long shopId;

	@Persistent
	private Long productId;

	public ShopProduct() {
		super();
	}

	public String getShopProductId() {
		return shopProductId;
	}

	public void setShopProductId(String shopProductId) {
		this.shopProductId = shopProductId;
	}

	public Product getProduct() {
		return product;
	}

	public void setProduct(Product product) {
		this.product = product;
	}

	public Shop getShop() {
		return shop;
	}

	public void setShop(Shop shop) {
		this.shop = shop;
	}

	public void setShopId(Long shopId) {
		this.shopId = shopId;
	}

	public Long getShopId() {
		return shopId;
	}

	public Long getProductId() {
		return productId;
	}

	public void setProductId(Long productId) {
		this.productId = productId;
	}

}