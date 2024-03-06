package com.example.api_final.service;

import java.util.List;

import org.springframework.security.core.userdetails.UserDetailsService;

import com.example.api_final.entities.Cita;
import com.example.api_final.entities.Usuario;
import com.example.api_final.error.exception.CitaNotFoundException;
import com.example.api_final.error.exception.UserNotFoundException;


public interface UserService {
    UserDetailsService userDetailsService();
    List<Usuario> getAllUsers();
    void EliminarUsuario(Long id);
	Usuario AgregarUsuario(Usuario user);
	Usuario ActualizarUsuario(Long id, Usuario actualizado) throws UserNotFoundException;
}
