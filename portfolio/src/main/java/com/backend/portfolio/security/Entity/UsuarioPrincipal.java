package com.backend.portfolio.security.Entity;

import java.util.Collection;
import java.util.List;
import java.util.stream.Collectors;


import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;





public class UsuarioPrincipal implements UserDetails {
    private String nombre;
    private String username;
    private String correo;
    private String password;
    private Collection<? extends GrantedAuthority> authorities;

    // Constructor
    public UsuarioPrincipal(String nombre, String username, String correo, String password,
            Collection<? extends GrantedAuthority> authorities) {
        this.nombre = nombre;
        this.username = username;
        this.correo = correo;
        this.password = password;
        this.authorities = authorities;
    }

    public static UsuarioPrincipal build(Usuario usuario) {
        List<GrantedAuthority> authorities = usuario.getRoles().stream()
                .map(rol -> new SimpleGrantedAuthority(rol.getRolNombre().name())).collect(Collectors.toList());

        return new UsuarioPrincipal(usuario.getNombre(), usuario.getUsername(), usuario.getCorreo(),
                usuario.getPassword(), authorities);
    }

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return authorities;
    }

    @Override
    public String getPassword() {
        return password;
    }

    public String getNombre() {
        return nombre;
    }

    public String getCorreo() {
        return correo;
    }

    @Override
    public String getUsername() {
        return username;
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

}
