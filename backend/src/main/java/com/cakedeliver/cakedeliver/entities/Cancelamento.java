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
@Table(name="tb_cancelamento")
public class Cancelamento {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY.AUTO) //auto incremento no banco
	@Column(name = "idcancelamento")
	private Long idCancelamento;
	
	private String motivo;
		
	
	@OneToMany(mappedBy ="cancelamento") // muitos pedido para um cancelamento
	@JsonIgnore
	private List <Pedido> pedido;
	
	public Cancelamento() {
		
	}
	
	


	public Cancelamento(Long idCancelamento, String motivo, List<Pedido> pedido) {
		super();
		this.idCancelamento = idCancelamento;
		this.motivo = motivo;
		this.pedido = pedido;
	}




	@Override
	public String toString() {
		return "Cancelamento [idCancelamento=" + idCancelamento + ", motivo=" + motivo + "]";
	}


	public Long getIdCancelamento() {
		return idCancelamento;
	}


	public void setIdCancelamento(Long idCancelamento) {
		this.idCancelamento = idCancelamento;
	}


	public String getMotivo() {
		return motivo;
	}


	public void setMotivo(String motivo) {
		this.motivo = motivo;
	}




	public List<Pedido> getPedido() {
		return pedido;
	}




	public void setPedido(List<Pedido> pedido) {
		this.pedido = pedido;
	}




	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((idCancelamento == null) ? 0 : idCancelamento.hashCode());
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
		Cancelamento other = (Cancelamento) obj;
		if (idCancelamento == null) {
			if (other.idCancelamento != null)
				return false;
		} else if (!idCancelamento.equals(other.idCancelamento))
			return false;
		return true;
	}
	
	

	


}
