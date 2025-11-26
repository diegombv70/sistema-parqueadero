package com.parqueadero.sistema_parqueadero.controllers;

import com.parqueadero.sistema_parqueadero.services.CeldaService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class DashboardController {

    private final CeldaService celdaService;

    public DashboardController(CeldaService celdaService) {
        this.celdaService = celdaService;
    }

    @GetMapping({"/", "/dashboard"})
    public String dashboard(Model model) {
        model.addAttribute("celdas", celdaService.findAll());
        model.addAttribute("disponibles", celdaService.countDisponibles());
        model.addAttribute("ocupadas", celdaService.countOcupadas());
        return "dashboard";
    }
}
