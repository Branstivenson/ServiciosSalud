package com.elsobreviviente.servicios.services;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.elsobreviviente.servicios.dto.ServicioDto;
import com.elsobreviviente.servicios.dto.ServicioNewDto;
import com.elsobreviviente.servicios.entities.Servicio;
import com.elsobreviviente.servicios.exception.ErrorDto;
import com.elsobreviviente.servicios.persistence.ServicioRepository;
import com.elsobreviviente.servicios.persistence.TipoServicioRepository;
import com.elsobreviviente.servicios.dto.ServicioIdDto;

@Service
public class ServicioService {


	@Autowired
	ServicioRepository servicioRepository;
	
	@Autowired
	TipoServicioRepository tiposervicioRepository;
	
	public List <Servicio> findByNombreServicioContainingIgnoreCase(String cadena){
		return servicioRepository.findByNombreServicioContainingIgnoreCase(cadena);
	}
	
	
	public List <Servicio> findByNombreServicioStartingWithIgnoreCase(String cadena){
		return servicioRepository.findByNombreServicioStartingWithIgnoreCase(cadena);
	}
	
	/*
	 * convertir entity a dto
	 * */
	public List <ServicioDto> findByNombreServico(String cadena){
		List <ServicioDto> listaServiciosDto = new ArrayList<>();
		List <Servicio> listaServicios = servicioRepository.findByNombreServicioContainingIgnoreCase(cadena);
		for(Servicio servicio : listaServicios) {
			ServicioDto servicioDto=new ServicioDto(servicio.getIdCodigoServicio(),servicio.getCodigoServicio(),servicio.getNombreServicio());
			listaServiciosDto.add( servicioDto);
		}
		return listaServiciosDto;
	}
	
	
	public ServicioDto almacenarServicio (ServicioDto servicioDto) {
		//convertir dto a entity
		Servicio servicio=new Servicio();
		servicio.setCodigoServicio(servicioDto.getCodigoServicio());
		servicio.setNombreServicio(servicioDto.getNombreServicio());
		servicioRepository.save(servicio);
		return servicioDto;
	}
	
	
	public ServicioNewDto almacenarServicioV2 (ServicioNewDto servicioNewDto) {
		//convertir dto a entity
		Servicio servicio=new Servicio();
		servicio.setCodigoServicio(servicioNewDto.getCodigoServicio());
		servicio.setNombreServicio(servicioNewDto.getNombreServicio());
		servicio.setTipoServicio(tiposervicioRepository.getReferenceById(servicioNewDto.getCodigoTipoServicio()));
		servicioRepository.save(servicio);
		return servicioNewDto;
	}
	
	
	public ServicioNewDto actualizarServicio ( ServicioNewDto servicioNewDto ) {
		Servicio servicio =  servicioRepository.findByIdCodigoServicio( servicioNewDto.getIdCodigoServicio());
		
		if ( servicio != null) {
			servicio.setCodigoServicio( servicioNewDto.getCodigoServicio()  );  //set
			servicio.setNombreServicio( servicioNewDto.getNombreServicio() );   //set
			servicio.setTipoServicio   (  tiposervicioRepository.getReferenceById( servicioNewDto.getCodigoTipoServicio() )  );   
			servicioRepository.save( servicio ); //persistiendo
			return servicioNewDto;
		} else {
			return null;
		}	
	}
	
	
	public boolean eliminarServicio ( ServicioIdDto servicioIdDto ) {
		
		Servicio servicio  = servicioRepository.findByIdCodigoServicio ( servicioIdDto.getIdCodigoServicio());
		if ( servicio != null) {
			servicioRepository.delete(servicio);
			return true;
		} else {
			return false;
		}
		
	}
	
	
	public ErrorDto eliminarServicioV2 ( ServicioIdDto servicioIdDto ) {
		
		Servicio servicio  = servicioRepository.findByIdCodigoServicio ( servicioIdDto.getIdCodigoServicio());
		if ( servicio != null) {
			servicioRepository.delete(servicio);
			return new ErrorDto(" servicio eliminado" );
			
		} else {
			return new ErrorDto ("servicio no existe");
		}
		
	}
}
