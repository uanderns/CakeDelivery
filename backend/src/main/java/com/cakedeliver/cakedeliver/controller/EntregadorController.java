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
import com.cakedeliver.cakedeliver.entities.Entregador;
import com.cakedeliver.cakedeliver.service.EntregadorService;


@RestController
@RequestMapping("api/v1")
@CrossOrigin(origins="*")
public class EntregadorController {
	
	@Autowired
	private EntregadorService service;
	
	@GetMapping("/entregadores")
	public List<Entregador> list(){
		return service.listAll();
	}
	
	@GetMapping("entregadores/{id}")
	public ResponseEntity<Entregador> get(@PathVariable Long id){
		try {
			Entregador entregador = service.get(id);
			return new ResponseEntity<Entregador>(entregador, HttpStatus.OK);
		}catch(NoSuchElementException e) {
			return new ResponseEntity<Entregador>(HttpStatus.NOT_FOUND);
		}
	}
	
	@PostMapping("/entregadores")
	public void add(@RequestBody Entregador entregador) {
		service.save(entregador);
		System.out.println("gravado");
	}
	
	@PutMapping("/entregadores/{id}")
	public ResponseEntity<?> update(@RequestBody Entregador entregador,
			@PathVariable Long id){
		try {
			Entregador existEntregador = service.get(id);
			service.save(entregador);
			return new ResponseEntity<>(HttpStatus.OK);
		}catch (NoSuchElementException e) {
			System.out.println(e);
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}
	}
	
	@DeleteMapping("/entregadores/{id}")
	public void delete(@PathVariable Long id) {
		service.delete(id);
	}
	
	

}
