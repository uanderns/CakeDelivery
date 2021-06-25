package com.cakedeliver.cakedeliver.service;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.cakedeliver.cakedeliver.entities.Administrador;
import com.cakedeliver.cakedeliver.repository.AdministradorRepository;

@Service
@Transactional
public class AdministradorService {
	
	@Autowired
	private AdministradorRepository repo;
	
	public List<Administrador> listAll(){
		return repo.findAll();
		
	}
	
	public void save(Administrador administrador) {
		repo.save(administrador);
	}
	
	public Administrador get(Long id) {
		return repo.findById(id).get();
	}
	
	public void delete(Long id) {
		repo.deleteById(id);
	}

}
