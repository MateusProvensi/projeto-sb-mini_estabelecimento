package com.proven.minimercado.servicos;

import java.util.List;
import java.util.Optional;

import javax.persistence.EntityNotFoundException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.stereotype.Service;

import com.proven.minimercado.entidades.Venda;
import com.proven.minimercado.repositorios.VendaRepositorio;
import com.proven.minimercado.servicos.exceptions.BancoDadosException;
import com.proven.minimercado.servicos.exceptions.ResourceNaoAchadoException;

@Service
public class VendaServico {

	@Autowired
	private VendaRepositorio repositorio;

	public List<Venda> acharTodos() {
		return repositorio.findAll();
	}

	public Venda acharPeloId(Long id) {
		Optional<Venda> obj = repositorio.findById(id);
		return obj.orElseThrow(() -> new ResourceNaoAchadoException(id));
	}

	public Venda insert(Venda obj) {
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
	
	public Venda update(Long id, Venda obj) {
		try {
			Venda entidade = repositorio.getOne(id);
			updateDados(entidade, obj);
			return repositorio.save(entidade);
		} catch (EntityNotFoundException e) {
			throw new ResourceNaoAchadoException(id);
		}
	}

	private void updateDados(Venda entidade, Venda obj) {
		entidade.setPrecoTotal(obj.getPrecoTotal());
		entidade.setDataHoraVenda(obj.getDataHoraVenda());
		entidade.setCliente(obj.getCliente());
		entidade.setFuncionario(obj.getFuncionario());
	}
	
}
