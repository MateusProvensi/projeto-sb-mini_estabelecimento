package com.proven.minimercado.repositorios;

import org.springframework.data.jpa.repository.JpaRepository;

import com.proven.minimercado.entidades.Cliente;

public interface ClienteRepositorio extends JpaRepository<Cliente, Long> {
}
