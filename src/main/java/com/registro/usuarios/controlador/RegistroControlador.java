package com.registro.usuarios.controlador;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;


@Controller
public class RegistroControlador {

	
	@GetMapping("/login")
	public String iniciarSesion() {
		return "login";
	}
	
	
	@GetMapping("/principal")
	public String interfas() {
		return "principal";
	}
	
	@GetMapping("/Operador/dashboard")
	public String operadorHome() {
		return "Operador/dashboard";
	}
	
	@GetMapping("/Administrador/dashboard")
	public String adminHome() {
		return "Administrador/dashboard";
	}
}
