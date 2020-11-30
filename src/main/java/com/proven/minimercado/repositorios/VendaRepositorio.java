package com.proven.minimercado.repositorios;

import org.springframework.data.jpa.repository.JpaRepository;

import com.proven.minimercado.entidades.Venda;

public interface VendaRepositorio extends JpaRepository<Venda, Long> {
}
