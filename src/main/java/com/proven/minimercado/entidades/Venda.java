package com.proven.minimercado.entidades;

import java.io.Serializable;
import java.time.Instant;

public class Venda implements Serializable{

	private static final long serialVersionUID = 1L;
	
	private Integer idVenda;
	private Double precoTotal;
	private Instant dataHoraVenda;
	private Cliente cliente;
	private Funcionario funcionario;

	public Venda() {
	}
	
	public Venda(Integer idVenda, Double precoTotal, Instant dataHoraVenda, Cliente cliente, Funcionario funcionario) {
		this.idVenda = idVenda;
		this.precoTotal = precoTotal;
		this.dataHoraVenda = dataHoraVenda;
		this.cliente = cliente;
		this.funcionario = funcionario;
	}

	public Integer getIdVenda() {
		return idVenda;
	}

	public void setIdVenda(Integer idVenda) {
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

}
