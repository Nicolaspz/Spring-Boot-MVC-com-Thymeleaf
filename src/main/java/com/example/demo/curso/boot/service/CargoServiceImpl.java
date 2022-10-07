package com.example.demo.curso.boot.service;

import java.util.List;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.example.demo.curso.boot.dao.CargoDao;
import com.example.demo.curso.boot.domain.Cargo;
@Service @Transactional(readOnly = false)
public class CargoServiceImpl implements CargoService {
	private CargoDao dao;
	

	@Override @Transactional(readOnly = false)
	public void salvar(Cargo cargo) {
		dao.save(cargo);
		
	}

	@Override @Transactional(readOnly = false)
	public void editar(Cargo cargo) {
		dao.update(cargo);
		
	}

	@Override @Transactional(readOnly = false)
	public void excluir(Long id) {
		dao.delete(id);
		
	}

	@Override @Transactional(readOnly = true)
	public Cargo buscarPorId(Long id) {
		// TODO Auto-generated method stub
		return dao.findById(id);
	}

	@Override @Transactional(readOnly = true)
	public List<Cargo> buscarTodos() {
		// TODO Auto-generated method stub
		return dao.findAll();
	}

}
