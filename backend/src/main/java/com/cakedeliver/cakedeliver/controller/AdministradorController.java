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
import com.cakedeliver.cakedeliver.entities.Administrador;
import com.cakedeliver.cakedeliver.service.AdministradorService;

@RestController
@RequestMapping("api/v1")
@CrossOrigin(origins="*")
public class AdministradorController {
	
	@Autowired
	private AdministradorService service;
	
	
	@GetMapping("/administradores")
	public List<Administrador> list(){
		return service.listAll();
	}
	
	@GetMapping("administradores/{id}")
	public ResponseEntity<Administrador> get(@PathVariable Long id){
		try {
			Administrador administrador = service.get(id);
			return new ResponseEntity<Administrador>(administrador, HttpStatus.OK);
		}catch(NoSuchElementException e) {
			return new ResponseEntity<Administrador>(HttpStatus.NOT_FOUND);
		}
	}
	
	@PostMapping("/administradores")
	public void add(@RequestBody Administrador administrador) {
		service.save(administrador);
		System.out.println("gravado");
	}
	
	@PutMapping("/administradores/{id}")
	public ResponseEntity<?> update(@RequestBody Administrador administrador,
			@PathVariable Long id){
		try {
			Administrador existAdministrador = service.get(id);
			service.save(administrador);
			return new ResponseEntity<>(HttpStatus.OK);
		}catch (NoSuchElementException e) {
			System.out.println(e);
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}
	}
	
	@DeleteMapping("/administradores/{id}")
	public void delete(@PathVariable Long id) {
		service.delete(id);
	}
	
	
	

}
