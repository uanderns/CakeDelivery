package com.cakedeliver.cakedeliver.service;

import java.util.List;

import javax.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.cakedeliver.cakedeliver.entities.Pedido;
import com.cakedeliver.cakedeliver.repository.PedidoRepository;


@Service
@Transactional
public class PedidoService {

	@Autowired
	private PedidoRepository repo;
	
	public List<Pedido> findAll(){
		return repo.findPedidosWithBolos();
		
	}
	
	public void save(Pedido pedido) {
		repo.save(pedido);
	}
	
	public Pedido get(Long id) {
		return repo.findById(id).get();
	}
	
	public void delete(Long id) {
		repo.deleteById(id);
	}
	
	
}
