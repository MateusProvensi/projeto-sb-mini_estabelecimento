package com.proven.minimercado.repositorios;

import org.springframework.data.jpa.repository.JpaRepository;

import com.proven.minimercado.entidades.Marca;

public interface MarcaRepositorio extends JpaRepository<Marca, Long> {
}
