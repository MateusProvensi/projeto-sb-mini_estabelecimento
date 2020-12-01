package com.proven.minimercado.config;

import java.time.Instant;
import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

import com.proven.minimercado.entidades.Cliente;
import com.proven.minimercado.entidades.Empresa;
import com.proven.minimercado.entidades.Fornecedor;
import com.proven.minimercado.entidades.FornecedorMarca;
import com.proven.minimercado.entidades.Funcionario;
import com.proven.minimercado.entidades.Item;
import com.proven.minimercado.entidades.ItemVenda;
import com.proven.minimercado.entidades.Marca;
import com.proven.minimercado.entidades.Venda;
import com.proven.minimercado.repositorios.ClienteRepositorio;
import com.proven.minimercado.repositorios.EmpresaRepositorio;
import com.proven.minimercado.repositorios.FornecedorMarcaRepositorio;
import com.proven.minimercado.repositorios.FornecedorRepositorio;
import com.proven.minimercado.repositorios.FuncionarioRepositorio;
import com.proven.minimercado.repositorios.ItemRepositorio;
import com.proven.minimercado.repositorios.ItemVendaRepositorio;
import com.proven.minimercado.repositorios.MarcaRepositorio;
import com.proven.minimercado.repositorios.VendaRepositorio;

@Configuration // Define como um classe de configuracao
@Profile("teste") // Diz o nome do profile, desta forma ele será executado conforme o nome dado no .properties
public class TesteConfig implements CommandLineRunner{

	@Autowired
	private ClienteRepositorio clienteRepositorio;
	
	@Autowired
	private EmpresaRepositorio empresaRepositorio;
	
	@Autowired
	private FornecedorMarcaRepositorio fornecedorMarcaRepositorio;
	
	@Autowired
	private FornecedorRepositorio fornecedorRepositorio;
	
	@Autowired
	private FuncionarioRepositorio funcionarioRepositorio;
	
	@Autowired
	private ItemRepositorio itemRepositorio;
	
	@Autowired
	private ItemVendaRepositorio itemVendaRepositorio;
	
	@Autowired
	private MarcaRepositorio marcaRepositorio;
	
	@Autowired
	private VendaRepositorio vendaRepositorio;
	
	@Override
	public void run(String... args) throws Exception {
		
		Empresa emp1 = new Empresa(null, "Doces e salgados", "123456789", "41546");
		Empresa emp2 = new Empresa(null, "Fioravanco", "123456789", "41546");
		Empresa emp3 = new Empresa(null, "Friboi", "123456789", "41546");
		
		Fornecedor for1 = new Fornecedor(null, Instant.parse("2020-11-30T15:23:20Z"), "Eurico", "Silva", "123489", "568485", "1646", emp1);
		Fornecedor for2 = new Fornecedor(null, Instant.parse("2020-11-24T15:23:20Z"), "Luciana", "Souza", "123489", "568485", "1646", emp3);
		
		Marca mar1 = new Marca(null, "Paos quentes", "2139798", emp1);
		Marca mar2 = new Marca(null, "Carnes e derivados", "158464", emp3);
		Marca mar3 = new Marca(null, "Carnes veganas", "158464", emp3);
				
		FornecedorMarca fm1 = new FornecedorMarca(for1, mar1);
		FornecedorMarca fm2 = new FornecedorMarca(for2, mar2);
		FornecedorMarca fm3 = new FornecedorMarca(for2, mar3);
		
		empresaRepositorio.saveAll(Arrays.asList(emp1, emp2, emp3));
		fornecedorRepositorio.saveAll(Arrays.asList(for1, for2));
		marcaRepositorio.saveAll(Arrays.asList(mar1, mar2, mar3));
		fornecedorMarcaRepositorio.saveAll(Arrays.asList(fm1, fm2, fm3));
		
		Cliente cli1 = new Cliente(null, "Jaspion", "Souza", "12234569", "123748", "15674465");
		Cliente cli2 = new Cliente(null, "Sapao", "Jato", "12234569", "123748", "15674465");
		
		Funcionario fun1 = new Funcionario(null, "Marcela", "da Luz", "13485", "156456", "16546", 1);
		Funcionario fun2 = new Funcionario(null, "Leandro", "Fernandes", "13485", "156456", "16546", 2);
		
		Item i1 = new Item(null, "Pães", "1236875", 1.56, 100, Instant.parse("2020-12-03T10:00:00Z"), "A", fm1);
		Item i2 = new Item(null, "Picanha", "1236862", 72.32, 100, Instant.parse("2021-06-03T10:00:00Z"), "B", fm2);
		Item i3 = new Item(null, "Frango Vegano", "1236862", 32.35, 100, Instant.parse("2021-06-03T10:00:00Z"), "B", fm3);
		
		Venda v1 = new Venda(null, 0.00, Instant.parse("2020-12-01T09:00:00Z"), cli1, fun1);
		Venda v2 = new Venda(null, 0.00, Instant.parse("2020-11-30T09:00:00Z"), cli2, fun2);
		
		clienteRepositorio.saveAll(Arrays.asList(cli1, cli2));
		funcionarioRepositorio.saveAll(Arrays.asList(fun1, fun2));
		itemRepositorio.saveAll(Arrays.asList(i1, i2, i3));
		vendaRepositorio.saveAll(Arrays.asList(v1, v2));
		
		ItemVenda iv1 = new ItemVenda(i1, v1, 3, i1.getPrecoVenda());
		ItemVenda iv2 = new ItemVenda(i2, v1, 5, i2.getPrecoVenda());
		ItemVenda iv3 = new ItemVenda(i3, v2, 10, i3.getPrecoVenda());
		
		itemVendaRepositorio.saveAll(Arrays.asList(iv1, iv2, iv3));
		
		v1.getItens().add(iv1);
		v1.getItens().add(iv2);
		
		v2.getItens().add(iv3);
		
		v1.setPrecoTotal(v1.getTotal());
		v2.setPrecoTotal(v2.getTotal());
		
		vendaRepositorio.saveAll(Arrays.asList(v1, v2));
		itemVendaRepositorio.saveAll(Arrays.asList(iv1, iv2, iv3));
	}

}
