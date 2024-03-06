package com.example.api_final.service.impl.user;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.example.api_final.entities.Cita;
import com.example.api_final.entities.Usuario;
import com.example.api_final.error.exception.CitaNotFoundException;
import com.example.api_final.error.exception.UserNotFoundException;
import com.example.api_final.repository.UserRepository;
import com.example.api_final.service.UserService;

import lombok.RequiredArgsConstructor;




@Service
@RequiredArgsConstructor
public class UserServiceImpl implements UserService {
	@Autowired
    private UserRepository userRepository;
    @Override
    public UserDetailsService userDetailsService() {
        return new UserDetailsService() {
            @Override
            public UserDetails loadUserByUsername(String username) {
                return userRepository.findByEmail(username)
                        .orElseThrow(() -> new UsernameNotFoundException("User not found"));
            }
        };
    }
	@Override
	public List<Usuario> getAllUsers() {
		List<Usuario> allUsers =  userRepository.findAll().stream()
			    .map(usuario -> new Usuario(usuario.getId(), usuario.getFirstName(), usuario.getLastName(), usuario.getEmail(), usuario.getPassword(), usuario.getRoles()))
			    .collect(Collectors.toList());
		 return allUsers;
	}
	@Override
	public Usuario ActualizarUsuario(Long id, Usuario usuario_actualizado) throws UserNotFoundException {
		 // Verificar si la cita existe
        if (!userRepository.existsById(usuario_actualizado.getId())) {
            // Manejo de error si la cita no existe
            // Puedes lanzar una excepción, retornar null, etc.
            // Aquí he optado por lanzar una excepción como ejemplo
            throw new UserNotFoundException("La cita con ID " + usuario_actualizado.getId() + " no existe");
        }
        
        // Guardar la cita actualizada en la base de datos
        return userRepository.save(usuario_actualizado);
	}
	@Override
	public void EliminarUsuario(Long id) {
		userRepository.deleteById(id);
	}
	@Override
	public Usuario AgregarUsuario(Usuario user) {
		return userRepository.save(user); 
		
	}
}
