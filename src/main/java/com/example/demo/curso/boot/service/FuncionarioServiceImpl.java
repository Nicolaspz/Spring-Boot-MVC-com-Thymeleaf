package com.example.demo.curso.boot.service;

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

}
