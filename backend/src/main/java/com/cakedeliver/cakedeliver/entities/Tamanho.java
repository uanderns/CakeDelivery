package com.cakedeliver.cakedeliver.entities;

import java.util.List;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
@Table(name = "tb_tamanho")
public class Tamanho {

	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY) //auto incremento no banco
	@Column(name = "idtamanho")
 	private Long idTamanho;
	private String tamanho;
	
	
	
	@OneToMany(mappedBy = "tamanho") // muitos bolos para um tamanho
	@JsonIgnore
	private List <Bolo> bolos;
	
	
	public Tamanho() {
		
	}

	
	public Tamanho(Long idTamanho, String tamanho, List<Bolo> bolos) {
		super();
		this.idTamanho = idTamanho;
		this.tamanho = tamanho;
		this.bolos = bolos;
	}


	public Long getIdTamanho() {
		return idTamanho;
	}

	public void setIdTamanho(Long idTamanho) {
		this.idTamanho = idTamanho;
	}

	public String getTamanho() {
		return tamanho;
	}

	public void setTamanho(String tamanho) {
		this.tamanho = tamanho;
	}
	
	

	public List<Bolo> getBolos() {
		return bolos;
	}




	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((idTamanho == null) ? 0 : idTamanho.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Tamanho other = (Tamanho) obj;
		if (idTamanho == null) {
			if (other.idTamanho != null)
				return false;
		} else if (!idTamanho.equals(other.idTamanho))
			return false;
		return true;
	}
	
	
	
	
}