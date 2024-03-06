package com.example.api_final.entities;

import java.sql.Date;
import java.time.LocalDate;

import javax.validation.constraints.FutureOrPresent;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.PastOrPresent;

import org.springframework.format.annotation.DateTimeFormat;

import jakarta.annotation.Nonnull;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;


@Table(name = "Citas")
@Entity
public class Cita {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id; 
	
	@FutureOrPresent
	private LocalDate fecha_hora; 
	
    @NotBlank(message = "El tipo de corte no puede estar vacío")
	private String tipo_de_corte; 
	 
	@NotBlank
	private String nombre_de_barbero;
	 
	@OneToOne
	@JoinColumn(name = "usuario_id", referencedColumnName = "id")
	private Usuario usuario; 
	
  
    
	
	
	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	

	public Usuario getUsario() {
		return usuario;
	}

	public void setUsario(Usuario usuario) {
		this.usuario = usuario;
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
	 
	 
	 
}
