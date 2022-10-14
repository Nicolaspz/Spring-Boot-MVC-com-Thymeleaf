package com.example.demo.curso.boot.domain;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
@SuppressWarnings("serial")
@Entity
@Table(name = "CARGO")
public class Cargo extends AbstratEntity<Long> {
	 
	@NotBlank(message = "O nome do Cargo é Obrigatório. ")
	@Size(max = 60, message = "o nome do cargo deve conter no máximo 60 caracteres. ")
	@Column(name = "nome", nullable = false, unique = true, length = 60)
	private String nome;
	
	@NotNull(message = "Selecione o departamento relativo ao Cargo. ")
	@ManyToOne()
	@JoinColumn(name = "id_departamento_fk")
	private Departamento departamento;
	public String getNome() {
		return nome;
	}
	
	@OneToMany(mappedBy = "cargo")
	private List<Funcionario> funcionarios;
	
	
	public List<Funcionario> getFuncionarios() {
		return funcionarios;
	}
	public void setFuncionarios(List<Funcionario> funcionarios) {
		this.funcionarios = funcionarios;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	public Departamento getDepartamento() {
		return departamento;
	}
	public void setDepartamento(Departamento departamento) {
		this.departamento = departamento;
	}

}
