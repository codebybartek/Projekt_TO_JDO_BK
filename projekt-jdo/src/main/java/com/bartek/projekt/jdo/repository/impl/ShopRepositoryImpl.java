
package com.bartek.projekt.jdo.repository.impl;

import com.bartek.projekt.jdo.Config;
import com.bartek.projekt.jdo.model.Product;
import com.bartek.projekt.jdo.model.Shop;
import com.bartek.projekt.jdo.repository.ShopRepository;
import org.springframework.stereotype.Repository;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

import javax.jdo.PersistenceManager;
import javax.jdo.Query;
import java.util.List;

@Repository
public class ShopRepositoryImpl implements ShopRepository {

	@Override
	public Mono<Shop> save(Shop shop) {
		PersistenceManager pm = Config.getPersistenceManagerFactory().getPersistenceManager();
		return Mono.just(pm.makePersistent(shop));
	}


	@Override
	public Mono<Shop> update(Shop shop) {
		PersistenceManager pm = Config.getPersistenceManagerFactory().getPersistenceManager();
		Shop oldShop = pm.getObjectById(Shop.class, shop.getShopId());
		if (oldShop.getShopAddress() != null)
			oldShop.setShopAddress(shop.getShopAddress());
		if (oldShop.getShopName() != null)
			oldShop.setShopName(shop.getShopName());
		return Mono.just(pm.makePersistent(oldShop));
	}

	@Override
	public void delete(Long shopId) {
		PersistenceManager pm = Config.getPersistenceManagerFactory().getPersistenceManager();
		Shop shop = pm.getObjectById(Shop.class, shopId);
		pm.deletePersistent(shop);
	}

	@Override
	public Flux<Shop> findAll() {
		PersistenceManager pm = Config.getPersistenceManagerFactory().getPersistenceManager();
		Query query = pm.newQuery(Shop.class);
		return Flux.fromIterable((List<Shop>) query.execute());
	}

}
