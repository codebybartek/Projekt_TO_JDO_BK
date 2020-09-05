
package com.bartek.projekt.jdo.controller;

import com.bartek.projekt.jdo.model.Product;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import com.bartek.projekt.jdo.repository.ProductRepository;

import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@CrossOrigin(origins = "*")
@RestController
@RequestMapping(value = "/Product")
public class ProductController {


	@Autowired
	private ProductRepository repository;

	@PostMapping("/save")
	public Mono<Product> save(@RequestBody Product product) {
		return repository.save(product);
	}

	@PostMapping("/update")
	public Mono<Product> update(@RequestBody Product product) {
		return repository.update(product);
	}

	@GetMapping("/findAll")
	public Flux<Product> findAll() {
		return repository.findAll();
	}

	@GetMapping("/delete/{id}")
	public void delete(@PathVariable Long id) {
		repository.delete(id);
	}
}