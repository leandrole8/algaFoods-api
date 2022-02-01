package com.leandroreis.algafood.domain.repository;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.leandroreis.algafood.domain.model.Permissao;

@Repository
public interface PermissaoRepository {
	
	List<Permissao> listar();
	Permissao buscar(Long id);
	Permissao salvar(Permissao permissao);
	void remover(Permissao permissao);

}
