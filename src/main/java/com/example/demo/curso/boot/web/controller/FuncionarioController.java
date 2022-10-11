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
import com.example.demo.curso.boot.domain.Funcionario;
import com.example.demo.curso.boot.domain.UF;
import com.example.demo.curso.boot.service.CargoService;
import com.example.demo.curso.boot.service.FuncionarioService;

@Controller
@RequestMapping("/funcionarios")
public class FuncionarioController {
	@Autowired
	FuncionarioService funcionarioService;
	@Autowired
	CargoService cargoService;
	
	
	@RequestMapping("/cadastrar")
	public String Cadastrar(Funcionario funcionario) {
		return "funcionario/cadastro";
	}
	
	@RequestMapping("/listar")
	public String Listar(ModelMap model) {
		model.addAttribute("funcionario", funcionarioService.buscarTodos());
		return "funcionario/lista";
	}
	
	@PostMapping("/salvar")
	public String salvar(Funcionario funcionario, RedirectAttributes attr) {
		funcionarioService.salvar(funcionario);
		attr.addFlashAttribute("success", "funcionário cadstrado com sucesso");
		return "redirect:/funcionarios/cadastrar";
	}
	@PostMapping("/eliminar/{id}")
	public String exluir(@PathVariable("id") Long id, RedirectAttributes attr) {
		funcionarioService.excluir(id);
		attr.addFlashAttribute("success", "funcionário exluido");
		return "redirect:/funcionarios/listar";
	}
	@GetMapping("/editar/{id}")
	public String PreEditar(@PathVariable("id") Long id,ModelMap model) {
		
		model.addAttribute("funcionario", funcionarioService.buscarPorId(id));
		return "/funcionario/cadastro";
	}
	
	@PostMapping("/editar")
	public String Editar(Funcionario funcionario, RedirectAttributes attr) {
		funcionarioService.editar(funcionario);
		attr.addFlashAttribute("success", "Funcionário adicionado com sucesso.");
		
		return "/funcionario/cadastro";
	}
	
	@ModelAttribute("cargos")
	public List<Cargo> getCargo(){
		return cargoService.buscarTodos();
		}
	
	@ModelAttribute("ufs")
	public UF[] getUFs(){
		return UF.values();
		}
	
}
