package com.cakedeliver.cakedeliver.service;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cakedeliver.cakedeliver.entities.Cancelamento;
import com.cakedeliver.cakedeliver.repository.CancelamentoRepository;

@Service
@Transactional
public class CancelamentoService {
	
	@Autowired
	private CancelamentoRepository repo;
	
	
	public List<Cancelamento> listAll(){
		return repo.findAll();
		
	}
	
	public void save(Cancelamento cancelamento) {
		repo.save(cancelamento);
	}
	
	public Cancelamento get(Long id) {
		return repo.findById(id).get();
	}
	
	public void delete(Long id) {
		repo.deleteById(id);
	}

}
