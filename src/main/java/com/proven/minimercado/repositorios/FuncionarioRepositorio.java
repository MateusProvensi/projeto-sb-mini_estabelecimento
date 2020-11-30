package com.proven.minimercado.repositorios;

import org.springframework.data.jpa.repository.JpaRepository;

import com.proven.minimercado.entidades.Funcionario;

public interface FuncionarioRepositorio extends JpaRepository<Funcionario, Long> {
}
