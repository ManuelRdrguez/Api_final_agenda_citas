package com.example.api_final.entities;

import java.time.LocalDate;

import javax.validation.constraints.FutureOrPresent;
import javax.validation.constraints.PastOrPresent;

import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;


@Entity
public class Reserva {
	   @Id
	    @GeneratedValue(strategy = GenerationType.IDENTITY)
	    private Long id;

	   @Enumerated(EnumType.STRING)
	   private EstadoCita estadoReserva;

	   @ManyToOne
	    @JoinColumn(name = "usuario_id")
	    private Usuario usuario;

	    @ManyToOne
	    @JoinColumn(name = "cita_id")
	    private Cita cita;

	    @PastOrPresent
	    private LocalDate fechaReserva;
	    @FutureOrPresent
	    private LocalDate fechaExpiracion;
	    @FutureOrPresent
	    private LocalDate fechaRecogida;
	    @FutureOrPresent
	    private LocalDate fechaCancelada;
	    @FutureOrPresent
	    private LocalDate fechaDevolucion;
		public Long getId() {
			return id;
		}
		public void setId(Long id) {
			this.id = id;
		}
		public EstadoCita getEstadoReserva() {
			return estadoReserva;
		}
		public void setEstadoReserva(EstadoCita estadoReserva) {
			this.estadoReserva = estadoReserva;
		}
		public Usuario getUsuario() {
			return usuario;
		}
		public void setUsuario(Usuario usuario) {
			this.usuario = usuario;
		}
		public Cita getCita() {
			return cita;
		}
		public void setCita(Cita cita) {
			this.cita = cita;
		}
		public LocalDate getFechaReserva() {
			return fechaReserva;
		}
		public void setFechaReserva(LocalDate fechaReserva) {
			this.fechaReserva = fechaReserva;
		}
		public LocalDate getFechaExpiracion() {
			return fechaExpiracion;
		}
		public void setFechaExpiracion(LocalDate fechaExpiracion) {
			this.fechaExpiracion = fechaExpiracion;
		}
		public LocalDate getFechaRecogida() {
			return fechaRecogida;
		}
		public void setFechaRecogida(LocalDate fechaRecogida) {
			this.fechaRecogida = fechaRecogida;
		}
		public LocalDate getFechaCancelada() {
			return fechaCancelada;
		}
		public void setFechaCancelada(LocalDate fechaCancelada) {
			this.fechaCancelada = fechaCancelada;
		}
		public LocalDate getFechaDevolucion() {
			return fechaDevolucion;
		}
		public void setFechaDevolucion(LocalDate fechaDevolucion) {
			this.fechaDevolucion = fechaDevolucion;
		}
	    
	    
	
	    
	    
	
}
