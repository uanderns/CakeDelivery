package com.cakedeliver.cakedeliver.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.cakedeliver.cakedeliver.entities.Pedido;

@Repository
public interface PedidoRepository extends JpaRepository<Pedido, Long> {
	
	// Ordenar os pedidos do mais antigo pro mais recente
	
	@Query("SELECT DISTINCT obj FROM Pedido obj JOIN FETCH obj.bolos "
			+ " WHERE obj.status = 'PENDENTE' ORDER BY obj.moment ASC")
	List<Pedido> findPedidosWithBolos();

}
