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

import com.proven.minimercado.entidades.Item;
import com.proven.minimercado.servicos.ItemServico;

@RestController
@RequestMapping(value = "/itens")
public class ItemResource {

	@Autowired
	private ItemServico servico;
	
	@GetMapping
	public ResponseEntity<List<Item>> acharTodos() {
		List<Item> lista = servico.acharTodos();
		return ResponseEntity.ok().body(lista);
	}
	
	@GetMapping(value = "/{id}")
	public ResponseEntity<Item> acharPeloId(@PathVariable Long id) {
		Item obj = servico.acharPeloId(id);
		return ResponseEntity.ok().body(obj);
	}
	
	@PostMapping
	public ResponseEntity<Item> insert(@RequestBody Item obj) {
		obj = servico.insert(obj);
		URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}")
				.buildAndExpand(obj.getIdItem()).toUri();
		return ResponseEntity.created(uri).body(obj);
	}
	
	@DeleteMapping(value = "/{id}")
	public ResponseEntity<Void> delete(@PathVariable Long id) {
		servico.delete(id);
		return ResponseEntity.noContent().build();
	}
	
	@PutMapping(value = "/{id}")
	public ResponseEntity<Item> update(@PathVariable Long id, @RequestBody Item obj) {
		obj = servico.update(id, obj);
		return ResponseEntity.ok().body(obj);
	}	
}
