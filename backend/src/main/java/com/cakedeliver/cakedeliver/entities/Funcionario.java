package com.cakedeliver.cakedeliver.entities;

import java.io.Serializable;
import java.util.Date;
import javax.persistence.MappedSuperclass;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import com.fasterxml.jackson.annotation.JsonFormat;

	//@Entity
	//@Table(name = "tb_funcionario")
	@MappedSuperclass
	public abstract class Funcionario extends Usuario implements Serializable {

	private static final long serialVersionUID = -1L;
	
	@Temporal(TemporalType.DATE)
	@JsonFormat(pattern = "yyyy-MM-dd")
	private Date dataAdmissao;

	public Funcionario() {

	}

		
	public Funcionario(Date dataAdmissao) {
		super();
		this.dataAdmissao = dataAdmissao;
	}

	

	public Date getDataAdmissao() {
		return dataAdmissao;
	}

	public void setDataAdmissao(Date dataAdmissao) {
		this.dataAdmissao = dataAdmissao;
	}

}
