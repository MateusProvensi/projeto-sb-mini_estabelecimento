package com.proven.minimercado.servicos;

import java.util.List;
import java.util.Optional;

import javax.persistence.EntityNotFoundException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.stereotype.Service;

import com.proven.minimercado.entidades.Fornecedor;
import com.proven.minimercado.repositorios.FornecedorRepositorio;
import com.proven.minimercado.servicos.exceptions.BancoDadosException;
import com.proven.minimercado.servicos.exceptions.ResourceNaoAchadoException;

@Service
public class FornecedorServico {

	@Autowired
	private FornecedorRepositorio repositorio;

	public List<Fornecedor> acharTodos() {
		return repositorio.findAll();
	}

	public Fornecedor acharPeloId(Long id) {
		Optional<Fornecedor> obj = repositorio.findById(id);
		return obj.orElseThrow(() -> new ResourceNaoAchadoException(id));
	}

	public Fornecedor insert(Fornecedor obj) {
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

	public Fornecedor update(Long id, Fornecedor obj) {
		try {
			Fornecedor entidade = repositorio.getOne(id);
			updateDados(entidade, obj);
			return repositorio.save(entidade);
		} catch (EntityNotFoundException e) {
			throw new ResourceNaoAchadoException(id);
		}
	}

	private void updateDados(Fornecedor entidade, Fornecedor obj) {
		entidade.setDataUltimaVisita(obj.getDataUltimaVisita());
		entidade.setNome(obj.getNome());
		entidade.setSobrenome(obj.getSobrenome());
		entidade.setCpf(obj.getCpf());
		entidade.setRg(obj.getRg());
		entidade.setTelefone(obj.getTelefone());
	}

}
