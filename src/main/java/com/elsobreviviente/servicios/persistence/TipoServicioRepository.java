package com.elsobreviviente.servicios.persistence;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.elsobreviviente.servicios.entities.TipoServicio;

public interface TipoServicioRepository extends JpaRepository<TipoServicio, String>{
	
}
