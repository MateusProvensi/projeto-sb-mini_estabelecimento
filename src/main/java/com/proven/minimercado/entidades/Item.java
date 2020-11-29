package com.proven.minimercado.entidades;

import java.io.Serializable;
import java.time.Instant;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "tb_item")
public class Item implements Serializable {

	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long idItem;

	private String descricaoItem;
	private String codigoBarras;
	private Double precoVenda;
	private Integer quantidade;
	private Instant validade;
	private String corredor;

	@ManyToOne
	@JoinColumn(name = "fk_id_fornecedor_marca")
	private FornecedorMarca fornecedorMarca;

	public Item() {
	}

	public Item(Long idItem, String descricaoItem, String codigoBarras, Double precoVenda, Integer quantidade,
			Instant validade, String corredor, FornecedorMarca fornecedorMarca) {
		this.idItem = idItem;
		this.descricaoItem = descricaoItem;
		this.codigoBarras = codigoBarras;
		this.precoVenda = precoVenda;
		this.quantidade = quantidade;
		this.validade = validade;
		this.corredor = corredor;
		this.fornecedorMarca = fornecedorMarca;
	}

	public Long getIdItem() {
		return idItem;
	}

	public void setIdItem(Long idItem) {
		this.idItem = idItem;
	}

	public String getDescricaoItem() {
		return descricaoItem;
	}

	public void setDescricaoItem(String descricaoItem) {
		this.descricaoItem = descricaoItem;
	}

	public String getCodigoBarras() {
		return codigoBarras;
	}

	public void setCodigoBarras(String codigoBarras) {
		this.codigoBarras = codigoBarras;
	}

	public Double getPrecoVenda() {
		return precoVenda;
	}

	public void setPrecoVenda(Double precoVenda) {
		this.precoVenda = precoVenda;
	}

	public Integer getQuantidade() {
		return quantidade;
	}

	public void setQuantidade(Integer quantidade) {
		this.quantidade = quantidade;
	}

	public Instant getValidade() {
		return validade;
	}

	public void setValidade(Instant validade) {
		this.validade = validade;
	}

	public String getCorredor() {
		return corredor;
	}

	public void setCorredor(String corredor) {
		this.corredor = corredor;
	}

	public FornecedorMarca getFornecedorMarca() {
		return fornecedorMarca;
	}

	public void setFornecedorMarca(FornecedorMarca fornecedorMarca) {
		this.fornecedorMarca = fornecedorMarca;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((idItem == null) ? 0 : idItem.hashCode());
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
		Item other = (Item) obj;
		if (idItem == null) {
			if (other.idItem != null)
				return false;
		} else if (!idItem.equals(other.idItem))
			return false;
		return true;
	}
}
