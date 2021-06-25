package com.cakedeliver.cakedeliver.entities;

import java.io.Serializable;
import java.time.Instant;
import java.util.HashSet;
import java.util.Set;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import org.hibernate.annotations.ColumnDefault;

import com.cakedeliver.cakedeliver.enums.PedidoStatus;


@Entity
@Table(name = "tb_pedido")
public class Pedido implements Serializable {
	
	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY.AUTO) //auto incremento no banco
	@Column(name="idpedido")
	private Long id;
	private Double latitude; //armazenar geolocalização
	private Double longitude; //armazenar geolocalização
	
	private Instant moment; //Instante em que o pedido foi feito
	
	@Enumerated(EnumType.STRING) //Converter enum em String
	@ColumnDefault("'PENDENTE'") // setar valor default do status para PENDENTE
	private PedidoStatus status; //atributo da classe enum
	
	@ManyToMany(fetch=FetchType.EAGER) //Annotation de relacionamento de muitos pra muitos
	@JoinTable(name = "tb_pedido_bolo", // tabela de associação
	joinColumns = @JoinColumn(name = "pedido_id"), //chave estrangeira
	inverseJoinColumns = @JoinColumn(name = "bolo_id")) 
	//para nao repetir os bolos no mesmo pedido
	private Set<Bolo> bolos = new HashSet<>();
	
	
	@ManyToOne
	//muitos pedidos para uma avaliação
	//@JoinColumn(name="idavaliacao",nullable=false)
	private AvaliacaoPedido avaliacaopedido;
	
	
	@ManyToOne //muitos pedidos para um cancelamento
	//@JoinColumn(name="idcancelamento",nullable=false)
	private Cancelamento cancelamento;
		
	
	@ManyToOne 
	@JoinColumn(name="identregador", nullable=false)
	//muitos pedidos para um entregador
	private Entregador entregador;
	
	
	@ManyToOne
	@JoinColumn(name= "idcliente", nullable=false)
	// muitos pedidos para um entregador
	private Cliente cliente;
		
	
	
	public Pedido() {
		
	}
	

	public Pedido(Long id,Double latitude, Double longitude, Instant moment, PedidoStatus status,
			Set<Bolo> bolos, AvaliacaoPedido avaliacaopedido, Cancelamento cancelamento, Entregador entregador, Cliente cliente) {
		super();
		this.id = id;
		this.latitude = latitude;
		this.longitude = longitude;
		this.moment = moment;
		this.status = status;
		this.bolos = bolos;
		this.avaliacaopedido = avaliacaopedido;
		this.cancelamento = cancelamento;
		this.entregador = entregador;
		this.cliente = cliente;
	}


	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	
	public Double getLatitude() {
		return latitude;
	}

	public void setLatitude(Double latitude) {
		this.latitude = latitude;
	}

	public Double getLongitude() {
		return longitude;
	}

	public void setLongitude(Double longitude) {
		this.longitude = longitude;
	}

	public Instant getMoment() {
		return moment;
	}

	public void setMoment(Instant moment) {
		this.moment = moment;
	}

	public PedidoStatus getStatus() {
		return status;
	}

	public void setStatus(PedidoStatus status) {
		this.status = status;
	}

		
	public Set<Bolo> getBolos() {
		return bolos;
	}

	public void setBolos(Set<Bolo> bolos) {
		this.bolos = bolos;
	}
	
	

	public AvaliacaoPedido getAvaliacaopedido() {
		return avaliacaopedido;
	}


	public void setAvaliacaopedido(AvaliacaoPedido avaliacaopedido) {
		this.avaliacaopedido = avaliacaopedido;
	}
	
	

	public Cancelamento getCancelamento() {
		return cancelamento;
	}



	public void setCancelamento(Cancelamento cancelamento) {
		this.cancelamento = cancelamento;
	}
	
	

	public Entregador getEntregador() {
		return entregador;
	}


	public void setEntregador(Entregador entregador) {
		this.entregador = entregador;
	}
	
	
	public Cliente getCliente() {
		return cliente;
	}


	public void setCliente(Cliente cliente) {
		this.cliente = cliente;
	}


	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((id == null) ? 0 : id.hashCode());
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
		Pedido other = (Pedido) obj;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		return true;
	}
}