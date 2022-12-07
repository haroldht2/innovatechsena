package com.registro.usuarios.controlador;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;


@Controller
public class EstilosControl {

	@GetMapping("/index")
	public String index() {
		return "index";
	}
	
	@GetMapping("/operador")
	public String operador() {
		return "operador";
	}
	
	

	@GetMapping("/userForm")
	public String userForm() {
		return "user-form/user-view";
	}
	

	@GetMapping("/Cliente/caballero")
	public String caballero() {
		return "Cliente/caballero";
	}
	@GetMapping("/Cliente/dama")
	public String dama() {
		return "Cliente/dama";
	}
	@GetMapping("/Cliente/niño")
	public String niño() {
		return "Cliente/niño";
	}
	@GetMapping("/Cliente/niña")
	public String niña() {
		return "Cliente/niña";
	}
	
	@GetMapping("/Cliente/compras")
	public String compras() {
		return "Cliente/compras";
	}
	
	
	
	
	@GetMapping("/Operador/domicilio")
	public String domicilio() {
		return "Operador/domicilio";
	}
	@GetMapping("/Operador/agregarproducto")
	public String agregarproducto() {
		return "Operador/agregarproducto";
	}
	@GetMapping("/Operador/informe")
	public String informe() {
		return "Operador/informe";
	}
	@GetMapping("/Operador/asignarrepartidor")
	public String asignarrepartidor() {
		return "Operador/asignarrepartidor";
	}
	
	
	
	
	
	@GetMapping("/Administrador/addproducto")
	public String addproducto() {
		return "Administrador/addproducto";
		
	
	}
	@GetMapping("/Administrador/vistaproducto")
	public String vistaproducto() {
		return "Administrador/vistaproducto";
	}
	
	@GetMapping("/Administrador/listaventas")
	public String listaventas() {
		return "Administrador/listaventas";
	}
	
	@GetMapping("/Administrador/clientes")
	public String clientes() {
		return "Administrador/clientes";
	}

	@GetMapping("/static/img/logo")
	public String logo() {
		return "static/img/logo";
	}

	

	
	
	
}