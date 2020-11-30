package com.proven.minimercado.resources;

import java.net.URI;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import com.proven.minimercado.entidades.Cliente;
import com.proven.minimercado.servicos.ClienteServico;

@RestController // Diz que ele é um controlador Rest
@RequestMapping(value = "/clientes") // Define o valor do caminho do recurso
public class ClienteResource {

	@Autowired
	private ClienteServico servico;

	// ResponseEntity - Tipo especifico para respostas de requisição web
	// Essa anotattion abaixo é o que deixa explicito que o metodo abaixo responde a
	// requisição do tipo Get (Pegar) do HTTP
	@GetMapping
	public ResponseEntity<List<Cliente>> acharTodos() {
		List<Cliente> lista = servico.acharTodos();
		return ResponseEntity.ok().body(lista); // Retorna OK para dizer que esta okay a resposta do metodo
												// HTTP e o body é qual o corpo da resposta
	}

	// O value diz que a requisicao ira aceitar um valor dentro da URL
	// O PathVariable significa que o Spring vai considerar o parametro da funcao
	// para o parametro da URL
	@GetMapping(value = "/{id}")
	public ResponseEntity<Cliente> acharPeloId(@PathVariable Long id) {
		Cliente obj = servico.acharPeloId(id);
		return ResponseEntity.ok().body(obj);
	}

	// Essa anotattion abaixo é o que deixa explicito que o metodo abaixo responde a
	// requisição do tipo Post (Inserir) do HTTP
	// o RequestBody significa que o Json será transformado em objeto e viceversa
	@PostMapping
	public ResponseEntity<Cliente> insert(@RequestBody Cliente obj) {
		obj = servico.insert(obj);
		URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}")
				.buildAndExpand(obj.getIdCliente()).toUri();
		// A linha acima pega a nova URL que foi criada para o Cliente
		return ResponseEntity.created(uri).body(obj); // Retorna o created por que é recomendado retornar
		// o codigo de criacao (201)
	}
	
	// Essa anotattion abaixo é o que deixa explicito que o metodo abaixo responde a
	// requisição do tipo Delete (Deletar) do HTTP
	@DeleteMapping(value = "/{id}")
	public ResponseEntity<Void> delete(@PathVariable Long id){ 
		servico.delete(id);
		return ResponseEntity.noContent().build(); // O noContent retorna uma resposta vazia e o codigo 204
	}
	
	// Essa anotattion abaixo é o que deixa explicito que o metodo abaixo responde a
	// requisição do tipo Update (Atualizar) do HTTP
	@PutMapping(value = "/{id}")
	public ResponseEntity<Cliente> update(@PathVariable Long id, @RequestBody Cliente obj) {
		obj = servico.update(id, obj);
		return ResponseEntity.ok().body(obj);
	}
	
}
