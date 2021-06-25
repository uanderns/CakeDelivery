package com.cakedeliver.cakedeliver.controller;

import java.util.List;
import java.util.NoSuchElementException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.cakedeliver.cakedeliver.entities.AvaliacaoPedido;
import com.cakedeliver.cakedeliver.service.AvaliacaoPedidoService;

@RestController
@RequestMapping("api/v1")
@CrossOrigin(origins="*")
public class AvaliacaoPedidoController {
	
	@Autowired
	private AvaliacaoPedidoService service;
	
	@GetMapping("/avaliacoes")
	public List<AvaliacaoPedido> list(){
		return service.listAll();
	}
	
	@GetMapping("avaliacoes/{id}")
	public ResponseEntity<AvaliacaoPedido> get(@PathVariable Long id){
		try {
			AvaliacaoPedido avaliacaopedido = service.get(id);
			return new ResponseEntity<AvaliacaoPedido>(avaliacaopedido, HttpStatus.OK);
		}catch(NoSuchElementException e) {
			return new ResponseEntity<AvaliacaoPedido>(HttpStatus.NOT_FOUND);
		}
	}
	
	@PostMapping("/avaliacoes")
	public void add(@RequestBody AvaliacaoPedido avaliacaopedido) {
		service.save(avaliacaopedido);
		System.out.println("gravado");
	}
	
	@PutMapping("/avaliacoes/{id}")
	public ResponseEntity<?> update(@RequestBody AvaliacaoPedido avaliacaopedido,
			@PathVariable Long id){
		try {
			AvaliacaoPedido existAvaliacaoPedido = service.get(id);
			service.save(avaliacaopedido);
			return new ResponseEntity<>(HttpStatus.OK);
		}catch (NoSuchElementException e) {
			System.out.println(e);
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}
	}
	
	@DeleteMapping("/avaliacoes/{id}")
	public void delete(@PathVariable Long id) {
		service.delete(id);
	}
	

}
