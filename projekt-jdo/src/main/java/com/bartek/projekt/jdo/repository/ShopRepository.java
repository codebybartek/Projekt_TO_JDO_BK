
package com.bartek.projekt.jdo.repository;

import com.bartek.projekt.jdo.model.Shop;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

public interface ShopRepository {

	public Mono<Shop> save(Shop shop);

	public Mono<Shop> update(Shop shop);

	public void delete(Long shopId);

	public Flux<Shop> findAll();

}
