package com.registro.usuarios.controlador;

import java.io.IOException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletResponse;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.support.SessionStatus;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.registro.usuarios.entidades.Empleado;
import com.registro.usuarios.servicio.EmpleadoService;
import com.registro.usuarios.util.paginacion.PageRender;
import com.registro.usuarios.util.reportes.EmpleadoExporterExcel;
import com.registro.usuarios.util.reportes.EmpleadoExporterPDF;
import com.lowagie.text.DocumentException;

@Controller
public class EmpleadoController7 {
	
	

	@Autowired
	private EmpleadoService empleadoService;
	
	@GetMapping("/ver7/{id}")
	public String verDetallesDelEmpleado(@PathVariable(value = "id") Long id,Map<String,Object> modelo,RedirectAttributes flash) {
		Empleado empleado = empleadoService.findOne(id);
		if(empleado == null) {
			flash.addFlashAttribute("error", "El empleado no existe en la base de datos");
			return "redirect:/listar7";
		}
		
		modelo.put("empleado",empleado);
		modelo.put("titulo", "Detalles del empleado " + empleado.getNombre());
		return "ver7";
	}
	
	@GetMapping({"/listar7",""})
	public String listarEmpleados(@RequestParam(name = "page",defaultValue = "0") int page,Model modelo) {
		Pageable pageRequest = PageRequest.of(page, 4);
		Page<Empleado> empleados = empleadoService.findAll(pageRequest);
		PageRender<Empleado> pageRender = new PageRender<>("/listar", empleados);
		
		modelo.addAttribute("titulo","Listado de empleados");
		modelo.addAttribute("empleados",empleados);
		modelo.addAttribute("page", pageRender);
		
		return "listar7";
	}
	@PostMapping("/form7")
	public String guardarEmpleado(@Valid Empleado empleado,BindingResult result,Model modelo,RedirectAttributes flash,SessionStatus status) {
		if(result.hasErrors()) {
			modelo.addAttribute("titulo", "Registro de cliente");
			return "form7";
		}
		
		
		String mensaje = (empleado.getId() != null) ? "El empleado ha sido editato con exito" : "Empleado registrado con exito";
		
		empleadoService.save(empleado);
		status.setComplete();
		flash.addFlashAttribute("success", mensaje);
		return "redirect:/listar7";
	}
	
	
	@GetMapping("/form7/{id}")
	public String editarEmpleado(@PathVariable(value = "id") Long id,Map<String, Object> modelo,RedirectAttributes flash) {
		Empleado empleado = null;
		if(id > 0) {
			empleado = empleadoService.findOne(id);
			if(empleado == null) {
				flash.addFlashAttribute("error", "El ID del empleado no existe en la base de datos");
				return "redirect:/listar7";
			}
		}
		else {
			flash.addFlashAttribute("error", "El ID del empleado no puede ser cero");
			return "redirect:/listar7";
		}
		
		modelo.put("empleado",empleado);
		modelo.put("titulo", "Edición de empleado");
		return "/form7";
	}
	
	@GetMapping("/eliminar7/{id}")
	public String eliminarunProducto(@PathVariable Long id) {
		empleadoService.delete(id);
		return "redirect:/listar7";
	}
	
}
