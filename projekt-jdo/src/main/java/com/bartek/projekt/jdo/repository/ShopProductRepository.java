
package com.bartek.projekt.jdo.repository;

import com.bartek.projekt.jdo.model.ShopProduct;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

public interface ShopProductRepository {

	public Mono<ShopProduct> save(ShopProduct shop);

	public Mono<ShopProduct> update(ShopProduct shop);

	public void delete(Long shopId);

	public Flux<ShopProduct> findAll();

}
