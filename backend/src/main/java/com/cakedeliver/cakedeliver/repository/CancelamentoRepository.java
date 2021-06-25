package com.cakedeliver.cakedeliver.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.cakedeliver.cakedeliver.entities.Cancelamento;

@Repository
public interface CancelamentoRepository extends JpaRepository<Cancelamento, Long>{

}
