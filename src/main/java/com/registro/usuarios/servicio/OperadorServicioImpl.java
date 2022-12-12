package com.registro.usuarios.servicio;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.registro.usuarios.entidades.Operador;
import com.registro.usuarios.repositorio.OperadorRepositorio;

@Service
public class OperadorServicioImpl implements OperadorServicio {

	@Autowired
	private OperadorRepositorio repositorio;

	@Override
	public List<Operador> listarTodosLosOperadores() {
		return repositorio.findAll();
	}

	@Override
	public Operador guardarOperador(Operador operador) {
		return repositorio.save(operador);
	}

	@Override
	public Operador obtenerOperadorPorId(Long id) {
		return repositorio.findById(id).get();
	}

	@Override
	public Operador actualizarOperador(Operador operador) {
		return repositorio.save(operador);
	}

	@Override
	public void eliminarOperador(Long id) {
		repositorio.deleteById(id);

	}

}
