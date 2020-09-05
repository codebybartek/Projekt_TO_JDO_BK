
package com.bartek.projekt.jdo.repository.impl;

import com.bartek.projekt.jdo.Config;
import com.bartek.projekt.jdo.model.Category;
import com.bartek.projekt.jdo.repository.CategoryRepository;
import org.springframework.stereotype.Repository;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

import javax.jdo.PersistenceManager;
import javax.jdo.Query;
import java.util.List;

@Repository
public class CategoryRepositoryImpl implements CategoryRepository {

	@Override
	public Mono<Category> save(Category category) {
		PersistenceManager pm = Config.getPersistenceManagerFactory().getPersistenceManager();
		return Mono.just(pm.makePersistent(category));
	}

	@Override
	public Mono<Category> update(Category category) {
		PersistenceManager pm = Config.getPersistenceManagerFactory().getPersistenceManager();
		Category oldCategory = pm.getObjectById(Category.class, category.getCategoryId());
		if (category.getCategoryName() != null)
			oldCategory.setCategoryName(category.getCategoryName());

		return Mono.just(pm.makePersistent(oldCategory));
	}

	@Override
	public void delete(Long categoryId) {
		PersistenceManager pm = Config.getPersistenceManagerFactory().getPersistenceManager();
		Category category = pm.getObjectById(Category.class, categoryId);
		category.clearList();
		pm.deletePersistent(category);
	}

	@Override
	public Flux<Category> findAll() {
		PersistenceManager pm = Config.getPersistenceManagerFactory().getPersistenceManager();
		Query query = pm.newQuery(Category.class);
		return Flux.fromIterable((List<Category>) query.execute());
	}

}
