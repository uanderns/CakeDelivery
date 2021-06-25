package com.cakedeliver.cakedeliver.service;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cakedeliver.cakedeliver.entities.Atendente;
import com.cakedeliver.cakedeliver.repository.AtendenteRepository;

@Service
@Transactional
public class AtendenteService {
	
	@Autowired
	private AtendenteRepository repo;
	
	public List<Atendente> listAll(){
		return repo.findAll();
		
	}
	
	public void save(Atendente atendente) {
		repo.save(atendente);
	}
	
	public Atendente get(Long id) {
		return repo.findById(id).get();
	}
	
	public void delete(Long id) {
		repo.deleteById(id);
	}

}
