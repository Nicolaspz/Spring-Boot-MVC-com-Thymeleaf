package com.example.demo.curso.boot.web.controller;

import java.util.List;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.example.demo.curso.boot.domain.Cargo;
import com.example.demo.curso.boot.domain.Departamento;
import com.example.demo.curso.boot.service.CargoService;
import com.example.demo.curso.boot.service.DepartamentoService;

@Controller
@RequestMapping("/cargos")
public class CargoController {
	@Autowired
	CargoService Cs;
	
	@Autowired
	DepartamentoService departamentoService;
	

	@RequestMapping("/cadastrar")
	public String Cadastrar(Cargo cargo) {
		return "cargo/cadastro";
	}
	
	@RequestMapping("/listar")
	public String Listar(ModelMap model) {
		model.addAttribute("cargo", Cs.buscarTodos());
		return "cargo/lista";
	}
	
	@PostMapping("/salvar")
	public String InserirCargo(Cargo cargo, RedirectAttributes attr) {
		Cs.salvar(cargo);
		attr.addFlashAttribute("success", "Cargo salvo com sucesso.");
		return "redirect:/cargos/cadastrar";
	}
	
	@ModelAttribute("departamentos")
	public List<Departamento> ListaDepartamentoTodos(){
		return departamentoService.buscarTodos();
	}
	
	@GetMapping("/editar/{id}")
	public String preEditar(@PathVariable("id") Long id, ModelMap model ) {
		model.addAttribute("cargo", Cs.buscarPorId(id));
		return "cargo/cadastro";
	}
	@PostMapping("/editar")
	public String Editar(Cargo cargo, RedirectAttributes attr) {
		Cs.editar(cargo);
		attr.addAttribute("success", "Cargo actualizado com sucesso.");
		return "cargo/cadastro";
	}
	@GetMapping("/excluir/{id}")
	public String Excluir(@PathVariable("id") Long id, RedirectAttributes attr ) {
		if(Cs.TemFuncionario(id)) {
			attr.addFlashAttribute("fail", "Cargo não excluido. Tem funcionário(s) vinculado(s).");
		}
		else {
			Cs.excluir(id);
			attr.addFlashAttribute("success", "Cargo excluido com sucesso.");
		}
		return "redirect:/cargos/listar";
	}
	
}
