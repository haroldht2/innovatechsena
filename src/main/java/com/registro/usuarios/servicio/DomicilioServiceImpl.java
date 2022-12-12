package com.registro.usuarios.servicio;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.registro.usuarios.entidades.Domicilio;
import com.registro.usuarios.repositorio.DomicilioRepository;

@Service
public class DomicilioServiceImpl implements DomicilioService {

	@Autowired
	private DomicilioRepository domicilioRepository;

	@Override
	public List<Domicilio> listarTodosLosDomicilios() {
		return (List<Domicilio>) domicilioRepository.findAll();
	}

	@Override
	public Domicilio guardarDomicilio(Domicilio domicilio) {
		return domicilioRepository.save(domicilio);
	}

	@Override
	public Domicilio obtenerDomicilioPorId(Long id) {
		return domicilioRepository.findById(id).get();
	}

	@Override
	public Domicilio actualizarDomicilio(Domicilio domicilio) {
		return domicilioRepository.save(domicilio);
	}

	@Override
	public void eliminarDomicilio(Long id) {
		domicilioRepository.deleteById(id);

	}

}
