package com.proven.minimercado.servicos;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;

import com.proven.minimercado.entidades.Item;
import com.proven.minimercado.repositorios.ItemRepositorio;

public class ItemServico {

	@Autowired
	private ItemRepositorio repositorio;

	public List<Item> acharTodos() {
		return repositorio.findAll();
	}

	public Item acharPeloId(Long id) {
		Optional<Item> obj = repositorio.findById(id);
		return obj.get();
	}

}
