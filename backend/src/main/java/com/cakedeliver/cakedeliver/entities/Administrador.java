package com.cakedeliver.cakedeliver.entities;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "tb_administrador")
public class Administrador extends Funcionario {

	
	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY.AUTO)
	private Long idAdm;
	private Boolean ativo = true;
	
	private String email;
	private String senha;
	
	
	public Administrador() {
		
	}

	
	public Administrador(Long idAdm, Boolean ativo, String email, String senha) {
		super();
		this.idAdm = idAdm;
		this.ativo = ativo;
		this.email = email;
		this.senha = senha;
	}


	public Long getIdAdm() {
		return idAdm;
	}

	public void setIdAdm(Long idAdm) {
		this.idAdm = idAdm;
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
		int result = 1;
		result = prime * result + ((idAdm == null) ? 0 : idAdm.hashCode());
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
		Administrador other = (Administrador) obj;
		if (idAdm == null) {
			if (other.idAdm != null)
				return false;
		} else if (!idAdm.equals(other.idAdm))
			return false;
		return true;
	}
	
	
}
