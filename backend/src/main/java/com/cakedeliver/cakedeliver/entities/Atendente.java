package com.cakedeliver.cakedeliver.entities;


import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "tb_atendente")
public class Atendente extends Funcionario {
	
	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY.AUTO)
	private Long idAtendente;
	private Boolean ativo = true;
	
	private String email;
	private String senha;
	
	
	public Atendente() {
		
	}

	

	public Atendente(Long idAtendente, Boolean ativo, String email, String senha) {
		super();
		this.idAtendente = idAtendente;
		this.ativo = ativo;
		this.email = email;
		this.senha = senha;
	}



	public Long getIdAtendente() {
		return idAtendente;
	}

	public void setIdAtendente(Long idAtendente) {
		this.idAtendente = idAtendente;
	}

	public Boolean getAtivo() {
		return ativo;
	}

	public void setAtivo(Boolean ativo) {
		this.ativo = ativo;
	}

	
		
	public String getEmail() {
		return email;
	}



	public void setEmail(String email) {
		this.email = email;
	}



	public String getSenha() {
		return senha;
	}



	public void setSenha(String senha) {
		this.senha = senha;
	}



	@Override
	public int hashCode() {
		final int prime = 31;
		int result = super.hashCode();
		result = prime * result + ((idAtendente == null) ? 0 : idAtendente.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (!super.equals(obj))
			return false;
		if (getClass() != obj.getClass())
			return false;
		Atendente other = (Atendente) obj;
		if (idAtendente == null) {
			if (other.idAtendente != null)
				return false;
		} else if (!idAtendente.equals(other.idAtendente))
			return false;
		return true;
	}

	
	
	
}
