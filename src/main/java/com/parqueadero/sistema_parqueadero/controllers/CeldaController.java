package com.parqueadero.sistema_parqueadero.controllers;

import com.parqueadero.sistema_parqueadero.models.Celda;
import com.parqueadero.sistema_parqueadero.services.CeldaService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/celdas")
public class CeldaController {

    private final CeldaService celdaService;

    public CeldaController(CeldaService celdaService) {
        this.celdaService = celdaService;
    }

    @GetMapping
    public String list(Model model) {
        model.addAttribute("celdas", celdaService.findAll());
        return "celdas";
    }

    @GetMapping("/crear")
    public String crear(Model model) {
        model.addAttribute("celda", new Celda());
        return "crear_celda";
    }

    @PostMapping("/guardar")
    public String guardar(@ModelAttribute Celda celda) {
        celdaService.save(celda);
        return "redirect:/celdas";
    }
}
