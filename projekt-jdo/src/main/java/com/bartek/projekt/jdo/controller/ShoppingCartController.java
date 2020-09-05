
package com.bartek.projekt.jdo.controller;

import com.bartek.projekt.jdo.model.CartItem;
import com.bartek.projekt.jdo.model.ShoppingCart;
import com.bartek.projekt.jdo.repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import com.bartek.projekt.jdo.repository.ShoppingCartRepository;

import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@RestController
@CrossOrigin(origins = "*")
@RequestMapping(value = "/ShoppingCart")
public class ShoppingCartController {


	@Autowired
	private ShoppingCartRepository repository;


	@PostMapping("/save")
	public Mono<ShoppingCart> save(@RequestBody ShoppingCart shoppingCart) {
		return repository.save(shoppingCart);
	}

	@PostMapping("/update")
	public Mono<ShoppingCart> update(@RequestBody ShoppingCart shoppingCart) {
		return repository.update(shoppingCart);
	}

	@GetMapping("/findAll")
	public Flux<ShoppingCart> findAll() {
		return repository.findAll();
	}

	@GetMapping("/delete/{id}")
	public void delete(@PathVariable String id) {
		repository.delete(id);
	}
}