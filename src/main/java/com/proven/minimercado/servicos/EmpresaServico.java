package com.proven.minimercado.servicos;

import java.util.List;
import java.util.Optional;

import javax.persistence.EntityNotFoundException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.dao.EmptyResultDataAccessException;

import com.proven.minimercado.entidades.Empresa;
import com.proven.minimercado.repositorios.EmpresaRepositorio;
import com.proven.minimercado.servicos.exceptions.BancoDadosException;
import com.proven.minimercado.servicos.exceptions.ResourceNaoAchadoException;

public class EmpresaServico {

	@Autowired
	private EmpresaRepositorio repositorio;

	public List<Empresa> acharTodas() {
		return repositorio.findAll();
	}

	public Empresa acharPeloId(Long id) {
		Optional<Empresa> obj = repositorio.findById(id);
		return obj.get();
	}

	public Empresa insert(Empresa obj) {
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

	public Empresa update(Long id, Empresa obj) {
		try {
			Empresa entidade = repositorio.getOne(id);
			updateDados(entidade, obj);
			return repositorio.save(entidade);
		} catch (EntityNotFoundException e) {
			throw new ResourceNaoAchadoException(id);
		}
	}

	private void updateDados(Empresa entidade, Empresa obj) {
		entidade.setNome(obj.getNome());
		entidade.setCnpj(obj.getCnpj());
		entidade.setTelefone(obj.getTelefone());
	}

}
