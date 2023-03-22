package com.backend.portfolio.security.DTO;

import java.util.HashSet;
import java.util.Set;

public class NuevoUsuario {
    
    private String nombre;
    private String username;
    private String correo;
    private String password;
    private Set<String> roles = new HashSet<>();

    // Getters && Seters
    public String getNombre() {
        return nombre;
    }
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }
    public String getUsername() {
        return username;
    }
    public void setUsername(String username) {
        this.username = username;
    }
    public String getCorreo() {
        return correo;
    }
    public void setCorreo(String correo) {
        this.correo = correo;
    }
    public String getPassword() {
        return password;
    }
    public void setPassword(String password) {
        this.password = password;
    }
    public Set<String> getRoles() {
        return roles;
    }
    public void setRoles(Set<String> roles) {
        this.roles = roles;
    }

    
}
