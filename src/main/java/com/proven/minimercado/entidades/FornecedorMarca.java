package com.proven.minimercado.entidades;

import java.io.Serializable;

import com.proven.minimercado.entidades.PK.FornecedorMarcaPK;

public class FornecedorMarca implements Serializable {

	private static final long serialVersionUID = 1L;

	private FornecedorMarcaPK id;

	public FornecedorMarca() {
	}

	public FornecedorMarca(Fornecedor fornecedor, Marca marca) {
		id.setFornecedor(fornecedor);
		id.setMarca(marca);
	}

	public Fornecedor getFornecedor() {
		return id.getFornecedor();
	}

	public void setFornecedor(Fornecedor fornecedor) {
		id.setFornecedor(fornecedor);
	}

	public Marca getMarca() {
		return id.getMarca();
	}

	public void setMarca(Marca marca) {
		id.setMarca(marca);
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((id == null) ? 0 : id.hashCode());
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
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		return true;
	}

}
