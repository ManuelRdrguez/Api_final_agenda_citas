package com.example.api_final.service;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;


import com.example.api_final.entities.Cita;
import com.example.api_final.entities.Usuario;
import com.example.api_final.error.exception.CitaNotFoundException;

public interface CitaService {
	
	    Page<Cita> ListarTodasLasCitas(Pageable pageable);
	    Cita ActualizarCita(Long id, Cita cita) throws CitaNotFoundException;
	    void EliminarCita(Long id);
		Cita AgregarCita(Cita cita);


	   
	}

