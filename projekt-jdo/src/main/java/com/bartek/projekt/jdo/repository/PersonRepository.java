
package com.bartek.projekt.jdo.repository;

import com.bartek.projekt.jdo.model.Person;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

public interface PersonRepository {

	public Mono<Person> save(Person person);

	public Mono<Person> update(Person person);

	public void delete(Long personId);

	public Flux<Person> findAll();

}
