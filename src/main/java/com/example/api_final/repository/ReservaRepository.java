package com.example.api_final.repository;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.example.api_final.entities.Cita;
import com.example.api_final.entities.EstadoCita;
import com.example.api_final.entities.Reserva;
import com.example.api_final.entities.Usuario;



public interface ReservaRepository extends JpaRepository<Reserva, Long>{
	@Query("SELECT r FROM Reserva r WHERE r.usuario.id = :usuarioId")
    Page<Cita> findCitasPrestadosPorUsuarioId(@Param("usuarioId") Long usuarioId, Pageable pageable);
	boolean existsByCitaAndUsuarioAndEstadoReserva(Cita cita, Usuario usuario, EstadoCita estadoReserva);
}