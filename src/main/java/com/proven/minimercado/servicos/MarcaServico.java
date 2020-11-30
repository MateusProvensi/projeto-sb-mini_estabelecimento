package com.proven.minimercado.servicos;

import java.util.List;
import java.util.Optional;

import javax.persistence.EntityNotFoundException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.stereotype.Service;

import com.proven.minimercado.entidades.Marca;
import com.proven.minimercado.repositorios.MarcaRepositorio;
import com.proven.minimercado.servicos.exceptions.BancoDadosException;
import com.proven.minimercado.servicos.exceptions.ResourceNaoAchadoException;

@Service
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

	public Marca insert(Marca obj) {
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

	public Marca update(Long id, Marca obj) {
		try {
			Marca entidade = repositorio.getOne(id);
			updateDados(entidade, obj);
			return repositorio.save(entidade);
		} catch (EntityNotFoundException e) {
			throw new ResourceNaoAchadoException(id);
		}
	}

	private void updateDados(Marca entidade, Marca obj) {
		entidade.setNome(obj.getNome());
		entidade.setCnpj(obj.getCnpj());
		entidade.setEmpresa(obj.getEmpresa());
	}

}
