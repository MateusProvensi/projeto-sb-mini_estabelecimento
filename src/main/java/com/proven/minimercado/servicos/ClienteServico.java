package com.proven.minimercado.servicos;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;

import com.proven.minimercado.entidades.Cliente;
import com.proven.minimercado.repositorios.ClienteRepositorio;

public class ClienteServico {

	@Autowired // Injeção Automatica
	private ClienteRepositorio repositorio;

	public List<Cliente> acharTodos() {
		return repositorio.findAll();
	}

	public Cliente acharPeloId(Long id) {
		Optional<Cliente> obj = repositorio.findById(id);
		return obj.get();
	}

	public Cliente insert(Cliente obj) {
		return repositorio.save(obj);
	}

}
