package com.cakedeliver.cakedeliver.entities;

import java.io.Serializable;
import java.util.Date;
import javax.persistence.Column;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.MappedSuperclass;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import com.cakedeliver.cakedeliver.enums.GeneroStatus;
import com.fasterxml.jackson.annotation.JsonFormat;

 	//para a heranças das classes que herdarao

	//@Embeddable
	@MappedSuperclass
	//@Inheritance(strategy=InheritanceType.TABLE_PER_CLASS)
	public abstract class Usuario implements Serializable {
		
	private static final long serialVersionUID = 1L;
			
	@Column(length = 50)
	@NotBlank(message = "Preencha com o Nome do Usuário")
	@Size(min = 2, max = 50, message = "O Nome do Usuário deve ter entre 2 e 50 caracteres")
	private String nome;
			
	@NotNull(message = "O Usuário deve possuir no minímo um número de telefone")
	private String telefone;
	
	@Column(length = 11, unique = true)
	@Size(min = 11, max = 11, message = "O CPF do Usuário deve conter 11 digitos")
	private String cpf;
	
	@Temporal(TemporalType.DATE) //salva somente data no banco de dados
	@JsonFormat(pattern = "yyyy-MM-dd")
	private Date dataNascimento;
	
	@Enumerated(EnumType.STRING) //converte o enum em String	
	private GeneroStatus genero;
	
	public Usuario() {}

	public Usuario(String nome, String telefone, String cpf, String endereco, Date dataNascimento, GeneroStatus genero) {
		super();
		this.nome = nome;
		this.telefone = telefone;
		this.cpf = cpf;
		this.dataNascimento = dataNascimento;
		this.genero = genero;
	}

	
	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getTelefone() {
		return telefone;
	}

	public void setTelefone(String telefone) {
		this.telefone = telefone;
	}

	public String getCpf() {
		return cpf;
	}

	public void setCpf(String cpf) {
		this.cpf = cpf;
	}

	
	public Date getDataNascimento() {
		return dataNascimento;
	}

	public void setDataNascimento(Date dataNascimento) {
		this.dataNascimento = dataNascimento;
	}

	public GeneroStatus getGenero() {
		return genero;
	}

	public void setGenero(GeneroStatus genero) {
		this.genero = genero;
	}

	

	
}