package com.example.demo.curso.boot.conversor;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;

import com.example.demo.curso.boot.domain.Cargo;
import com.example.demo.curso.boot.service.CargoService;

@Component
public class StringToCargoCoverssor implements Converter<String, Cargo> {

	@Autowired
	private CargoService service;
	
	@Override
	public Cargo convert(String text) {
		if(text.isEmpty()) {
			return null;	
		}
		
		Long id = Long.valueOf(text);
		
		return service.buscarPorId(id) ;
	}

}
