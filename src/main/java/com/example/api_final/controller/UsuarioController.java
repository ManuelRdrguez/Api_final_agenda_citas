package com.example.api_final.controller;

import java.util.List;

import javax.validation.Valid;

import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.api_final.entities.Usuario;
import com.example.api_final.error.exception.UserNotFoundException;
import com.example.api_final.service.UserService;

import ch.qos.logback.classic.Logger;

@RestController
@RequestMapping("/api/v1/usuarios")
public class UsuarioController {

    private static final org.slf4j.Logger logger = LoggerFactory.getLogger(UsuarioController.class);

    @Autowired
    private UserService userService;

    public UsuarioController(UserService userService2) {
		this.userService=userService2;
	}

	// Obtener todos los usuarios (accesible por usuarios con ROLE_USER o ROLE_ADMIN)
    @GetMapping
    @PreAuthorize("hasRole('ROLE_USER') || hasRole('ROLE_ADMIN')")
    public ResponseEntity<List<Usuario>> obtenerTodosLosUsuarios() {
        List<Usuario> usuarios = userService.getAllUsers();
        return new ResponseEntity<>(usuarios, HttpStatus.OK);
    }

    // Crear un nuevo usuario (accesible solo por usuarios con ROLE_ADMIN)
    @PostMapping("/crear")
    @PreAuthorize("hasRole('ROLE_ADMIN')")
    public Usuario crearUsuario(@Valid @RequestBody Usuario usuario) {
        return userService.AgregarUsuario(usuario);
        
    }

    // Actualizar un usuario existente (accesible solo por usuarios con ROLE_ADMIN)
    @PutMapping("/{id}")
    @PreAuthorize("hasRole('ROLE_ADMIN')")
    public Usuario actualizarUsuario(@PathVariable Long id, @Valid @RequestBody Usuario usuario) throws UserNotFoundException {
        return userService.ActualizarUsuario(id, usuario);
    }

    // Eliminar un usuario (accesible solo por usuarios con ROLE_ADMIN)
    @DeleteMapping("/{id}")
    @PreAuthorize("hasRole('ROLE_ADMIN')")
    public void eliminarUsuario(@PathVariable Long id) {
        userService.EliminarUsuario(id);
    }
}