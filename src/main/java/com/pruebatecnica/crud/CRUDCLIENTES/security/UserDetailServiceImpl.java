package com.pruebatecnica.crud.CRUDCLIENTES.security;

import com.pruebatecnica.crud.CRUDCLIENTES.model.Usuario;
import com.pruebatecnica.crud.CRUDCLIENTES.rest.UsuarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.Optional;
@Service
public class UserDetailServiceImpl implements UserDetailsService {

    @Autowired
    private UsuarioRepository usuarioRepository;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {

        Optional<Usuario> usuario = usuarioRepository.findByUsername(username);


        if (usuario.isEmpty()) {
            throw new UsernameNotFoundException("Usuario no encontrado con el nombre: " + username);
        }

        Usuario user = usuario.get();


        return User.builder()
                .username(user.getUsername())
                .password(user.getPassword())
                .roles(user.getRole())
                .build();
    }

    }


