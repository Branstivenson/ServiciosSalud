package com.elsobreviviente.servicios.entities;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

@Entity
@Table(name = "servicio")
public class Servicio {

	//Entidad creada automaticamente en la base de datos usando JPA
	//Para ello se uso la configuración en el application properties
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idCodigoServicio;
    @Column(length = 50)
    private String codigoServicio;
    
    private String nombreServicio;

    @ManyToOne
    @JoinColumn(name = "codigo_tipo_servicio")
    private TipoServicio tipoServicio;

	public Long getIdCodigoServicio() {
		return idCodigoServicio;
	}

	public void setIdCodigoServicio(Long idCodigoServicio) {
		this.idCodigoServicio = idCodigoServicio;
	}

	public String getCodigoServicio() {
		return codigoServicio;
	}

	public void setCodigoServicio(String codigoServicio) {
		this.codigoServicio = codigoServicio;
	}

	public String getNombreServicio() {
		return nombreServicio;
	}

	public void setNombreServicio(String nombreServicio) {
		this.nombreServicio = nombreServicio;
	}

	public TipoServicio getTipoServicio() {
		return tipoServicio;
	}

	public void setTipoServicio(TipoServicio tipoServicio) {
		this.tipoServicio = tipoServicio;
	}

}
