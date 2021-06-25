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
import com.cakedeliver.cakedeliver.entities.Sabor;
import com.cakedeliver.cakedeliver.service.SaborService;


@RestController
@RequestMapping("api/v1")
@CrossOrigin(origins="*")
public class SaborController {
	
	@Autowired
	private SaborService service;
	
	@GetMapping("/sabores")
	public List<Sabor> list(){
		return service.listAll();
	}
	
	@GetMapping("sabores/{id}")
	public ResponseEntity<Sabor> get(@PathVariable Long id){
		try {
			Sabor sabor = service.get(id);
			return new ResponseEntity<Sabor>(sabor, HttpStatus.OK);
		}catch(NoSuchElementException e) {
			return new ResponseEntity<Sabor>(HttpStatus.NOT_FOUND);
		}
	}
	
	@PostMapping("/sabores")
	public void add(@RequestBody Sabor sabor) {
		service.save(sabor);
		System.out.println("gravado");
	}
	
	@PutMapping("/sabores/{id}")
	public ResponseEntity<?> update(@RequestBody Sabor sabor,
			@PathVariable Long id){
		try {
			Sabor existSabor = service.get(id);
			service.save(sabor);
			return new ResponseEntity<>(HttpStatus.OK);
		}catch (NoSuchElementException e) {
			System.out.println(e);
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}
	}
	
	@DeleteMapping("/sabores/{id}")
	public void delete(@PathVariable Long id) {
		service.delete(id);
	}
	
	

}
