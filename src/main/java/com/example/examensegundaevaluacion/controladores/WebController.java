package com.example.examensegundaevaluacion.controladores;

import com.example.examensegundaevaluacion.modelos.Usuario;
import com.example.examensegundaevaluacion.servicios.UsuarioServicio;
import com.mongodb.MongoWriteException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
public class WebController {
    @Autowired
    private UsuarioServicio usuarioServicio;

    @RequestMapping(value = {"/", "/usuarios"})
    public String getUsuarios(Model model) {
        model.addAttribute("usuarios", usuarioServicio.findAllUsuarios());
        return "usuarios";
    }

    @GetMapping(value = "/usuarios/nuevo")
    public String nuevoUsuario(Model model) {
        model.addAttribute("usuario", new Usuario());
        return "nuevousuario";
    }

    @GetMapping(value = "/usuarios/{username}")
    public String editarUsuario(@PathVariable("username") String username, Model model) {
        Usuario usuario = usuarioServicio.findUsuario(username);
        model.addAttribute("usuario", usuario);
        return "editarusuario";
    }

    @PostMapping(value = "/usuarios/guardar")
    public String guardarUsuario(@ModelAttribute("usuario") Usuario usuario) {
        usuarioServicio.createUsuario(usuario);
        return "redirect:/usuarios";
    }

    @RequestMapping(value = "/usuarios/borrar/{username}")
    public String borrarUsuario(@PathVariable String username, Model model) {
        usuarioServicio.deleteUsuario(username);
        return "redirect:/usuarios";
    }

    @ExceptionHandler(value = {MongoWriteException.class})
    public String duplicadoHandler(Model model) {
        model.addAttribute("mes", "Error ya existe un usuario con el username o el email.");
        return "error";
    }
}
