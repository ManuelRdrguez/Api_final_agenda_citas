package com.example.api_final.service;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;


import com.example.api_final.entities.Cita;
import com.example.api_final.entities.Usuario;

public interface CitaService {
	
	    Page<Cita> ListarTodasLasCitas(Pageable pageable);

	    Cita ObtenerCitaporId(Long id);

	    Cita ActualizarCita(Long id, Cita cita);
	    void EliminarCita(Long id);

	    Cita ReservarCita(Cita cita, Usuario usuario);

		Cita AgregarCita(Cita cita);

	   
	}

