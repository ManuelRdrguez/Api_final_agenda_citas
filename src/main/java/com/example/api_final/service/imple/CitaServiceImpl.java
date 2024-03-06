package com.example.api_final.service.imple;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import com.example.api_final.entities.Cita;
import com.example.api_final.entities.Usuario;
import com.example.api_final.error.exception.CitaNotFoundException;
import com.example.api_final.repository.CitaRepository;
import com.example.api_final.service.CitaService;

@Service
public class CitaServiceImpl implements CitaService {
	@Autowired
	private CitaRepository citaRepository;

	@Override
	public Page<Cita> ListarTodasLasCitas(Pageable pageable) {
		return citaRepository.findAll(pageable);
	}



	@Override
	public Cita ActualizarCita(Long id,Cita citaActualizada) throws CitaNotFoundException {
        // Verificar si la cita existe
        if (!citaRepository.existsById(citaActualizada.getId())) {
            // Manejo de error si la cita no existe
            // Puedes lanzar una excepción, retornar null, etc.
            // Aquí he optado por lanzar una excepción como ejemplo
            throw new CitaNotFoundException("La cita con ID " + citaActualizada.getId() + " no existe");
        }
        
        // Guardar la cita actualizada en la base de datos
        return citaRepository.save(citaActualizada);
    }


	@Override
	public void EliminarCita(Long id) {
		citaRepository.deleteById(id);
	}



	@Override
	public Cita AgregarCita(Cita cita) {
        return citaRepository.save(cita);
	}

	
 
}
