package com.example.api_final;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertSame;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import java.util.List;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import com.example.api_final.controller.UsuarioController;
import com.example.api_final.entities.Usuario;
import com.example.api_final.error.exception.UserNotFoundException;
import com.example.api_final.service.UserService;

public class UserControllerTest {
	   private UsuarioController usuarioController;
	    private UserService userService;

	    @BeforeEach
	    void setUp() {
	        userService = mock(UserService.class);
	        usuarioController = new UsuarioController(userService);
	    }

	    @Test
	    void testListarTodosLosUsuarios() {
	        // Simulación de una lista de usuarios
	        List<Usuario> usuarios = List.of(mock(Usuario.class), mock(Usuario.class)); // Ejemplo de una lista de usuarios simulados
	        when(userService.getAllUsers()).thenReturn(usuarios);

	        // Invocar al método del controlador y verificar la respuesta
	        ResponseEntity<List<Usuario>> response = usuarioController.obtenerTodosLosUsuarios();
	        assertSame(usuarios, response.getBody());
	        assertEquals(HttpStatus.OK, response.getStatusCode());
	    }

	    @Test
	    void testCrearUsuario() {
	        // Usuario de ejemplo
	        Usuario usuario = new Usuario();

	        // Simulación del servicio para devolver el usuario creado
	        when(userService.AgregarUsuario(any())).thenReturn(usuario);

	        // Invocar al método del controlador y verificar la respuesta
	        Usuario createdUsuario = usuarioController.crearUsuario(usuario);
	        assertSame(usuario, createdUsuario);
	    }

	    @Test
	    void testActualizarUsuario() throws UserNotFoundException {
	        // ID de usuario de ejemplo
	        Long usuarioId = 1L;
	        // Usuario de ejemplo
	        Usuario usuario = new Usuario();

	        // Simulación del servicio para devolver el usuario actualizado
	        when(userService.ActualizarUsuario(usuarioId, usuario)).thenReturn(usuario);

	        // Invocar al método del controlador y verificar la respuesta
	        Usuario updatedUsuario = usuarioController.actualizarUsuario(usuarioId, usuario);
	        assertSame(usuario, updatedUsuario);
	    }

	    @Test
	    void testEliminarUsuario() {
	        // ID de usuario de ejemplo
	        Long usuarioId = 1L;

	        // Invocar al método del controlador
	        usuarioController.eliminarUsuario(usuarioId);

	        // Verificar que el método correspondiente del servicio se haya llamado
	        verify(userService).EliminarUsuario(usuarioId);
	    }
	}

