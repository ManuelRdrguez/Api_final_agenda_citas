package com.example.api_final.entities;

import java.util.Collection;
import java.util.HashSet;
import java.util.Set;
import java.util.stream.Collectors;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;


import jakarta.persistence.CollectionTable;
import jakarta.persistence.Column;
import jakarta.persistence.ElementCollection;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.transaction.Transactional;


@Table(name = "Usuario")
@Entity
public class Usuario implements UserDetails {
	  private static final long serialVersionUID = 1L;
	  	@Id
	    @GeneratedValue(strategy = GenerationType.IDENTITY)
	    private Long id;
	    private String firstName;
	    private String lastName;
	    @Column(unique = true)
	    private String email;
	    private String password;

	    @ElementCollection(fetch = FetchType.EAGER, targetClass = RolUsuario.class)
	    @Enumerated(EnumType.STRING)
	    @CollectionTable(name="usuario_rol")
	    @Column(name ="RolesUsuario")
	    private Set<RolUsuario> roles = new HashSet<>();


	    public Usuario() {}
	    public Usuario(Long id2, String firstName2, String lastName2, String email2, String contraseña, Set<RolUsuario> roles) {
			this.id = id2;
			this.firstName= firstName2;
			this.lastName= lastName2; 
			this.email= email2; 
			this.password = contraseña; 
			this.roles=roles;
		}
		@Transactional
	    @Override
	    public Collection<? extends GrantedAuthority> getAuthorities() {
	        // Cargar la colección de roles de manera temprana
	        roles.size(); // Esto carga la colección de roles

	        return roles.stream()
	                .map(role -> new SimpleGrantedAuthority(role.name()))
	                .collect(Collectors.toList());
	    }
	    @Override
	    public String getUsername() {
	        return email;
	    }

	    @Override
	    public boolean isAccountNonExpired() {
	        return true;
	    }

	    @Override
	    public boolean isAccountNonLocked() {
	        return true;
	    }

	    @Override
	    public boolean isCredentialsNonExpired() {
	        return true;
	    }

	    @Override
	    public boolean isEnabled() {
	        return true;
	    }

	    @Override
	    public String getPassword() {
	        return password;
	    }

	    // Métodos setter añadidos
	    public void setFirstName(String firstName) {
	        this.firstName = firstName;
	    }

	    public void setLastName(String lastName) {
	        this.lastName = lastName;
	    }

	    public void setEmail(String email) {
	        this.email = email;
	    }

	    public void setPassword(String password) {
	        this.password = password;
	    }

	    public Set<RolUsuario> getRoles() {
	        return roles;
	    }

	    public void setRoles(Set<RolUsuario> roles) {
	        this.roles = roles;
	    }
		public Long getId() {
			return id;
		}
		public String getFirstName() {
			return firstName;
		}
		public String getLastName() {
			return lastName;
		}
		public String getEmail() {
			return email;
		}
	    
	    
}