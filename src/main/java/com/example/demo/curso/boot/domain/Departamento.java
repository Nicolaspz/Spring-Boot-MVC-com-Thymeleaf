package com.example.demo.curso.boot.domain;

import java.util.List;

import javax.persistence.*;


@SuppressWarnings("serial")
@Entity
@Table(name = "DEPARTAMENTOS")
public class Departamento extends AbstratEntity<Long> {
	
	@Column(name = "nome", nullable = false, unique = true, length = 60)
	String nome;

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}
	
	@OneToMany(mappedBy = "departamento")
	private List<Cargo> cargos;

	public List<Cargo> getCargos() {
		return cargos;
	}

	public void setCargos(List<Cargo> cargos) {
		this.cargos = cargos;
	}
		
	

}
