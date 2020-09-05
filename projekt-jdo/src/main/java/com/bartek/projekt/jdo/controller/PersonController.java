
package com.bartek.projekt.jdo.controller;

import com.bartek.projekt.jdo.model.Person;
import com.bartek.projekt.jdo.repository.PersonRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@CrossOrigin(origins = "*")
@RestController
@RequestMapping(value = "/Person")
public class PersonController {


	@Autowired
	private PersonRepository repository;

	@PostMapping("/save")
	public Mono<Person> save(@RequestBody Person person) {
		return repository.save(person);
	}

	@PostMapping("/update")
	public Mono<Person> update(@RequestBody Person person) {
		return repository.update(person);
	}

	@GetMapping("/findAll")
	public Flux<Person> findAll() {
		return repository.findAll();
	}

	@GetMapping("/delete/{id}")
	public void delete(@PathVariable Long id) {
		repository.delete(id);
	}
}