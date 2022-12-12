package com.registro.usuarios.controlador;

import java.util.Map;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import org.springframework.web.bind.annotation.RequestParam;

import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.registro.usuarios.entidades.Empleado;
import com.registro.usuarios.servicio.EmpleadoService;
import com.registro.usuarios.util.paginacion.PageRender;


@Controller
public class EmpleadoController5 {

	@Autowired
	private EmpleadoService empleadoService;
	
	@GetMapping("/ver5/{id}")
	public String verDetallesDelEmpleado(@PathVariable(value = "id") Long id,Map<String,Object> modelo,RedirectAttributes flash) {
		Empleado empleado = empleadoService.findOne(id);
		if(empleado == null) {
			flash.addFlashAttribute("error", "El producto no existe en la base de datos");
			return "redirect:/listar5";
		}
		
		modelo.put("empleado",empleado);
		modelo.put("titulo", "Detalles del producto " + empleado.getNombre());
		return "ver5";
	}
	
	@GetMapping({"/","/listar5",""})
	public String listarEmpleados(@RequestParam(name = "page",defaultValue = "0") int page,Model modelo) {
		Pageable pageRequest = PageRequest.of(page, 4);
		Page<Empleado> empleados = empleadoService.findAll(pageRequest);
		PageRender<Empleado> pageRender = new PageRender<>("/listar", empleados);
		
		modelo.addAttribute("titulo","Listado de empleados");
		modelo.addAttribute("empleados",empleados);
		modelo.addAttribute("page", pageRender);
		
		return "listar5";
	}
	
}
