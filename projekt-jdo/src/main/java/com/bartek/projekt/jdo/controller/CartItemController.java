
package com.bartek.projekt.jdo.controller;

import com.bartek.projekt.jdo.model.CartItem;
import com.bartek.projekt.jdo.repository.CartItemRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@RestController
@CrossOrigin(origins = "*")
@RequestMapping(value = "/CartItem")
public class CartItemController {

	@Autowired
	private CartItemRepository repository;

	@PostMapping("/save")
	public Mono<CartItem> add(@RequestBody CartItem category) {

		return repository.save(category);
	}

	@PostMapping("/update")
	public Mono<CartItem> update(@RequestBody CartItem category) {
		return repository.update(category);
	}

	@GetMapping("/findAll")
	public Flux<CartItem> findAll() {
		return repository.findAll();
	}

	@GetMapping("/delete/{id}")
	public void delete(@PathVariable Long id) {
		repository.delete(id);
	}
}