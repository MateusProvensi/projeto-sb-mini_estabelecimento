package com.proven.minimercado.entidades;

import java.io.Serializable;
import java.time.Instant;
import java.util.HashSet;
import java.util.Set;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name = "tb_venda")
public class Venda implements Serializable {

	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long idVenda;

	private Double precoTotal;
	private Instant dataHoraVenda;

	@ManyToOne // Cria associacao de muitos para um
	@JoinColumn(name = "fk_id_cliente") // Referencia ele como um chave estrangeira
	private Cliente cliente;

	@ManyToOne
	@JoinColumn(name = "fk_id_funcionario")
	private Funcionario funcionario;

	@OneToMany(mappedBy = "id.venda")
	private Set<ItemVenda> itens = new HashSet<>();

	public Venda() {
	}

	public Venda(Long idVenda, Double precoTotal, Instant dataHoraVenda, Cliente cliente, Funcionario funcionario) {
		this.idVenda = idVenda;
		this.precoTotal = precoTotal;
		this.dataHoraVenda = dataHoraVenda;
		this.cliente = cliente;
		this.funcionario = funcionario;
	}

	public Long getIdVenda() {
		return idVenda;
	}

	public void setIdVenda(Long idVenda) {
		this.idVenda = idVenda;
	}

	public Double getPrecoTotal() {
		return precoTotal;
	}

	public void setPrecoTotal(Double precoTotal) {
		this.precoTotal = precoTotal;
	}

	public Instant getDataHoraVenda() {
		return dataHoraVenda;
	}

	public void setDataHoraVenda(Instant dataHoraVenda) {
		this.dataHoraVenda = dataHoraVenda;
	}

	public Cliente getCliente() {
		return cliente;
	}

	public void setCliente(Cliente cliente) {
		this.cliente = cliente;
	}

	public Funcionario getFuncionario() {
		return funcionario;
	}

	public void setFuncionario(Funcionario funcionario) {
		this.funcionario = funcionario;
	}

	public Set<ItemVenda> getItens() {
		return itens;
	}

	public Double getTotal() {
		Double soma = 0.0;
		for (ItemVenda itemVenda : itens) {
			soma += itemVenda.getSubTotal();
		}
		return soma;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((idVenda == null) ? 0 : idVenda.hashCode());
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
		Venda other = (Venda) obj;
		if (idVenda == null) {
			if (other.idVenda != null)
				return false;
		} else if (!idVenda.equals(other.idVenda))
			return false;
		return true;
	}

}
