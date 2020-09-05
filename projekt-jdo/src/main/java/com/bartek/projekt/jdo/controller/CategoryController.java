
package com.bartek.projekt.jdo.controller;

import com.bartek.projekt.jdo.model.Category;
import com.bartek.projekt.jdo.repository.CategoryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@RestController
@CrossOrigin(origins = "*")
@RequestMapping(value = "/Category")
public class CategoryController {

	@Autowired
	private CategoryRepository repository;

	@PostMapping("/save")
	public Mono<Category> save(@RequestBody Category category) {

		return repository.save(category);
	}

	@PostMapping("/update")
	public Mono<Category> update(@RequestBody Category category) {
		return repository.update(category);
	}

	@GetMapping("/findAll")
	public Flux<Category> findAll() {
		return repository.findAll();
	}

	@GetMapping("/delete/{id}")
	public void delete(@PathVariable Long id) {
		repository.delete(id);
	}
}