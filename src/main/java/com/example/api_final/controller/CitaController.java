package com.example.api_final.controller;

import java.time.LocalDate;
import java.util.Date;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.example.api_final.entities.Cita;
import com.example.api_final.entities.Usuario;
import com.example.api_final.error.exception.CitaNotFoundException;
import com.example.api_final.response.error.DetailsResponse;
import com.example.api_final.response.error.ErrorDetailsResponse;
import com.example.api_final.service.CitaService;

import jakarta.persistence.EntityNotFoundException;

@RestController
@RequestMapping("/api/v1/citas")
public class CitaController {

	private static final Logger logger = LoggerFactory.getLogger(CitaController.class);

    @Autowired
    private CitaService citaservice;

    public CitaController(CitaService citaService2) {
    	this.citaservice = citaService2;
    }


	// Endpoint para obtener un listado de cita, accesible solo por ROLE_USER
    @GetMapping
    @PreAuthorize("hasRole('ROLE_USER') || hasRole('ROLE_ADMIN')")
    public ResponseEntity<Page<Cita>> ListarTodasLasCitas(
            @RequestParam(defaultValue = "0") int page,
            @RequestParam(defaultValue = "10") int size) {
        
        logger.info("CitaController :: ListarTodasLasCitas");
        Pageable pageable = PageRequest.of(page, size);
        Page<Cita> cita = citaservice.ListarTodasLasCitas(pageable);
        
   
        
        return new ResponseEntity<>(cita, HttpStatus.OK);
    }
    
    
 // CRUD endpoints, accesibles solo por ROLE_ADMIN
    // Crear una cita
    @PostMapping("/crear")
    @PreAuthorize("hasRole('ROLE_ADMIN')")
    public Cita CrearCita(@RequestBody Cita cita) {
        return citaservice.AgregarCita(cita);
    }

    // Actualizar una cita
    @PutMapping("/{id}")
    @PreAuthorize("hasRole('ROLE_ADMIN')")
    public Cita ActualizarCita(@PathVariable Long id, @RequestBody Cita cita) throws CitaNotFoundException {
        return citaservice.ActualizarCita(id, cita);
    }

    // Eliminar una cita
    @DeleteMapping("/{id}")
    @PreAuthorize("hasRole('ROLE_ADMIN')")
    public void EliminarCita(@PathVariable Long id) {
    	citaservice.EliminarCita(id);
    }
    
  

}
