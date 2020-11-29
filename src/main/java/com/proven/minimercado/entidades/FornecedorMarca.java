package com.proven.minimercado.entidades;

import java.io.Serializable;

public class FornecedorMarca implements Serializable {

	private static final long serialVersionUID = 1L;

	private Integer idFornecedorMarca;
	private Fornecedor fornecedor;
	private Marca marca;

	public FornecedorMarca() {
	}
	
	public FornecedorMarca(Integer idFornecedorMarca, Fornecedor fornecedor, Marca marca) {
		this.idFornecedorMarca = idFornecedorMarca;
		this.fornecedor = fornecedor;
		this.marca = marca;
	}

	public Integer getIdFornecedorMarca() {
		return idFornecedorMarca;
	}

	public void setIdFornecedorMarca(Integer idFornecedorMarca) {
		this.idFornecedorMarca = idFornecedorMarca;
	}

	public Fornecedor getFornecedor() {
		return fornecedor;
	}

	public void setFornecedor(Fornecedor fornecedor) {
		this.fornecedor = fornecedor;
	}

	public Marca getMarca() {
		return marca;
	}

	public void setMarca(Marca marca) {
		this.marca = marca;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((idFornecedorMarca == null) ? 0 : idFornecedorMarca.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		FornecedorMarca other = (FornecedorMarca) obj;
		if (idFornecedorMarca == null) {
			if (other.idFornecedorMarca != null)
				return false;
		} else if (!idFornecedorMarca.equals(other.idFornecedorMarca))
			return false;
		return true;
	}

}
