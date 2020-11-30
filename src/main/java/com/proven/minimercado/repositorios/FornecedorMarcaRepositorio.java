package com.proven.minimercado.repositorios;

import org.springframework.data.jpa.repository.JpaRepository;

import com.proven.minimercado.entidades.FornecedorMarca;
import com.proven.minimercado.entidades.PK.FornecedorMarcaPK;

public interface FornecedorMarcaRepositorio extends JpaRepository<FornecedorMarca, FornecedorMarcaPK> {
}
