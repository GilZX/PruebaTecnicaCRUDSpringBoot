package com.pruebatecnica.crud.CRUDCLIENTES.rest;


import com.pruebatecnica.crud.CRUDCLIENTES.model.Usuario;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class UsuarioService {

    @Autowired
    private UsuarioRepository usuarioRepository;

    @Autowired
    private BCryptPasswordEncoder passwordEncoder;



    public Usuario registrarUsuario(Usuario usuario) {
        // Verificar si el nombre de usuario ya existe
        if (usuarioRepository.findByUsername(usuario.getUsername()).isPresent()) {
            throw new RuntimeException("El nombre de usuario ya existe.");
        }

        // Encriptar la contraseña antes de guardarla
        usuario.setPassword(passwordEncoder.encode(usuario.getPassword()));
        usuario.setRole("USER"); // Asignar el rol por defecto

        return usuarioRepository.save(usuario);
    }



}
