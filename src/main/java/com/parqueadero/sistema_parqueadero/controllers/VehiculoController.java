package com.parqueadero.sistema_parqueadero.controllers;

import com.parqueadero.sistema_parqueadero.services.VehiculoService;
import com.parqueadero.sistema_parqueadero.models.Vehiculo;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/vehiculos")
public class VehiculoController {

    private final VehiculoService vehiculoService;

    public VehiculoController(VehiculoService vehiculoService) {
        this.vehiculoService = vehiculoService;
    }

    @GetMapping
    public String index() {
        return "redirect:/vehiculos/listar";
    }

    @GetMapping("/entrada")
    public String mostrarEntrada(Model model) {
        model.addAttribute("vehiculo", new Vehiculo());
        return "vehiculo_entrada";
    }

    @PostMapping("/entrada")
    public String registrarEntrada(@RequestParam String placa,
                                   @RequestParam String tipoVehiculo) {
        vehiculoService.registrarEntrada(placa, tipoVehiculo);
        return "redirect:/vehiculos/listar";
    }

    @GetMapping("/salida")
    public String mostrarSalida() {
        return "vehiculo_salida";
    }

    @PostMapping("/salida")
    public String registrarSalida(@RequestParam String placa) {
        vehiculoService.registrarSalida(placa);
        return "redirect:/vehiculos/listar";
    }

    @GetMapping("/listar")
    public String listarVehiculos(Model model) {
        model.addAttribute("lista", vehiculoService.findAll());
        return "vehiculo_listar";
    }
}
