package com.bartek.projekt.jdo.repository.impl;

import com.bartek.projekt.jdo.Config;
import com.bartek.projekt.jdo.model.CartItem;
import com.bartek.projekt.jdo.model.Category;
import com.bartek.projekt.jdo.model.ShoppingCart;
import com.bartek.projekt.jdo.repository.CartItemRepository;
import com.bartek.projekt.jdo.repository.CartItemRepository;
import org.springframework.stereotype.Repository;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

import javax.jdo.PersistenceManager;
import javax.jdo.Query;
import java.util.List;

@Repository
public class CartItemRepositoryImpl implements CartItemRepository {

	@Override
	public Mono<CartItem> save(CartItem cartItem) {
		PersistenceManager pm = Config.getPersistenceManagerFactory().getPersistenceManager();
		ShoppingCart shoppingCart = pm.getObjectById(ShoppingCart.class, Math.round(cartItem.getShoppingCartId()));
		cartItem.setShoppingCart(shoppingCart);
		shoppingCart.addItem(cartItem);
		return Mono.just(pm.makePersistent(cartItem));
	}

	@Override
	public Mono<CartItem> update(CartItem cartItem) {
		PersistenceManager pm = Config.getPersistenceManagerFactory().getPersistenceManager();
		CartItem oldCartItem = pm.getObjectById(CartItem.class, cartItem.getCartItemId());
		if (oldCartItem.getQuantity()!= null)
			oldCartItem.setQuantity(cartItem.getQuantity());
		if (cartItem.getProductId() != null)
			oldCartItem.setProductId(cartItem.getProductId());

		if (cartItem.getShoppingCartId() != null) {
			ShoppingCart shoppingCart = pm.getObjectById(ShoppingCart.class, Math.round(cartItem.getShoppingCartId()));
			ShoppingCart oldShoppingCart = pm.getObjectById(ShoppingCart.class, Math.round(oldCartItem.getShoppingCartId()));
			oldCartItem.setShoppingCart(shoppingCart);
			oldCartItem.setShoppingCartId(cartItem.getShoppingCartId());
			oldShoppingCart.removeItem(oldCartItem);
			shoppingCart.addItem(oldCartItem);
		}
		return Mono.just(pm.makePersistent(oldCartItem));
	}

	@Override
	public void delete(Long cartItemId) {
		PersistenceManager pm = Config.getPersistenceManagerFactory().getPersistenceManager();
		CartItem cartItem = pm.getObjectById(CartItem.class, cartItemId);
		pm.deletePersistent(cartItem);
	}

	@Override
	public Flux<CartItem> findAll() {
		PersistenceManager pm = Config.getPersistenceManagerFactory().getPersistenceManager();
		Query query = pm.newQuery(CartItem.class);
		return Flux.fromIterable((List<CartItem>) query.execute());
	}

}
