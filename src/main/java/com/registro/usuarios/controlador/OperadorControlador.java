package com.registro.usuarios.controlador;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import com.registro.usuarios.entidades.Operador;
import com.registro.usuarios.servicio.OperadorServicio;

@Controller
public class OperadorControlador {

	@Autowired
	private OperadorServicio servicio;

	@GetMapping({ "/operadores", "/" })
	public String listaroperadores(Model modelo) {
	
		modelo.addAttribute("operadores", servicio.listarTodosLosOperadores());
		return "operadores"; // nos retorna al archivo estudiantes
	}

	@GetMapping("/operadores/nuevo")
	public String mostrarFormularioDeRegistrtarOperador(Model modelo) {
		Operador operador = new Operador();
		modelo.addAttribute("operador", operador);
		return "crear_operador";
	}

	@PostMapping("/operadores")
	public String guardarOperador(@ModelAttribute("operador") Operador operador) {
		servicio.guardarOperador(operador);
		return "redirect:/operadores";
	}

	@GetMapping("/operadores/editar/{id}")
	public String mostrarFormularioDeEditar(@PathVariable Long id, Model modelo) {
		modelo.addAttribute("operador", servicio.obtenerOperadorPorId(id));
		return "editar_operador";
	}

	@PostMapping("/operadores/{id}")
	public String actualizarOperador(@PathVariable Long id, @ModelAttribute("operador") Operador operador,
			Model modelo) {
		Operador operadorExistente = servicio.obtenerOperadorPorId(id);
		operadorExistente.setId(id);
		operadorExistente.setNombre(operador.getNombre());
		operadorExistente.setApellido(operador.getApellido());
		operadorExistente.setEmail(operador.getEmail());
		operadorExistente.setNumero(operador.getNumero());
		operadorExistente.setSalario(operador.getSalario());

		servicio.actualizarOperador(operadorExistente);
		return "redirect:/operadores";
	}

	@GetMapping("/operadores/{id}")
	public String eliminarOperador(@PathVariable Long id) {
		servicio.eliminarOperador(id);
		return "redirect:/operadores";
	}
}
