package com.registro.usuarios.repositorio;

import org.springframework.data.repository.PagingAndSortingRepository;

import com.registro.usuarios.entidades.Empleado;

public interface EmpleadoRepository extends PagingAndSortingRepository<Empleado, Long>{

}
