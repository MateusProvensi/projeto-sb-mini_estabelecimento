package com.proven.minimercado.entidades;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity // Diz para o JPA que ele é uma entidade
@Table(name = "tb_cliente") // Diz para o JPA como será o nome da tabela
public class Cliente implements Serializable {

	private static final long serialVersionUID = 1L;

	@Id // Diz para o JPA que o atributo abaixo é o ID da tabela
	@GeneratedValue(strategy = GenerationType.IDENTITY) // Diz para o JPA que o atributo abaixo será gerado
														// automaticamente
	private Long idCliente;

	private String nome;
	private String sobrenome;
	private String cpf;
	private String rg;
	private String telefone;

	@OneToMany(mappedBy = "cliente") // Cria associacao de muitos para um e fala qual o nome do atributo que ele esta
										// mapeado na outra entidade
	private List<Venda> vendas = new ArrayList<>();

	public Cliente() {
	}

	public Cliente(Long idCliente, String nome, String sobrenome, String cpf, String rg, String telefone) {
		super();
		this.idCliente = idCliente;
		this.nome = nome;
		this.sobrenome = sobrenome;
		this.cpf = cpf;
		this.rg = rg;
		this.telefone = telefone;
	}

	public Long getIdCliente() {
		return idCliente;
	}

	public void setIdCliente(Long idCliente) {
		this.idCliente = idCliente;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getSobrenome() {
		return sobrenome;
	}

	public void setSobrenome(String sobrenome) {
		this.sobrenome = sobrenome;
	}

	public String getCpf() {
		return cpf;
	}

	public void setCpf(String cpf) {
		this.cpf = cpf;
	}

	public String getRg() {
		return rg;
	}

	public void setRg(String rg) {
		this.rg = rg;
	}

	public String getTelefone() {
		return telefone;
	}

	public void setTelefone(String telefone) {
		this.telefone = telefone;
	}

	public List<Venda> getVendas() {
		return vendas;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((idCliente == null) ? 0 : idCliente.hashCode());
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
		Cliente other = (Cliente) obj;
		if (idCliente == null) {
			if (other.idCliente != null)
				return false;
		} else if (!idCliente.equals(other.idCliente))
			return false;
		return true;
	}

}
