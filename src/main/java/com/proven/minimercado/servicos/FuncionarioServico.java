package com.proven.minimercado.servicos;

import java.util.List;
import java.util.Optional;

import javax.persistence.EntityNotFoundException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.stereotype.Service;

import com.proven.minimercado.entidades.Funcionario;
import com.proven.minimercado.repositorios.FuncionarioRepositorio;
import com.proven.minimercado.servicos.exceptions.BancoDadosException;
import com.proven.minimercado.servicos.exceptions.ResourceNaoAchadoException;

@Service
public class FuncionarioServico {

	@Autowired
	private FuncionarioRepositorio repositorio;

	public List<Funcionario> acharTodos() {
		return repositorio.findAll();
	}

	public Funcionario acharPeloId(Long id) {
		Optional<Funcionario> obj = repositorio.findById(id);
		return obj.orElseThrow(() -> new ResourceNaoAchadoException(id));
	}

	public Funcionario insert(Funcionario obj) {
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

	public Funcionario update(Long id, Funcionario obj) {
		try {
			Funcionario entidade = repositorio.getOne(id);
			updateDados(entidade, obj);
			return repositorio.save(entidade);
		} catch (EntityNotFoundException e) {
			throw new ResourceNaoAchadoException(id);
		}
	}

	private void updateDados(Funcionario entidade, Funcionario obj) {
		entidade.setNome(obj.getNome());
		entidade.setSobrenome(obj.getSobrenome());
		entidade.setCpf(obj.getCpf());
		entidade.setRg(obj.getRg());
		entidade.setTelefone(obj.getTelefone());
		entidade.setNumeroCaixa(obj.getNumeroCaixa());
	}
}
