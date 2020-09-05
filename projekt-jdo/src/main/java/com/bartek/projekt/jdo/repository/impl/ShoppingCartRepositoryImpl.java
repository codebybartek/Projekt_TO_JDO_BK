
package com.bartek.projekt.jdo.repository.impl;

import java.util.List;

import javax.jdo.PersistenceManager;
import javax.jdo.PersistenceManagerFactory;
import javax.jdo.Query;

import com.bartek.projekt.jdo.Config;
import com.bartek.projekt.jdo.model.*;
import com.bartek.projekt.jdo.repository.ShoppingCartRepository;
import org.springframework.stereotype.Repository;

import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@Repository
public class ShoppingCartRepositoryImpl implements ShoppingCartRepository {

	private final PersistenceManagerFactory pmf = Config.getPersistenceManagerFactory();

	@Override
	public Mono<ShoppingCart> save(ShoppingCart shoppingCart) {
		PersistenceManager pm = Config.getPersistenceManagerFactory().getPersistenceManager();
		Person person = pm.getObjectById(Person.class, Math.round(shoppingCart.getPersonId()));
		shoppingCart.setPerson(person);
		return Mono.just(pm.makePersistent(shoppingCart));
	}

	@Override
	public Mono<ShoppingCart> update(ShoppingCart shoppingCart) {
		return Mono.just(pmf.getPersistenceManager().makePersistent(shoppingCart));
	}

	@Override
	public void delete(String cartId) {
		PersistenceManager pm = pmf.getPersistenceManager();
		ShoppingCart shoppingCart = (ShoppingCart) pm.getObjectById(ShoppingCart.class, cartId);
		pm.deletePersistent(shoppingCart);
	}

	@Override
	public Flux<ShoppingCart> findAll() {
		PersistenceManager pm = Config.getPersistenceManagerFactory().getPersistenceManager();
		Query query = pm.newQuery(ShoppingCart.class);
		return Flux.fromIterable((List<ShoppingCart>) query.execute());
	}

}