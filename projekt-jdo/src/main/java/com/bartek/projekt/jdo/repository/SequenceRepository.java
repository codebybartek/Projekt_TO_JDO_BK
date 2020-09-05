package com.bartek.projekt.jdo.repository;

import com.bartek.projekt.jdo.model.Sequence;
import reactor.core.publisher.Flux;

public interface SequenceRepository {

	public Flux<Sequence> findAll();

}
