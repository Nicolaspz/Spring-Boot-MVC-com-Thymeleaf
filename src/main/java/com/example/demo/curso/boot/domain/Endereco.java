package com.example.demo.curso.boot.domain;

import javax.persistence.*;

@SuppressWarnings("serial")
@Entity
@Table(name = "ENDERECOS")
public class Endereco extends AbstratEntity<Long> {
   
	@Column(nullable = false)
	private String logradoro;
	
	@Column(nullable = false)
	private String bairro;
	
	@Column(nullable = false)
	private String cidade;
	@Column(nullable = false, length = 2)
	@Enumerated(EnumType.STRING) // define o tipo de dados a ser salvo na Bd
	private UF uf;
	
	@Column(nullable = false)
	private String cep;
	
	@Column(nullable = false)
	private String numero;
	
	
	private String complemento;


	public String getLogradoro() {
		return logradoro;
	}


	public void setLogradoro(String logradoro) {
		this.logradoro = logradoro;
	}


	public String getBairro() {
		return bairro;
	}


	public void setBairro(String bairro) {
		this.bairro = bairro;
	}


	public String getCidade() {
		return cidade;
	}


	public void setCidade(String cidade) {
		this.cidade = cidade;
	}


	public UF getUf() {
		return uf;
	}


	public void setUf(UF uf) {
		this.uf = uf;
	}


	public String getCep() {
		return cep;
	}


	public void setCep(String cep) {
		this.cep = cep;
	}


	public String getNumero() {
		return numero;
	}


	public void setNumero(String numero) {
		this.numero = numero;
	}


	public String getComplemento() {
		return complemento;
	}


	public void setComplemento(String complemento) {
		this.complemento = complemento;
	}
	
}
