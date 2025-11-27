package com.parqueadero.sistema_parqueadero.controllers;

import com.parqueadero.sistema_parqueadero.models.Usuario;
import com.parqueadero.sistema_parqueadero.services.UsuarioService;
import com.parqueadero.sistema_parqueadero.services.RolService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/usuarios")
public class UsuarioController {

    private final UsuarioService usuarioService;
    private final RolService rolService;

    public UsuarioController(UsuarioService usuarioService, RolService rolService) {
        this.usuarioService = usuarioService;
        this.rolService = rolService;
    }

    // Mostrar lista de usuarios
    @GetMapping
    public String listarUsuarios(Model model) {
        model.addAttribute("usuarios", usuarioService.listar());
        return "usuarios"; // muestra usuarios.html
    }

    // Formulario para nuevo usuario
    @GetMapping("/nuevo")
    public String nuevoUsuario(Model model) {
        model.addAttribute("usuario", new Usuario());
        model.addAttribute("roles", rolService.listar());
        return "usuario-form"; // muestra usuario-form.html
    }

    // Guardar usuario
    @PostMapping
    public String guardarUsuario(@ModelAttribute Usuario usuario) {
        usuarioService.guardar(usuario);
        return "redirect:/usuarios";
    }
}
