package com.example.api_final.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.api_final.entities.Cita;


@Repository
public interface CitaRepository extends JpaRepository<Cita, Long> {
	/* @Query("SELECT p.libro FROM Prestamo p WHERE p.usuario.id = :usuarioId")
	 List<Libro> findLibrosPrestadosPorUsuario(Integer usuarioId);*/
}
