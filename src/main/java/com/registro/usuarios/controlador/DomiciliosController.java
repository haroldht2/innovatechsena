package com.registro.usuarios.controlador;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import com.registro.usuarios.entidades.Domicilio;
import com.registro.usuarios.servicio.DomicilioService;


@Controller
public class DomiciliosController {
	@Autowired
	private DomicilioService servicio;

	@GetMapping({ "/domicilios", "/" })
	public String listardomicilios(Model modelo) {
		modelo.addAttribute("domicilios", servicio.listarTodosLosDomicilios());
		return "domicilios"; // nos retorna al archivo estudiantes
	}

	@GetMapping("/domicilios/nuevo")
	public String mostrarFormularioDeRegistrtarDomicilio(Model modelo) {
		Domicilio domicilio = new Domicilio();
		modelo.addAttribute("domicilio", domicilio);
		return "crear_domicilio";
	}

	@PostMapping("/domicilios")
	public String guardarDomicilio(@ModelAttribute("domicilio") Domicilio domicilio) {
		servicio.guardarDomicilio(domicilio);
		return "redirect:/domicilios";
	}

	@GetMapping("/domicilios/editar/{id}")
	public String mostrarFormularioDeEditar(@PathVariable Long id, Model modelo) {
		modelo.addAttribute("domicilio", servicio.obtenerDomicilioPorId(id));
		return "editar_domicilio";
	}

	@PostMapping("/domicilios/{id}")
	public String actualizarDomicilio(@PathVariable Long id, @ModelAttribute("domicilio") Domicilio domicilio,
			Model modelo) {
		Domicilio domicilioExistente = servicio.obtenerDomicilioPorId(id);
		domicilioExistente.setId(id);
		domicilioExistente.setNombre(domicilio.getNombre());
		domicilioExistente.setApellido(domicilio.getApellido());
		domicilioExistente.setDireccion(domicilio.getDireccion());
		domicilioExistente.setNumero(domicilio.getNumero());
		

		servicio.actualizarDomicilio(domicilioExistente);
		return "redirect:/domicilios";
	}

	@GetMapping("/domicilios/{id}")
	public String eliminarDomicilio(@PathVariable Long id) {
		servicio.eliminarDomicilio(id);
		return "redirect:/domicilios";
	}
}
