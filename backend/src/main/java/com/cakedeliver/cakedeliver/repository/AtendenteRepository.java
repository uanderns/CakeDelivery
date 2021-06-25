package com.cakedeliver.cakedeliver.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.cakedeliver.cakedeliver.entities.Atendente;

@Repository
public interface AtendenteRepository extends JpaRepository<Atendente, Long> {

}
