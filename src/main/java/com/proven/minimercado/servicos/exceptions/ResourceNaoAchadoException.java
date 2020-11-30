package com.proven.minimercado.servicos.exceptions;

public class ResourceNaoAchadoException extends RuntimeException {

	private static final long serialVersionUID = 1L;

	public ResourceNaoAchadoException(Object id) {
		super("Resource não foi achado. Id " + id);
	}

}
