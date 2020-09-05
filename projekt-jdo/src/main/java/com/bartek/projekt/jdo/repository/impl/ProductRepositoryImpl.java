
package com.bartek.projekt.jdo.repository.impl;

import java.util.List;

import javax.jdo.PersistenceManager;
import javax.jdo.Query;

import com.bartek.projekt.jdo.Config;
import com.bartek.projekt.jdo.model.Category;
import com.bartek.projekt.jdo.model.Product;
import com.bartek.projekt.jdo.repository.ProductRepository;
import org.springframework.stereotype.Repository;

import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@Repository
public class ProductRepositoryImpl implements ProductRepository {

	@Override
	public Mono<Product> save(Product product) {
		PersistenceManager pm = Config.getPersistenceManagerFactory().getPersistenceManager();
		Category category = pm.getObjectById(Category.class, Math.round(product.getCategoryId()));
		product.setCategory(category);
		category.addItem(product);
		return Mono.just(pm.makePersistent(product));
	}

	@Override
	public Mono<Product> update(Product product) {
		PersistenceManager pm = Config.getPersistenceManagerFactory().getPersistenceManager();
		Product oldProduct = pm.getObjectById(Product.class, product.getProductId());
		if (product.getName() != null)
			oldProduct.setName(product.getName());
		if (product.getDescription() != null)
			oldProduct.setDescription(product.getDescription());
		if (product.getPrice() != null)
			oldProduct.setPrice(product.getPrice());
		if (product.getCategoryId() != null) {
			Category category = pm.getObjectById(Category.class, Math.round(product.getCategoryId()));
			oldProduct.setCategory(category);
			oldProduct.setCategoryID(product.getCategoryId());
			Category categoryOld = pm.getObjectById(Category.class, Math.round(oldProduct.getCategoryId()));
			categoryOld.removeItem(oldProduct);
			category.addItem(oldProduct);
		}

		return Mono.just(pm.makePersistent(oldProduct));
	}

	@Override
	public void delete(Long productId) {
		PersistenceManager pm = Config.getPersistenceManagerFactory().getPersistenceManager();
		Product product = pm.getObjectById(Product.class, productId);
		pm.deletePersistent(product);
	}

	@Override
	public Flux<Product> findAll() {
		PersistenceManager pm = Config.getPersistenceManagerFactory().getPersistenceManager();
		Query query = pm.newQuery(Product.class);
		return Flux.fromIterable((List<Product>) query.execute());
	}

}
