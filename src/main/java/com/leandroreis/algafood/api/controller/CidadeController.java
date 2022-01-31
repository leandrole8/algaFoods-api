package com.leandroreis.algafood.api.controller;

import java.beans.Beans;
import java.util.List;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.leandroreis.algafood.domain.exception.EntidadeEmUsoException;
import com.leandroreis.algafood.domain.exception.EntidadeNaoEncontradaException;
import com.leandroreis.algafood.domain.model.Cidade;
import com.leandroreis.algafood.domain.repository.CidadeRepository;
import com.leandroreis.algafood.domain.service.CidadeService;
import com.leandroreis.algafood.domain.service.CozinhaService;

@RestController
@RequestMapping("/cidades")
public class CidadeController {

	@Autowired
	private CidadeService cidadeService;
	
	@Autowired
	private CidadeRepository cidadeRepository;
	
	@GetMapping
	public List<Cidade> listar(){
		return cidadeRepository.listar();
	}
	
	@GetMapping("/{id}")
	public ResponseEntity<Cidade> buscar(@PathVariable Long id){
		Cidade cidade = cidadeRepository.buscar(id);
		
		if(cidade != null) {
			return ResponseEntity.ok(cidade);
		}
		return ResponseEntity.notFound().build();
	}
	
	@ResponseStatus(HttpStatus.CREATED)
	@PostMapping
	public Cidade adicionar(@RequestBody Cidade cidade){
		return cidadeService.salvar(cidade);
	}
	
	@PutMapping("/{id}")
	public ResponseEntity<Cidade> atualizar(@PathVariable Long id, @RequestBody Cidade cidade){
		Cidade cidadeAtual = cidadeRepository.buscar(id);
		
		if(cidadeAtual != null) {
			BeanUtils.copyProperties(cidade, cidadeAtual, "id");
			cidadeAtual = cidadeService.salvar(cidadeAtual);
			return ResponseEntity.ok(cidadeAtual);
		}
		return ResponseEntity.notFound().build();
	}
	
	@DeleteMapping("/{id}")
	public ResponseEntity<?> excluir(@PathVariable Long id){
		try {
			cidadeService.excluir(id);
			return ResponseEntity.noContent().build();
			
		} catch (EntidadeNaoEncontradaException e) {
			return ResponseEntity.notFound().build();
			
		} catch (EntidadeEmUsoException e) {
			return ResponseEntity.status(HttpStatus.CONFLICT)
					.body(e.getMessage());
		}
	}
}