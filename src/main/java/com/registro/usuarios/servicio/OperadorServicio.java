package com.registro.usuarios.servicio;

import java.util.List;

import com.registro.usuarios.entidades.Operador;

public interface OperadorServicio {

	public List<Operador> listarTodosLosOperadores();
	
	public Operador guardarOperador(Operador operador);
	
	public Operador obtenerOperadorPorId(Long id);
	
	public Operador actualizarOperador(Operador operador);
	
	public void eliminarOperador(Long id);
}
