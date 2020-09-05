
package com.bartek.projekt.jdo.controller;

import com.bartek.projekt.jdo.model.Sequence;
import com.bartek.projekt.jdo.repository.SequenceRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import reactor.core.publisher.Flux;

@RestController
@CrossOrigin(origins = "*")
@RequestMapping(value = "/Sequence")
public class MainController {

	@Autowired
	private SequenceRepository repository;

	@GetMapping("/findAll")
	public Flux<Sequence> findAll() {
		return repository.findAll();
	}


}