package com.cakedeliver.cakedeliver.entities;

import java.io.Serializable;
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
@Table(name = "tb_tipo_bolo")
public class TipoBolo implements Serializable {
	
	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY.AUTO)
	@Column(name = "idtipobolo")
	private Long idTipo;
	private String nomeTipo;
	
	
	@OneToMany(mappedBy = "tipobolo") // um tipo tem muitos bolos
	@JsonIgnore
	private List <Bolo> bolos;
	
	
	public TipoBolo() {
		
	}
	

	public TipoBolo(Long idTipo, String nomeTipo, List<Bolo> bolos) {
		super();
		this.idTipo = idTipo;
		this.nomeTipo = nomeTipo;
		this.bolos = bolos;
	}



	public Long getIdTipo() {
		return idTipo;
	}

	public void setIdTipo(Long idTipo) {
		this.idTipo = idTipo;
	}

	public String getNomeTipo() {
		return nomeTipo;
	}

	public void setNomeTipo(String nomeTipo) {
		this.nomeTipo = nomeTipo;
	}
	
	

	public List<Bolo> getBolos() {
		return bolos;
	}


	public void setBolos(List<Bolo> bolos) {
		this.bolos = bolos;
	}


	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((idTipo == null) ? 0 : idTipo.hashCode());
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
		TipoBolo other = (TipoBolo) obj;
		if (idTipo == null) {
			if (other.idTipo != null)
				return false;
		} else if (!idTipo.equals(other.idTipo))
			return false;
		return true;
	}
	
	
	
	
	
	
}

	
	