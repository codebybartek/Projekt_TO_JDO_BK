
package com.bartek.projekt.jdo.repository;

import com.bartek.projekt.jdo.model.Category;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

public interface CategoryRepository {

	public Mono<Category> save(Category category);

	public Mono<Category> update(Category category);

	public void delete(Long categoryId);

	public Flux<Category> findAll();

}
