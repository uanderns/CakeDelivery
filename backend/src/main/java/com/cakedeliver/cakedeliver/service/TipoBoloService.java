package com.cakedeliver.cakedeliver.service;

import java.util.List;
import javax.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.cakedeliver.cakedeliver.entities.TipoBolo;
import com.cakedeliver.cakedeliver.repository.TipoBoloRepository;

@Service
@Transactional
public class TipoBoloService {
	
	@Autowired
	private TipoBoloRepository repo;
	
	public List<TipoBolo> listAll(){
		return repo.findAll();
		
	}
	
	public void save(TipoBolo tipobolo) {
		repo.save(tipobolo);
	}
	
	public TipoBolo get(Long id) {
		return repo.findById(id).get();
	}
	
	public void delete(Long id) {
		repo.deleteById(id);
	}

}
