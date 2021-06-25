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
@Table(name = "tb_entregador")
public class Entregador extends Usuario {
	
	
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY.AUTO)
	@Column(name = "identregador")
	private Long idEntregador;
	private String docVeiculo;
	
	private String email;
	private String senha;
		
	@OneToMany(mappedBy ="entregador")
    @JsonIgnore
	private List <Pedido> pedido;
	
	
	public Entregador() {
		
	}
	

	public Entregador(Long idEntregador, String docVeiculo, String email, String senha, List<Pedido> pedido) {
		super();
		this.idEntregador = idEntregador;
		this.docVeiculo = docVeiculo;
		this.email = email;
		this.senha = senha;
		this.pedido = pedido;
	}

	public Long getIdEntregador() {
		return idEntregador;
	}

	public void setIdEntregador(Long idEntregador) {
		this.idEntregador = idEntregador;
	}

	public String getDocVeiculo() {
		return docVeiculo;
	}

	public void setDocVeiculo(String docVeiculo) {
		this.docVeiculo = docVeiculo;
	}
	
	
	public List<Pedido> getPedido() {
		return pedido;
	}

	public void setPedido(List<Pedido> pedido) {
		this.pedido = pedido;
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
		result = prime * result + ((idEntregador == null) ? 0 : idEntregador.hashCode());
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
		Entregador other = (Entregador) obj;
		if (idEntregador == null) {
			if (other.idEntregador != null)
				return false;
		} else if (!idEntregador.equals(other.idEntregador))
			return false;
		return true;
	}
	
	
	

}
