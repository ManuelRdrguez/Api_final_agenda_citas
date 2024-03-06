package com.example.api_final;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertSame;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.ArgumentMatchers.eq;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;


import com.example.api_final.controller.CitaController;
import com.example.api_final.entities.Cita;
import com.example.api_final.error.exception.CitaNotFoundException;
import com.example.api_final.service.CitaService;

public class CitaControllerTest {
	  private CitaController citaController;
	    private CitaService citaService;

	    @BeforeEach
	    void setUp() {
	        citaService = mock(CitaService.class);
	        citaController = new CitaController(citaService);
	    }

	    @Test
	    void testListarTodasLasCitas() {
	        // Simulación de una lista de citas
	        Page<Cita> citas = mock(Page.class);
	        when(citaService.ListarTodasLasCitas(any())).thenReturn(citas);

	        // Invocar al método del controlador y verificar la respuesta
	        ResponseEntity<Page<Cita>> response = citaController.ListarTodasLasCitas(0, 10);
	        assertSame(citas, response.getBody());
	        assertEquals(HttpStatus.OK, response.getStatusCode());
	    }

	    @Test
	    void testCrearCita() {
	        // Cita de ejemplo
	        Cita cita = new Cita();

	        // Simulación del servicio para devolver la cita creada
	        when(citaService.AgregarCita(any())).thenReturn(cita);

	        // Invocar al método del controlador y verificar la respuesta
	        Cita createdCita = citaController.CrearCita(cita);
	        assertSame(cita, createdCita);
	    }

	    @Test
	    void testActualizarCita() throws CitaNotFoundException {
	        // ID de cita de ejemplo
	        Long citaId = 1L;
	        // Cita de ejemplo
	        Cita cita = new Cita();

	        // Simulación del servicio para devolver la cita actualizada
	        when(citaService.ActualizarCita(eq(citaId), any())).thenReturn(cita);

	        // Invocar al método del controlador y verificar la respuesta
	        Cita updatedCita = citaController.ActualizarCita(citaId, cita);
	        assertSame(cita, updatedCita);
	    }

	    @Test
	    void testEliminarCita() {
	        // ID de cita de ejemplo
	        Long citaId = 1L;

	        // Invocar al método del controlador
	        citaController.EliminarCita(citaId);

	        // Verificar que el método correspondiente del servicio se haya llamado
	        verify(citaService).EliminarCita(citaId);
	    }
	}
