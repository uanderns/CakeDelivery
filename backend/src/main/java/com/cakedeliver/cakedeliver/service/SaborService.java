package com.cakedeliver.cakedeliver.service;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.cakedeliver.cakedeliver.entities.Sabor;
import com.cakedeliver.cakedeliver.repository.SaborRepository;

@Service
@Transactional
public class SaborService {
	
	@Autowired
	private SaborRepository repo;
	
	public List<Sabor> listAll(){
		return repo.findAll();
		
	}
	
	public void save(Sabor sabor) {
		repo.save(sabor);
	}
	
	public Sabor get(Long id) {
		return repo.findById(id).get();
	}
	
	public void delete(Long id) {
		repo.deleteById(id);
	}

}
