package com.cakedeliver.cakedeliver.service;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.cakedeliver.cakedeliver.entities.AvaliacaoPedido;
import com.cakedeliver.cakedeliver.repository.AvaliacaoPedidoRepository;

@Service
@Transactional
public class AvaliacaoPedidoService {
	
	@Autowired
	private AvaliacaoPedidoRepository repo;
	
	public List<AvaliacaoPedido> listAll(){
		return repo.findAll();
		
	}
	
	public void save(AvaliacaoPedido avaliacaopedido) {
		repo.save(avaliacaopedido);
	}
	
	public AvaliacaoPedido get(Long id) {
		return repo.findById(id).get();
	}
	
	public void delete(Long id) {
		repo.deleteById(id);
	}
	

}
