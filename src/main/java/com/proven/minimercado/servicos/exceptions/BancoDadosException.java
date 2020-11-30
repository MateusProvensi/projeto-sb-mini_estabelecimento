package com.proven.minimercado.servicos.exceptions;

public class BancoDadosException extends RuntimeException {

	private static final long serialVersionUID = 1L;

	public BancoDadosException(String mensagem) {
		super(mensagem);
	}

}
