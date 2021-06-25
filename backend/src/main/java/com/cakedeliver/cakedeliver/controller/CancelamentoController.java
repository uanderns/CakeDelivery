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
import com.cakedeliver.cakedeliver.entities.Cancelamento;
import com.cakedeliver.cakedeliver.service.CancelamentoService;

@RestController
@RequestMapping("api/v1")
@CrossOrigin(origins="*")
public class CancelamentoController {
	
	@Autowired
	private CancelamentoService service;
	
	
	@GetMapping("/cancelamentos")
	public List<Cancelamento> list(){
		return service.listAll();
	}
	
	@GetMapping("cancelamentos/{id}")
	public ResponseEntity<Cancelamento> get(@PathVariable Long id){
		try {
			Cancelamento cancelamento = service.get(id);
			return new ResponseEntity<Cancelamento>(cancelamento, HttpStatus.OK);
		}catch(NoSuchElementException e) {
			return new ResponseEntity<Cancelamento>(HttpStatus.NOT_FOUND);
		}
	}
	
	@PostMapping("/cancelamentos")
	public void add(@RequestBody Cancelamento cancelamento) {
		service.save(cancelamento);
		System.out.println("gravado");
	}
	
	@PutMapping("/cancelamentos/{id}")
	public ResponseEntity<?> update(@RequestBody Cancelamento cancelamento,
			@PathVariable Long id){
		try {
			Cancelamento existCancelamento = service.get(id);
			service.save(cancelamento);
			return new ResponseEntity<>(HttpStatus.OK);
		}catch (NoSuchElementException e) {
			System.out.println(e);
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}
	}
	
	@DeleteMapping("/cancelamentos/{id}")
	public void delete(@PathVariable Long id) {
		service.delete(id);
	}
	
	

}
