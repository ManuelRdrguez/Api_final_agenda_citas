package com.example.api_final.service.imple;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.example.api_final.entities.EstadoCita;
import com.example.api_final.entities.Reserva;
import com.example.api_final.service.ReservaService;
@Service
public class ReservaCitaImpl implements ReservaService{

	@Override
	public Reserva crearReserva(Long libroId, Long usuarioId, String name_barber, LocalDate fechaReserva,
			LocalDate fechaExpiracion) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Reserva cancelarReserva(Long reservaId) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Reserva actualizarEstadoReserva(Long reservaId, EstadoCita nuevoEstado) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Optional<Reserva> obtenerReservaPorId(Long reservaId) {
		// TODO Auto-generated method stub
		return Optional.empty();
	}

	@Override
	public List<Reserva> listarTodasLasReservas() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Reserva> listarReservasPorUsuario(Long usuarioId) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public boolean esLibroDisponibleParaReserva(Long libroId) {
		// TODO Auto-generated method stub
		return false;
	}

}
