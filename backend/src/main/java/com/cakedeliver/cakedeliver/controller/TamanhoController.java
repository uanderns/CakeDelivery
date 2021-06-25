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
import com.cakedeliver.cakedeliver.entities.Tamanho;
import com.cakedeliver.cakedeliver.service.TamanhoService;

@RestController
@RequestMapping("api/v1")
@CrossOrigin(origins="*")
public class TamanhoController {
	
	@Autowired
	private TamanhoService service;
	
	@GetMapping("/tamanhos")
	public List<Tamanho> list(){
		return service.listAll();
	}
	
	@GetMapping("tamanhos/{id}")
	public ResponseEntity<Tamanho> get(@PathVariable Long id){
		try {
			Tamanho tamanho = service.get(id);
			return new ResponseEntity<Tamanho>(tamanho, HttpStatus.OK);
		}catch(NoSuchElementException e) {
			return new ResponseEntity<Tamanho>(HttpStatus.NOT_FOUND);
		}
	}
	
	@PostMapping("/tamanhos")
	public void add(@RequestBody Tamanho tamanho) {
		service.save(tamanho);
		System.out.println("gravado");
	}
	
	@PutMapping("/tamanhos/{id}")
	public ResponseEntity<?> update(@RequestBody Tamanho tamanho,
			@PathVariable Long id){
		try {
			Tamanho existTamanho = service.get(id);
			service.save(tamanho);
			return new ResponseEntity<>(HttpStatus.OK);
		}catch (NoSuchElementException e) {
			System.out.println(e);
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}
	}
	
	@DeleteMapping("/tamanhos/{id}")
	public void delete(@PathVariable Long id) {
		service.delete(id);
	}

}
