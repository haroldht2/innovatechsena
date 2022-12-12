package com.registro.usuarios.controlador;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import java.util.List;
import com.registro.usuarios.modelo.Usuario;
import com.registro.usuarios.servicio.UsuarioServicio;

@Controller
public class usuariocontrolador {
	@Autowired
	private UsuarioServicio usuarioservicio;
	
	@GetMapping(path = "/clientes")
	public String getusuario(Model model) {
		List<Usuario> usuario = usuarioservicio.listarUsuarios();
		model.addAttribute("usuarios", usuarioservicio.listarUsuarios());
		return "clientes";
	}

}