package com.registro.usuarios.repositorio;

import org.springframework.data.repository.PagingAndSortingRepository;
import com.registro.usuarios.entidades.Domicilio;

public interface DomicilioRepository extends PagingAndSortingRepository<Domicilio, Long>{

}
