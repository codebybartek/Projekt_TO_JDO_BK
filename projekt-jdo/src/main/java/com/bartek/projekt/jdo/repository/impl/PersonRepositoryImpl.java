
package com.bartek.projekt.jdo.repository.impl;
import com.bartek.projekt.jdo.Config;
import com.bartek.projekt.jdo.model.CustommerAcount;
import com.bartek.projekt.jdo.model.Person;
import com.bartek.projekt.jdo.repository.PersonRepository;
import org.springframework.stereotype.Repository;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

import javax.jdo.PersistenceManager;
import javax.jdo.Query;
import java.util.List;

@Repository
public class PersonRepositoryImpl implements PersonRepository {

	@Override
	public Mono<Person> save(Person person) {
		PersistenceManager pm = Config.getPersistenceManagerFactory().getPersistenceManager();
		CustommerAcount account = new CustommerAcount();
		account.setDiscount((long) 10);
		account.setPerson(person);
		person.setAccount(account);
		return Mono.just(pm.makePersistent(person));
	}


	@Override
	public Mono<Person> update(Person person) {
		PersistenceManager pm = Config.getPersistenceManagerFactory().getPersistenceManager();
		Person oldPerson = pm.getObjectById(Person.class, person.getId());
		if (person.getName() != null)
			oldPerson.setName(person.getName());
		if (person.getAddress() != null)
			oldPerson.setAddress(person.getAddress());
		if (person.getPhone() != null)
			oldPerson.setPhone(person.getPhone());
		return Mono.just(pm.makePersistent(oldPerson));
	}

	@Override
	public void delete(Long personId) {
		PersistenceManager pm = Config.getPersistenceManagerFactory().getPersistenceManager();
		Person person = pm.getObjectById(Person.class, personId);
		pm.deletePersistent(person);
	}

	@Override
	public Flux<Person> findAll() {
		PersistenceManager pm = Config.getPersistenceManagerFactory().getPersistenceManager();
		Query query = pm.newQuery(Person.class);
		return Flux.fromIterable((List<Person>) query.execute());
	}

}
