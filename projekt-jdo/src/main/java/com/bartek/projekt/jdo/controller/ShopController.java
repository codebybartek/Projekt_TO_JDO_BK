
package com.bartek.projekt.jdo.controller;

import com.bartek.projekt.jdo.model.Shop;
import com.bartek.projekt.jdo.repository.ShopRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@RestController
@CrossOrigin(origins = "*")
@RequestMapping(value = "/Shop")
public class ShopController {

	@Autowired
	private ShopRepository repository;

	@PostMapping("/save")
	public Mono<Shop> save(@RequestBody Shop shop) {

		return repository.save(shop);
	}

	@PostMapping("/update")
	public Mono<Shop> update(@RequestBody Shop shop) {
		return repository.update(shop);
	}

	@GetMapping("/findAll")
	public Flux<Shop> findAll() {
		return repository.findAll();
	}

	@GetMapping("/delete/{id}")
	public void delete(@PathVariable Long id) {
		repository.delete(id);
	}
}