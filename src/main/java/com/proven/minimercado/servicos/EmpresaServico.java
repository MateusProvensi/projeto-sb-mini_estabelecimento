package com.proven.minimercado.servicos;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;

import com.proven.minimercado.entidades.Empresa;
import com.proven.minimercado.repositorios.EmpresaRepositorio;

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
	
}
