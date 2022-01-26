package com.leandroreis.algafood.api.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.leandroreis.algafood.domain.model.Estado;
import com.leandroreis.algafood.domain.repository.EstadoRepository;

@RestController
@RequestMapping("/estados")
public class EstadoController {

	@Autowired
	private EstadoRepository estadoRepository;
	
	@GetMapping
	public List<Estado> listar(){
		return estadoRepository.listar();
	}
	
	@GetMapping("/{id}")
	public ResponseEntity<Estado> buscar(@PathVariable Long id) {
		Estado estado = estadoRepository.buscar(id);
		
		if(estado != null) {
			return ResponseEntity.ok(estado);
		}
		return ResponseEntity.notFound().build();
	}
	
	@ResponseStatus(HttpStatus.CREATED)
	@PostMapping
	public Estado adicionar(Estado estado) {
		return estadoRepository.salvar(estado);
	}
}
