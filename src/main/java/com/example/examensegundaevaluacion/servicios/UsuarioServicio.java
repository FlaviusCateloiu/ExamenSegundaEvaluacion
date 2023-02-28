package com.example.examensegundaevaluacion.servicios;

import com.example.examensegundaevaluacion.modelos.Usuario;

import java.util.List;

public interface UsuarioServicio {
    List<Usuario> findAllUsuarios();
    Usuario findUsuario(String username);
    Usuario createUsuario(Usuario usuario);
    void deleteUsuario(String username);
}
