package com.registro.usuarios.servicio;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.registro.usuarios.entidades.Operador;
import com.registro.usuarios.repositorio.OperadorRepositorio;

@Service
public class filtrosOperador {
	
	@Autowired
	private OperadorRepositorio operadorRepositorio;
	
	public List<Operador> listarTodosLosOperadores(String palabraclave) {
		if (palabraclave != null) {
			return operadorRepositorio.listarTodosLosOperadores(palabraclave);
			
		}
		return null;
	}

}
