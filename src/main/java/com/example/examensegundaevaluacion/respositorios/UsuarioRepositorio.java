package com.example.examensegundaevaluacion.respositorios;

import com.example.examensegundaevaluacion.modelos.Usuario;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface UsuarioRepositorio extends MongoRepository<Usuario, String> {
    Usuario findUsuarioByUsername(String username);
    void deleteByUsername(String username);
}
