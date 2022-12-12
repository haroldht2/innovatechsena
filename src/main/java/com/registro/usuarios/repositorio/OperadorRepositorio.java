package com.registro.usuarios.repositorio;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.registro.usuarios.entidades.Operador;


@Repository
public interface OperadorRepositorio extends JpaRepository<Operador, Long>{

	
	@Query("SELECT o FROM Operador o WHERE o.nombre LIKE %?1%")
	public List <Operador> listarTodosLosOperadores(String palabraclave);
	
}
