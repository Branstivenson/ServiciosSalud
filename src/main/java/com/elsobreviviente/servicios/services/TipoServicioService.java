package com.elsobreviviente.servicios.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.elsobreviviente.servicios.persistence.TipoServicioRepository;

@Service
public class TipoServicioService {
	
	@Autowired
	TipoServicioRepository tipoServicioRepository;
}
