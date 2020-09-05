
package com.bartek.projekt.jdo.repository;

import com.bartek.projekt.jdo.model.Product;

import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

public interface ProductRepository {

	public Mono<Product> save(Product product);

	public Mono<Product> update(Product product);

	public void delete(Long productId);

	public Flux<Product> findAll();

}
