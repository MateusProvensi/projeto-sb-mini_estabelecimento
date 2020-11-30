package com.proven.minimercado.servicos;

import java.util.List;
import java.util.Optional;

import javax.persistence.EntityNotFoundException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.stereotype.Service;

import com.proven.minimercado.entidades.Item;
import com.proven.minimercado.repositorios.ItemRepositorio;
import com.proven.minimercado.servicos.exceptions.BancoDadosException;
import com.proven.minimercado.servicos.exceptions.ResourceNaoAchadoException;

@Service
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

	public Item insert(Item obj) {
		return repositorio.save(obj);
	}

	public void delete(Long id) {
		try {
			repositorio.deleteById(id);
		} catch (EmptyResultDataAccessException e) {
			throw new ResourceNaoAchadoException(id);
		} catch (DataIntegrityViolationException e) {
			throw new BancoDadosException(e.getMessage());
		}
	}

	public Item update(Long id, Item obj) {
		try {
			Item entidade = repositorio.getOne(id);
			updateDados(entidade, obj);
			return repositorio.save(entidade);
		} catch (EntityNotFoundException e) {
			throw new ResourceNaoAchadoException(id);
		}
	}

	private void updateDados(Item entidade, Item obj) {
		entidade.setDescricaoItem(obj.getDescricaoItem());
		entidade.setCodigoBarras(obj.getCodigoBarras());
		entidade.setPrecoVenda(obj.getPrecoVenda());
		entidade.setQuantidade(obj.getQuantidade());
		entidade.setValidade(obj.getValidade());
		entidade.setCorredor(obj.getCorredor());
	}
}
