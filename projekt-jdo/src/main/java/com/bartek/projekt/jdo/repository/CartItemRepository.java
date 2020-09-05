
package com.bartek.projekt.jdo.repository;

import com.bartek.projekt.jdo.model.CartItem;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

public interface CartItemRepository {

	public Mono<CartItem> save(CartItem cartItem);

	public Mono<CartItem> update(CartItem cartItem);

	public void delete(Long cartItemId);

	public Flux<CartItem> findAll();

}
