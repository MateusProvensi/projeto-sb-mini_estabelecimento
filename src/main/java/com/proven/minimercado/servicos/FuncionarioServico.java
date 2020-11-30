package com.proven.minimercado.servicos;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;

import com.proven.minimercado.entidades.Funcionario;
import com.proven.minimercado.repositorios.FuncionarioRepositorio;

public class FuncionarioServico {

	@Autowired
	private FuncionarioRepositorio repositorio;

	public List<Funcionario> acharTodos() {
		return repositorio.findAll();
	}

	public Funcionario acharPeloId(Long id) {
		Optional<Funcionario> obj = repositorio.findById(id);
		return obj.get();
	}

}
