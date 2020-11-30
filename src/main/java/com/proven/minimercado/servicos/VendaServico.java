package com.proven.minimercado.servicos;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;

import com.proven.minimercado.entidades.Venda;
import com.proven.minimercado.repositorios.VendaRepositorio;

public class VendaServico {

	@Autowired
	private VendaRepositorio repositorio;

	public List<Venda> acharTodos() {
		return repositorio.findAll();
	}

	public Venda acharPeloId(Long id) {
		Optional<Venda> obj = repositorio.findById(id);
		return obj.get();
	}

}
