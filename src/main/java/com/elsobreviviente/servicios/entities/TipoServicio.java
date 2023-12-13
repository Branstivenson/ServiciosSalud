package com.elsobreviviente.servicios.entities;

import java.util.ArrayList;
import java.util.List;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;

@Entity
@Table(name = "tipo_servicio")
public class TipoServicio{
	
	//Entidad creada automaticamente en la base de datos usando JPA
	//Para ello se uso la configuración en el application properties
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private String codigoTipoServicio;
    @Column(length = 10)
    private String nombreTipoServicio;
    
	public String getCodigoTipoServicio() {
		return codigoTipoServicio;
	}

	public void setCodigoTipoServicio(String codigoTipoServicio) {
		this.codigoTipoServicio = codigoTipoServicio;
	}

	public String getNombreTipoServicio() {
		return nombreTipoServicio;
	}

	public void setNombreTipoServicio(String nombreTipoServicio) {
		this.nombreTipoServicio = nombreTipoServicio;
	}

    
    
    // Getters and setters

    // You may want to add additional methods or annotations as needed
}
