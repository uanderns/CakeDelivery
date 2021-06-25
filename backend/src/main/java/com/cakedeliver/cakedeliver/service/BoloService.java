package com.cakedeliver.cakedeliver.service;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cakedeliver.cakedeliver.entities.Bolo;
import com.cakedeliver.cakedeliver.repository.BoloRepository;

@Service
@Transactional
public class BoloService {
	
	@Autowired
	private BoloRepository repo;
	
	public List<Bolo> listAll(){
		return repo.findAllByOrderByNomeAsc();
	}	
	
	public void save(Bolo bolo) {
		repo.save(bolo);
	}
	
	public Bolo get(Long id) {
		return repo.findById(id).get();
	}
	
	public void delete(Long id) {
		repo.deleteById(id);
	}

}
