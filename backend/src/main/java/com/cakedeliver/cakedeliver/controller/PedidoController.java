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
import com.cakedeliver.cakedeliver.entities.Pedido;
import com.cakedeliver.cakedeliver.service.PedidoService;

@RestController
@RequestMapping("api/v1")
@CrossOrigin(origins="*")
public class PedidoController {
	
	@Autowired
	private PedidoService service;
	
	@GetMapping("/pedidos")
	public List<Pedido> findAll(){
		return service.findAll();
	}
	
	@GetMapping("pedidos/{id}")
	public ResponseEntity<Pedido> get(@PathVariable Long id){
		try {
			Pedido pedido = service.get(id);
			return new ResponseEntity<Pedido>(pedido, HttpStatus.OK);
		}catch(NoSuchElementException e) {
			return new ResponseEntity<Pedido>(HttpStatus.NOT_FOUND);
		}
	}
	
	@PostMapping("/pedidos")
	public void add(@RequestBody Pedido pedido) {
		service.save(pedido);
		System.out.println("gravado");
	}
	
	@PutMapping("/pedidos/{id}")
	public ResponseEntity<?> update(@RequestBody Pedido pedido,
			@PathVariable Long id){
		try {
			Pedido existPedido = service.get(id);
			service.save(pedido);
			return new ResponseEntity<>(HttpStatus.OK);
		}catch (NoSuchElementException e) {
			System.out.println(e);
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}
	}
	
	@DeleteMapping("/pedidos/{id}")
	public void delete(@PathVariable Long id) {
		service.delete(id);
	}

}
