package com.parqueadero.sistema_parqueadero.controllers;

import com.parqueadero.sistema_parqueadero.models.Rol;
import com.parqueadero.sistema_parqueadero.services.RolService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/roles")
public class RolController {

    private final RolService rolService;

    public RolController(RolService rolService) {
        this.rolService = rolService;
    }

    // Listado de roles
    @GetMapping
    public String listarRoles(Model model) {
        model.addAttribute("roles", rolService.listar());
        return "roles"; // roles.html
    }

    // Formulario para crear rol
    @GetMapping("/nuevo")
    public String nuevoRol(Model model) {
        model.addAttribute("rol", new Rol());
        return "rol-form"; // rol-form.html
    }

    // Guardar rol
    @PostMapping
    public String guardarRol(@ModelAttribute Rol rol) {
        rolService.guardar(rol);
        return "redirect:/roles";
    }
}
