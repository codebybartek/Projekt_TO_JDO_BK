
package com.bartek.projekt.jdo.controller;

import com.bartek.projekt.jdo.model.ShopProduct;
import com.bartek.projekt.jdo.repository.ShopProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@RestController
@CrossOrigin(origins = "*")
@RequestMapping(value = "/ShopProduct")
public class ShopProductController {

	@Autowired
	private ShopProductRepository repository;

	@PostMapping("/save")
	public Mono<ShopProduct> save(@RequestBody ShopProduct shopProduct) {

		return repository.save(shopProduct);
	}

	@PostMapping("/update")
	public Mono<ShopProduct> update(@RequestBody ShopProduct shopProduct) {
		return repository.update(shopProduct);
	}

	@GetMapping("/findAll")
	public Flux<ShopProduct> findAll() {
		return repository.findAll();
	}

	@GetMapping("/delete/{id}")
	public void delete(@PathVariable Long id) {
		repository.delete(id);
	}
}