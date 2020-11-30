package com.proven.minimercado.servicos;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;

import com.proven.minimercado.entidades.Marca;
import com.proven.minimercado.repositorios.MarcaRepositorio;

public class MarcaServico {

	@Autowired
	private MarcaRepositorio repositorio;

	public List<Marca> acharTodos() {
		return repositorio.findAll();
	}

	public Marca acharPeloId(Long id) {
		Optional<Marca> obj = repositorio.findById(id);
		return obj.get();
	}

}
