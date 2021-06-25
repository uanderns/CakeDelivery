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
import com.cakedeliver.cakedeliver.entities.Atendente;
import com.cakedeliver.cakedeliver.service.AtendenteService;

@RestController
@RequestMapping("api/v1")
@CrossOrigin(origins="*")
public class AtendenteController {
	
	@Autowired
	private AtendenteService service;
	
	@GetMapping("/atendentes")
	public List<Atendente> list(){
		return service.listAll();
	}
	
	@GetMapping("atendentes/{id}")
	public ResponseEntity<Atendente> get(@PathVariable Long id){
		try {
			Atendente atendente = service.get(id);
			return new ResponseEntity<Atendente>(atendente, HttpStatus.OK);
		}catch(NoSuchElementException e) {
			return new ResponseEntity<Atendente>(HttpStatus.NOT_FOUND);
		}
	}
	
	@PostMapping("/atendentes")
	public void add(@RequestBody Atendente atendente) {
		service.save(atendente);
		System.out.println("gravado");
	}
	
	@PutMapping("/atendentes/{id}")
	public ResponseEntity<?> update(@RequestBody Atendente atendente,
			@PathVariable Long id){
		try {
			Atendente existAtendente = service.get(id);
			service.save(atendente);
			return new ResponseEntity<>(HttpStatus.OK);
		}catch (NoSuchElementException e) {
			System.out.println(e);
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}
	}
	
	@DeleteMapping("/atendentes/{id}")
	public void delete(@PathVariable Long id) {
		service.delete(id);
	}
	

}
