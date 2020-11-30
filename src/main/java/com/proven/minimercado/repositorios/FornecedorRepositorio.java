package com.proven.minimercado.repositorios;

import org.springframework.data.jpa.repository.JpaRepository;

import com.proven.minimercado.entidades.Fornecedor;

public interface FornecedorRepositorio extends JpaRepository<Fornecedor, Long> {
}
