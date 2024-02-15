package com.example.api_final.service.impl;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.api_final.entities.Cita;
import com.example.api_final.entities.EstadoCita;
import com.example.api_final.entities.Reserva;
import com.example.api_final.repository.CitaRepository;
import com.example.api_final.repository.ReservaRepository;
import com.example.api_final.repository.UserRepository;
import com.example.api_final.service.ReservaService;

import jakarta.transaction.Transactional;

@Service
public class ReservaCitaImpl implements ReservaService{
	 @Autowired
	    private ReservaRepository reservaRepositorio;

	    @Autowired
	    private CitaRepository citaRepositorio;

	    @Autowired
	    private UserRepository usuarioRepositorio;

	    @Override
	    @Transactional
	    public Reserva crearReserva(Long libroId, Long usuarioId, String nombre_barbero, LocalDate fechaReserva, LocalDate fechaExpiracion) {
	    
 
	    	
	    	// Verificar si el libro existe y está disponible para reserva
	        Libro libro = libroRepositorio.findById(libroId)
	                        .orElseThrow(() -> new LibroNotFoundException("Libro no encontrado"));

	        if (!esLibroDisponibleParaReserva(libroId)) {
	            throw new IllegalStateException("El libro no está disponible para reserva");
	        }

	        // Verificar si el usuario existe
	        Usuario usuario = usuarioRepositorio.findById(usuarioId)
	                        .orElseThrow(() -> new UserNotFoundException("Usuario no encontrado"));

	   	 // Verifica si ya existe una reserva pendiente para el mismo libro y usuario
	        boolean reservaExistente = reservaRepositorio.existsByLibroAndUsuarioAndEstadoReserva(
	                libro, usuario, EstadoReserva.PENDIENTE);

	        if (reservaExistente) {
	            // Lanza una excepción o maneja el caso como consideres necesario
	            throw new IllegalStateException("Ya existe una reserva pendiente para este libro y usuario.");
	        }
	        
	        
	        // Crear la nueva reserva
	        Reserva reserva = new Reserva();
	        reserva.setLibro(libro);
	        reserva.setUsuario(usuario);
	        reserva.setFechaReserva(fechaReserva);
	        reserva.setFechaExpiracion(fechaExpiracion);
	        reserva.setEstadoReserva(EstadoReserva.PENDIENTE); // O el estado inicial que corresponda

	        // Guardar la reserva en la base de datos
	        return reservaRepositorio.save(reserva);
	    }

		@Override
		public Cita crearReserva(Long citaId, Long usuarioId, String nombre_barbero, LocalDate fechaReserva,
				LocalDate fechaExpiracion) {
			// TODO Auto-generated method stub
			return null;
		}

		@Override
		public Cita cancelarReserva(Long citaId) {
			// TODO Auto-generated method stub
			return null;
		}

		@Override
		public Cita actualizarEstadoReserva(Long citaId, EstadoCita nuevoEstado) {
			// TODO Auto-generated method stub
			return null;
		}

		@Override
		public Optional<Cita> obtenerReservaPorId(Long usarioId) {
			// TODO Auto-generated method stub
			return Optional.empty();
		}

		@Override
		public List<Cita> listarTodasLasReservas() {
			// TODO Auto-generated method stub
			return null;
		}

		@Override
		public List<Cita> listarReservasPorUsuario(Long usuarioId) {
			// TODO Auto-generated method stub
			return null;
		}

		@Override
		public boolean esLibroDisponibleParaReserva(Long citaId) {
			// TODO Auto-generated method stub
			return false;
		}

		@Override
		public Reserva crearReserva(Long libroId, Long usuarioId, LocalDate fechaReserva, LocalDate fechaExpiracion) {
			// TODO Auto-generated method stub
			return null;
		}