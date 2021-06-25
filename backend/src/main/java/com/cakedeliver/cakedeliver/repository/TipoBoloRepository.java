package com.cakedeliver.cakedeliver.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.cakedeliver.cakedeliver.entities.TipoBolo;

@Repository
public interface TipoBoloRepository extends JpaRepository<TipoBolo, Long>{

}
