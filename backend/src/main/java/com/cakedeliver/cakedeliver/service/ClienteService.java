package com.cakedeliver.cakedeliver.service;

import java.util.List;
import javax.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.cakedeliver.cakedeliver.entities.Cliente;
import com.cakedeliver.cakedeliver.repository.ClienteRepository;

@Service
@Transactional
public class ClienteService {
	
	@Autowired
	private ClienteRepository repo;
	
	public List<Cliente> listAll(){
		return repo.findAll();
		
	}
	
	public void save(Cliente cliente) {
		
		if(cliente.getIdCliente() == null && cliente.getEmail().isEmpty())
					
		repo.save(cliente);
	}
	
	public Cliente get(Long id) {
		return repo.findById(id).get();
	}
	
	public void delete(Long id) {
		repo.deleteById(id);
	}

}
