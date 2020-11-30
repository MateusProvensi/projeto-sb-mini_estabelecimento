package com.proven.minimercado.servicos;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;

import com.proven.minimercado.entidades.Fornecedor;
import com.proven.minimercado.repositorios.FornecedorRepositorio;

public class FornecedorServico {

	@Autowired
	private FornecedorRepositorio repositorio;

	public List<Fornecedor> acharTodos() {
		return repositorio.findAll();
	}

	public Fornecedor acharPeloId(Long id) {
		Optional<Fornecedor> obj = repositorio.findById(id);
		return obj.get();
	}

}
