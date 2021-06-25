package com.cakedeliver.cakedeliver.service;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.cakedeliver.cakedeliver.entities.Tamanho;
import com.cakedeliver.cakedeliver.repository.TamanhoRepository;

@Service
@Transactional
public class TamanhoService {
	
	@Autowired
	private TamanhoRepository repo;
	
	public List<Tamanho> listAll(){
		return repo.findAll();
		
	}
	
	public void save(Tamanho tamanho) {
		repo.save(tamanho);
	}
	
	public Tamanho get(Long id) {
		return repo.findById(id).get();
	}
	
	public void delete(Long id) {
		repo.deleteById(id);
	}

}
