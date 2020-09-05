
package com.bartek.projekt.jdo.repository;

import com.bartek.projekt.jdo.model.ShoppingCart;

import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

public interface ShoppingCartRepository {

	public Mono<ShoppingCart> save(ShoppingCart shoppingCart);

	public Mono<ShoppingCart> update(ShoppingCart shoppingCart);

	public void delete(String cartId);

	public Flux<ShoppingCart> findAll();

}