package com.proven.minimercado.servicos;

import java.util.List;
import java.util.Optional;

import javax.persistence.EntityNotFoundException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.stereotype.Service;

import com.proven.minimercado.entidades.Cliente;
import com.proven.minimercado.repositorios.ClienteRepositorio;
import com.proven.minimercado.servicos.exceptions.BancoDadosException;
import com.proven.minimercado.servicos.exceptions.ResourceNaoAchadoException;

@Service
public class ClienteServico {

	@Autowired // Injeção Automatica
	private ClienteRepositorio repositorio;

	public List<Cliente> acharTodos() {
		return repositorio.findAll();
	}

	public Cliente acharPeloId(Long id) {
		Optional<Cliente> obj = repositorio.findById(id);
		return obj.orElseThrow(() -> new ResourceNaoAchadoException(id)); // Ele tenta dar um get caso 
		// nao seja possivel ele lanca uma excecao parra dentro da expressao 
	}

	public Cliente insert(Cliente obj) {
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

	public Cliente update(Long id, Cliente obj) {
		try {
			Cliente entidade = repositorio.getOne(id);
			updateDados(entidade, obj);
			return repositorio.save(entidade);
		} catch (EntityNotFoundException e) {
			throw new ResourceNaoAchadoException(id);
		}
	}
	
	private void updateDados(Cliente entidade, Cliente obj) {
		entidade.setNome(obj.getNome());
		entidade.setSobrenome(obj.getSobrenome());
		entidade.setCpf(obj.getCpf());
		entidade.setRg(obj.getRg());
		entidade.setTelefone(obj.getTelefone());
	}

}
