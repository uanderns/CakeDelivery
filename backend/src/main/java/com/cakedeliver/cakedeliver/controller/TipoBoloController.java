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
import com.cakedeliver.cakedeliver.entities.TipoBolo;
import com.cakedeliver.cakedeliver.service.TipoBoloService;

@RestController
@RequestMapping("api/v1")
@CrossOrigin(origins="*")
public class TipoBoloController {

	@Autowired
	private TipoBoloService service;
	
	@GetMapping("/tipobolos")
	public List<TipoBolo> list(){
		return service.listAll();
	}
	
	@GetMapping("tipobolos/{id}")
	public ResponseEntity<TipoBolo> get(@PathVariable Long id){
		try {
			TipoBolo tipobolo = service.get(id);
			return new ResponseEntity<TipoBolo>(tipobolo, HttpStatus.OK);
		}catch(NoSuchElementException e) {
			return new ResponseEntity<TipoBolo>(HttpStatus.NOT_FOUND);
		}
	}
	
	@PostMapping("/tipobolos")
	public void add(@RequestBody TipoBolo tipobolo) {
		service.save(tipobolo);
		System.out.println("gravado");
	}
	
	@PutMapping("/tipobolos/{id}")
	public ResponseEntity<?> update(@RequestBody TipoBolo tipobolo,
			@PathVariable Long id){
		try {
			TipoBolo existTipoBolo = service.get(id);
			service.save(tipobolo);
			return new ResponseEntity<>(HttpStatus.OK);
		}catch (NoSuchElementException e) {
			System.out.println(e);
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}
	}
	
	@DeleteMapping("/tipobolos/{id}")
	public void delete(@PathVariable Long id) {
		service.delete(id);
	}
}
