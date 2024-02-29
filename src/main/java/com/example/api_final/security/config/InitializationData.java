package com.example.api_final.security.config;

import java.time.LocalDate;
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
import com.example.api_final.entities.EstadoCita;
import com.example.api_final.entities.Reserva;
import com.example.api_final.entities.RolUsuario;
import com.example.api_final.entities.Usuario;
import com.example.api_final.repository.CitaRepository;
import com.example.api_final.repository.ReservaRepository;
import com.example.api_final.repository.UserRepository;
import com.example.api_final.response.user.UserResponse;
import com.github.javafaker.Faker;

@Component
public class InitializationData implements CommandLineRunner {
    private final boolean borrarcitas = true; // Variable para controlar el borrado de datos

    @Autowired
    private UserRepository usuarioRepository;
        
    @Autowired
    private CitaRepository citaRepository;
    
    private ReservaRepository reservarepository;

    @Autowired
    private PasswordEncoder passwordEncoder;

    @Override
    public void run(String... args) throws Exception {
    	
 
    	if (borrarcitas) {
            citaRepository.deleteAll();;
            usuarioRepository.deleteAll();
        }
    	try {
    		// Usuario 1 - Rol USER
            Usuario usuario1 = new Usuario();
            Reserva reserva1 = new Reserva();
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
            usuario2.getRoles().add(RolUsuario.ROLE_ADMIN);
            usuarioRepository.save(usuario2);
            Cita cita2 = new Cita(); 
            cita2.setNombre_de_barbero("Manuel Ródriguez");
            cita2.setTipo_de_corte("Corte degradado con recorte de barba");
            cita2.setUsario(usuario2);
            citaRepository.save(cita2);
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
            
            
            Usuario usuario4 = new Usuario();
            usuario4.setFirstName("Manuel");
            usuario4.setLastName("Rodriguez");
            usuario4.setEmail("manuel.rodriguez@example.com");
            usuario3.setPassword(passwordEncoder.encode("password789"));
            usuario4.getRoles().add(RolUsuario.ROLE_USER);
            usuarioRepository.save(usuario4);
            Cita cita4 = new Cita(); 
            cita4.setNombre_de_barbero("Roberto Márquez");
            cita4.setTipo_de_corte("Corte degradado con recorte de barba");
            cita4.setUsario(usuario4);
            citaRepository.save(cita4);
            
            
    	}catch(Exception e) {
    		System.err.println("NO SE HA PODIDO INSERATAR LOS USUARIS Y CITAS");
    	}
    	
        
    }
   

}