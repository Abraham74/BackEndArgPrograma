package com.backend.portfolio.security.Service;

import java.util.Optional;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.backend.portfolio.security.Entity.Usuario;
import com.backend.portfolio.security.Repository.IUsuarioRepository;



@Service
@Transactional
public class UsuarioService {
    
    @Autowired
    IUsuarioRepository iusuarioRepository;

    public Optional<Usuario> getByUsername(String username){
        return iusuarioRepository.findByUsername(username);
    }

    public boolean existsByUsername(String username){
        return iusuarioRepository.existsByUsername(username);
    }

    public boolean existsByCorreo(String correo){
        return iusuarioRepository.existsByCorreo(correo);
    }

    public void save(Usuario usuario){
        iusuarioRepository.save(usuario);
    }
}
