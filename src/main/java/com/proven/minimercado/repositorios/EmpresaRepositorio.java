package com.proven.minimercado.repositorios;

import org.springframework.data.jpa.repository.JpaRepository;

import com.proven.minimercado.entidades.Empresa;

public interface EmpresaRepositorio extends JpaRepository<Empresa, Long> {
}
