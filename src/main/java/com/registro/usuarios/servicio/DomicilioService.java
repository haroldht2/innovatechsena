package com.registro.usuarios.servicio;

import java.util.List;

import com.registro.usuarios.entidades.Domicilio;


public interface DomicilioService {

	public List<Domicilio> listarTodosLosDomicilios();
	
	public Domicilio guardarDomicilio(Domicilio domicilio);
	
	public Domicilio obtenerDomicilioPorId(Long id);
	
	public Domicilio actualizarDomicilio(Domicilio domicilio);
	
	public void eliminarDomicilio(Long id);
}
