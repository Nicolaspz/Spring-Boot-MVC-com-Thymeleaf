package com.example.demo.curso.boot.dao;

import java.util.List;

import com.example.demo.curso.boot.domain.Cargo;


public interface CargoDao {
	void update(Cargo cargo);
	void save(Cargo cargo);
	void delete(Cargo cargo);
	
	Cargo findById(Long id);
	
	List<Cargo> findAll();
}
