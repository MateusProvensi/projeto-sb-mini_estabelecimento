package com.proven.minimercado.resources;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.proven.minimercado.servicos.MarcaServico;

@RestController
@RequestMapping(value = "/marcas")
public class MarcaResource {

	@Autowired
	private MarcaServico servico;
	
	
}
