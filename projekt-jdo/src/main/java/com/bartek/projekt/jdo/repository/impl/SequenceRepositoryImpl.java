
package com.bartek.projekt.jdo.repository.impl;

import com.bartek.projekt.jdo.Config;
import com.bartek.projekt.jdo.model.Sequence;
import com.bartek.projekt.jdo.repository.SequenceRepository;
import org.springframework.stereotype.Repository;
import reactor.core.publisher.Flux;

import javax.jdo.PersistenceManager;
import javax.jdo.Query;
import java.util.List;

@Repository
public class SequenceRepositoryImpl implements SequenceRepository {

	@Override
	public Flux<Sequence> findAll() {
		PersistenceManager pm = Config.getPersistenceManagerFactory().getPersistenceManager();
		Query query = pm.newQuery(Sequence.class);
		return Flux.fromIterable((List<Sequence>) query.execute());
	}

}
