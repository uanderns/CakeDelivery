package com.cakedeliver.cakedeliver.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.cakedeliver.cakedeliver.entities.Sabor;

@Repository
public interface SaborRepository extends JpaRepository<Sabor, Long>  {

}
