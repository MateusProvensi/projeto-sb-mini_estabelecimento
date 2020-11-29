package com.proven.minimercado.entidades.PK;

import java.io.Serializable;

import com.proven.minimercado.entidades.Item;
import com.proven.minimercado.entidades.Venda;

public class ItemVendaPK implements Serializable {

	private static final long serialVersionUID = 1L;

	private Item item;
	private Venda venda;

	public Item getItem() {
		return item;
	}

	public void setItem(Item item) {
		this.item = item;
	}

	public Venda getVenda() {
		return venda;
	}

	public void setVenda(Venda venda) {
		this.venda = venda;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((item == null) ? 0 : item.hashCode());
		result = prime * result + ((venda == null) ? 0 : venda.hashCode());
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
		ItemVendaPK other = (ItemVendaPK) obj;
		if (item == null) {
			if (other.item != null)
				return false;
		} else if (!item.equals(other.item))
			return false;
		if (venda == null) {
			if (other.venda != null)
				return false;
		} else if (!venda.equals(other.venda))
			return false;
		return true;
	}

}
