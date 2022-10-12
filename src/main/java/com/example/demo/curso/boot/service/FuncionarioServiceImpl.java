package com.example.demo.curso.boot.service;

import java.time.LocalDate;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.example.demo.curso.boot.dao.FuncionarioDao;
import com.example.demo.curso.boot.domain.Funcionario;
@Transactional(readOnly = false) @Service
public class FuncionarioServiceImpl implements FuncionarioService{
	@Autowired
	private FuncionarioDao dao;

	@Override @Transactional(readOnly = false)
	public void salvar(Funcionario funcionario) {
		dao.save(funcionario);
		
	}

	@Override @Transactional(readOnly = false)
	public void editar(Funcionario funcionario) {
		dao.update(funcionario);
		
	}

	@Override @Transactional(readOnly = false)
	public void excluir(Long id) {
		dao.delete(id);
		
	}

	@Override @Transactional(readOnly = true)
	public Funcionario buscarPorId(Long id) {
		// TODO Auto-generated method stub
		return dao.findById(id);
	}

	@Override @Transactional(readOnly = true)
	public List<Funcionario> buscarTodos() {
		// TODO Auto-generated method stub
		return dao.findAll();
	}

	@Override
	public List<Funcionario> buscarPorNome(String nome) {
		// TODO Auto-generated method stub
		return dao.findByNome(nome);
	}

	@Override
	public List<Funcionario> BuscarPorCargo(Long id) {
		// TODO Auto-generated method stub
		return dao.findByCargoId(id);
	}

	@Override
	public List<Funcionario> buscarPorDatas(LocalDate entrada, LocalDate saida) {
		// TODO Auto-generated method stub
		return dao.findByDataEntradaDataSaida(entrada, saida);
	}

	

}
