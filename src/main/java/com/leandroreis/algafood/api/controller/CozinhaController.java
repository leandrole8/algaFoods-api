package com.leandroreis.algafood.api.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.leandroreis.algafood.domain.model.Cozinha;
import com.leandroreis.algafood.domain.repository.CozinhaRepository;

@RestController
@RequestMapping(value = "/cozinhas", produces = MediaType.APPLICATION_JSON_VALUE)//a resposta vem em formato json
public class CozinhaController {
	
	@Autowired
	private CozinhaRepository cozinhaRepository;
	
	@GetMapping()
	public List<Cozinha> listar(){
		return cozinhaRepository.listar();
	}
	
	@GetMapping("/{id}")
	public ResponseEntity<Cozinha> buscar(@PathVariable Long id) {
		Cozinha cozinha = cozinhaRepository.buscar(id);
		
		if(cozinha != null) {
			return ResponseEntity.ok(cozinha);
		}
		return ResponseEntity.notFound().build();
	}
	
	@ResponseStatus(HttpStatus.CREATED)
	@PostMapping
	public Cozinha adicionar(@RequestBody Cozinha cozinha) {
		return cozinhaRepository.salvar(cozinha);
	}

}
