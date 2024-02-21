package com.example.api_final.service.imple;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import com.example.api_final.entities.Cita;
import com.example.api_final.entities.Usuario;
import com.example.api_final.service.CitaService;

@Service
public class CitaServiceImpl implements CitaService {

	@Override
	public Page<Cita> ListarTodasLasCitas(Pageable pageable) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Cita ObtenerCitaporId(Long id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Cita ActualizarCita(Long id, Cita cita) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void EliminarCita(Long id) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public Cita ReservarCita(Cita cita, Usuario usuario) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Cita AgregarCita(Cita cita) {
		// TODO Auto-generated method stub
		return null;
	}
 
}
