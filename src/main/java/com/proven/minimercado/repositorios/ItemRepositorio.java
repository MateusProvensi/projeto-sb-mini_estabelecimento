package com.proven.minimercado.repositorios;

import org.springframework.data.jpa.repository.JpaRepository;

import com.proven.minimercado.entidades.Item;

public interface ItemRepositorio extends JpaRepository<Item, Long> {
}
