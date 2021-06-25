package com.cakedeliver.cakedeliver.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.cakedeliver.cakedeliver.entities.AvaliacaoPedido;

@Repository
public interface AvaliacaoPedidoRepository extends JpaRepository<AvaliacaoPedido,Long> {

}
