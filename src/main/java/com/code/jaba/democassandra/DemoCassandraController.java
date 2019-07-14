package com.code.jaba.democassandra;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("cassandra")
public class DemoCassandraController {

	
	@Autowired
	private CassandraRepository cassandraRepository;
	
	@PostMapping
	public ResponseEntity<Model> saveModel(@RequestBody Model model) {
		Model saveData = cassandraRepository.save(model);
		return new ResponseEntity<>(saveData, HttpStatus.OK);
	}
	
	@GetMapping
	public ResponseEntity<Model> fetchRecordFromModel(@PathVariable("id") String id, @PathVariable("name") String name) {
		Optional<Model> fetchData = cassandraRepository.findByIdAndName(id, name);
		
		if(!fetchData.isPresent()) {
			
		}
		
		return new ResponseEntity<>(fetchData.get(), HttpStatus.OK);
	}
}
