package com.example.api_final.entities;

import java.sql.Date;

import org.springframework.format.annotation.DateTimeFormat;

import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import jakarta.validation.constraints.NotNull;

@Table(name = "Citas")
@Entity
public class Cita {
	 @NotNull
	 @DateTimeFormat(pattern = "yyyy-MM-dd'T'HH:mm")
	private Date fehca_hora; 
	 
	 @NotNull
	private String tipo_de_corte; 
	 
	 @NotNull
	private String nombre_de_barbero;

	public Date getFehca_hora() {
		return fehca_hora;
	}

	public void setFehca_hora(Date fehca_hora) {
		this.fehca_hora = fehca_hora;
	}

	public String getTipo_de_corte() {
		return tipo_de_corte;
	}

	public void setTipo_de_corte(String tipo_de_corte) {
		this.tipo_de_corte = tipo_de_corte;
	}

	public String getNombre_de_barbero() {
		return nombre_de_barbero;
	}

	public void setNombre_de_barbero(String nombre_de_barbero) {
		this.nombre_de_barbero = nombre_de_barbero;
	} 
	 
	 //GETTERS AND SETTERS 
	 
	 
}
