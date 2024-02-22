package com.example.api_final.security.config;

import java.util.Locale;

import javax.management.relation.Role;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Profile;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Component;

import com.example.api_final.entities.Cita;
import com.example.api_final.entities.RolUsuario;
import com.example.api_final.entities.Usuario;
import com.example.api_final.repository.CitaRepository;
import com.example.api_final.repository.UserRepository;
import com.example.api_final.response.user.UserResponse;
import com.github.javafaker.Faker;

@Component
public class InitializationData implements CommandLineRunner {

    @Autowired
    private UserRepository usuarioRepository;
        
    @Autowired
    private CitaRepository citaRepository;

    @Autowired
    private PasswordEncoder passwordEncoder;

    @Override
    public void run(String... args) throws Exception {
    	
 
    	
    	try {
    		// Usuario 1 - Rol USER
            Usuario usuario1 = new Usuario();

            usuario1.setFirstName("Alice");
            usuario1.setLastName("Johnson");
            usuario1.setEmail("alice.johnson@example.com");
            usuario1.setPassword(passwordEncoder.encode("password123"));
            usuario1.getRoles().add(RolUsuario.ROLE_USER);
            usuarioRepository.save(usuario1);
            Cita cita1 = new Cita(); 
            cita1.setNombre_de_barbero("Manuel Ródriguez");
            cita1.setTipo_de_corte("Corte degradado con recorte de barba");
            cita1.setUsario(usuario1);
            citaRepository.save(cita1);
            // Usuario 2 - Rol ADMIN
            Usuario usuario2 = new Usuario();
            usuario2.setFirstName("Bob");
            usuario2.setLastName("Smith");
            usuario2.setEmail("bob.smith@example.com");
            usuario2.setPassword(passwordEncoder.encode("password456"));
            usuario2.getRoles().add(RolUsuario.ROLE_USER);
            usuarioRepository.save(usuario2);
            Cita cita2 = new Cita(); 
            cita2.setNombre_de_barbero("Manuel Ródriguez");
            cita2.setTipo_de_corte("Corte degradado con recorte de barba");
            cita2.setUsario(usuario2);
            citaRepository.save(cita1);
            // Usuario 3 - Rol USER
            Usuario usuario3 = new Usuario();
            usuario3.setFirstName("Carol");
            usuario3.setLastName("Davis");
            usuario3.setEmail("carol.davis@example.com");
            usuario3.setPassword(passwordEncoder.encode("password789"));
            usuario3.getRoles().add(RolUsuario.ROLE_USER);
            usuarioRepository.save(usuario3);
            Cita cita3 = new Cita(); 
            cita3.setNombre_de_barbero("Manuel Ródriguez");
            cita3.setTipo_de_corte("Corte degradado con recorte de barba");
            cita3.setUsario(usuario3);
            citaRepository.save(cita3);
            
            
            
    	}catch(Exception e) {
    		System.err.println("NO SE HA PODIDO INSERATAR LOS USUARIS Y CITAS");
    	}
    	/*Faker faker = new Faker(new Locale("es"));
        for (int i = 0; i < 10; i++) { // Generar 10 libros ficticios
            Cita cita = new Cita();
            cita.setNombre_de_barbero(faker.name().firstName());
            cita.setTipo_de_corte("Corte degradado");
            cita.setUsario();
            cita.save(libro);
        }*/
        
    }
   

}