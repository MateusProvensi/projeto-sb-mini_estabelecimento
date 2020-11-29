package com.proven.minimercado.entidades;

import java.io.Serializable;

import com.proven.minimercado.entidades.PK.ItemVendaPK;

public class ItemVenda implements Serializable {

	private static final long serialVersionUID = 1L;

	private ItemVendaPK id;
	private Integer quantidade;
	private Double preco;

	public ItemVenda() {
	}

	public ItemVenda(Item item, Venda venda, Integer quantidade, Double preco) {
		id.setItem(item);
		id.setVenda(venda);
		this.quantidade = quantidade;
		this.preco = preco;
	}

	public Item getItem() {
		return id.getItem();
	}

	public void setItem(Item item) {
		id.setItem(item);
	}

	public Venda getVenda() {
		return id.getVenda();
	}

	public void setVenda(Venda venda) {
		id.setVenda(venda);
	}

	public Integer getQuantidade() {
		return quantidade;
	}

	public void setQuantidade(Integer quantidade) {
		this.quantidade = quantidade;
	}

	public Double getPreco() {
		return preco;
	}

	public void setPreco(Double preco) {
		this.preco = preco;
	}

	public Double getSubTotal() {
		return preco * quantidade;
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
		ItemVenda other = (ItemVenda) obj;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		return true;
	}

}
