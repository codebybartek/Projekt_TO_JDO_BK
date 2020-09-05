
package com.bartek.projekt.jdo.repository.impl;

import com.bartek.projekt.jdo.Config;
import com.bartek.projekt.jdo.model.Category;
import com.bartek.projekt.jdo.model.Product;
import com.bartek.projekt.jdo.model.Shop;
import com.bartek.projekt.jdo.model.ShopProduct;
import com.bartek.projekt.jdo.repository.ShopProductRepository;
import org.springframework.stereotype.Repository;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

import javax.jdo.PersistenceManager;
import javax.jdo.Query;
import java.util.List;

@Repository
public class ShopProductRepositoryImpl implements ShopProductRepository {

	@Override
	public Mono<ShopProduct> save(ShopProduct shopProduct) {
		PersistenceManager pm = Config.getPersistenceManagerFactory().getPersistenceManager();
		Shop shop = pm.getObjectById(Shop.class, Math.round(shopProduct.getShopId()));
		shopProduct.setShop(shop);

		Product product = pm.getObjectById(Product.class, Math.round(shopProduct.getProductId()));
		shopProduct.setProduct(product);
		return Mono.just(pm.makePersistent(shopProduct));
	}

	@Override
	public Mono<ShopProduct> update(ShopProduct shopProduct) {
		PersistenceManager pm = Config.getPersistenceManagerFactory().getPersistenceManager();
		ShopProduct oldShopProduct = pm.getObjectById(ShopProduct.class, shopProduct.getShopProductId());
		if (shopProduct.getProductId() != null) {
			Product product = pm.getObjectById(Product.class, Math.round(shopProduct.getProductId()));
			oldShopProduct.setProduct(product);
			oldShopProduct.setProductId(shopProduct.getProductId());
		}
		if (shopProduct.getShopId() != null) {
			Shop shop = pm.getObjectById(Shop.class, Math.round(shopProduct.getShopId()));
			oldShopProduct.setShop(shop);
			oldShopProduct.setShopId(shopProduct.getShopId());
		}
		return Mono.just(pm.makePersistent(oldShopProduct));
	}

	@Override
	public void delete(Long shopProductId) {
		PersistenceManager pm = Config.getPersistenceManagerFactory().getPersistenceManager();
		ShopProduct shopProduct = pm.getObjectById(ShopProduct.class, shopProductId);
		pm.deletePersistent(shopProduct);
	}

	@Override
	public Flux<ShopProduct> findAll() {
		PersistenceManager pm = Config.getPersistenceManagerFactory().getPersistenceManager();
		Query query = pm.newQuery(ShopProduct.class);
		return Flux.fromIterable((List<ShopProduct>) query.execute());
	}

}
