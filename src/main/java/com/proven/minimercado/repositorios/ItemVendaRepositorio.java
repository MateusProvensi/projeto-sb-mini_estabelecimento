package com.proven.minimercado.repositorios;

import org.springframework.data.jpa.repository.JpaRepository;

import com.proven.minimercado.entidades.ItemVenda;
import com.proven.minimercado.entidades.PK.ItemVendaPK;

public interface ItemVendaRepositorio extends JpaRepository<ItemVenda, ItemVendaPK> {
}
