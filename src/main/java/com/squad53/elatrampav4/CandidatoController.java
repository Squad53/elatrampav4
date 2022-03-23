package com.squad53.elatrampav4;

import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;



@RestController
@RequestMapping({"/candidatos"})
public class CandidatoController {
	
	private CandidatoRepository repository;
	
	CandidatoController(CandidatoRepository candidatoRepository) {
		this.repository = candidatoRepository;
	}
	
	@GetMapping
	public List findAll() {
		return repository.findAll();
	}
	
	@GetMapping(path = {"/{id}"})
	public ResponseEntity<Candidato> findById(@PathVariable long id){
		return repository.findById(id)
				.map(record -> ResponseEntity.ok().body(record))
				.orElse(ResponseEntity.notFound().build());
	}
	
	@PostMapping 
	public Candidato create(@RequestBody Candidato candidato) {
		return repository.save(candidato);
	}
	
	@PutMapping(value="/{id}")
	public ResponseEntity<Candidato> update(@PathVariable("id") long id,
			@RequestBody Candidato candidato){
		return repository.findById(id)
				.map(record -> {
					record.setNome(candidato.getNome());
					record.setCpf(candidato.getCpf());
					record.setEmail(candidato.getEmail());
					record.setTelefone(candidato.getTelefone());
					Candidato updated = repository.save(record);
					return ResponseEntity.ok().body(updated);
				}).orElse(ResponseEntity.notFound().build());
	}
	
	@DeleteMapping(path={"/{id}"})
	public ResponseEntity<?> delete(@PathVariable("id") long id){
	return repository.findById(id)
			.map(record ->{
				repository.deleteById(id);
				return ResponseEntity.ok().build();
			}).orElse(ResponseEntity.notFound().build());
}
	

}
