package com.example.examensegundaevaluacion.servicios;


import com.example.examensegundaevaluacion.modelos.Usuario;
import com.example.examensegundaevaluacion.respositorios.UsuarioRepositorio;
import com.mongodb.MongoWriteException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UsuarioServicioImpl implements UsuarioServicio {

    @Autowired
    private UsuarioRepositorio usuarioRepositorio;

    @Override
    public List<Usuario> findAllUsuarios() {
        return usuarioRepositorio.findAll();
    }

    @Override
    public Usuario findUsuario(String username) {
        return usuarioRepositorio.findUsuarioByUsername(username);
    }

    @Override
    public Usuario createUsuario(Usuario usuario) {
        return usuarioRepositorio.save(usuario);
    }

    @Override
    public void deleteUsuario(String username) {
        usuarioRepositorio.deleteByUsername(username);
    }
}
