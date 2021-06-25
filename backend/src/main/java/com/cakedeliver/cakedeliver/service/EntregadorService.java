package com.cakedeliver.cakedeliver.service;

import java.util.List;
import javax.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.cakedeliver.cakedeliver.entities.Entregador;
import com.cakedeliver.cakedeliver.repository.EntregadorRepository;

@Service
@Transactional
public class EntregadorService {
	
	@Autowired
	private EntregadorRepository repo;
	
	public List<Entregador> listAll(){
		return repo.findAll();
		
	}
	
	public void save(Entregador entregador) {
		repo.save(entregador);
	}
	
	public Entregador get(Long id) {
		return repo.findById(id).get();
	}
	
	public void delete(Long id) {
		repo.deleteById(id);
	}
	
	

}
