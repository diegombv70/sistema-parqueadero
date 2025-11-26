package com.parqueadero.sistema_parqueadero.services;

import com.parqueadero.sistema_parqueadero.models.Celda;
import com.parqueadero.sistema_parqueadero.models.Vehiculo;
import com.parqueadero.sistema_parqueadero.repository.CeldaRepository;
import com.parqueadero.sistema_parqueadero.repository.VehiculoRepository;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

@Service
public class VehiculoService {

    private final VehiculoRepository vehiculoRepository;
    private final CeldaRepository celdaRepository;

    public VehiculoService(VehiculoRepository vehiculoRepository,
                           CeldaRepository celdaRepository) {
        this.vehiculoRepository = vehiculoRepository;
        this.celdaRepository = celdaRepository;
    }

    public Vehiculo registrarEntrada(String placa, String tipoVehiculo) {

        Optional<Celda> celdaLibre = celdaRepository.findFirstByOcupadaFalse();

        if (celdaLibre.isEmpty()) {
            throw new RuntimeException("No hay celdas disponibles.");
        }

        Celda celda = celdaLibre.get();
        celda.setOcupada(true);
        celdaRepository.save(celda);

        Vehiculo v = new Vehiculo();
        v.setPlaca(placa);
        v.setTipoVehiculo(tipoVehiculo);
        v.setCelda(celda);
        v.setHoraEntrada(LocalDateTime.now()); // <-- ESTA ES LA CORRECTA
        v.setHoraSalida(null);                 // <-- salida es null al entrar

        return vehiculoRepository.save(v);
    }

    public Optional<Vehiculo> findActivoPorPlaca(String placa) {
        return vehiculoRepository.findByPlacaAndHoraSalidaIsNull(placa);
    }

    public Vehiculo registrarSalida(String placa) {

        Vehiculo v = vehiculoRepository.findByPlacaAndHoraSalidaIsNull(placa)
                .orElseThrow(() -> new RuntimeException("El vehículo no está registrado."));

        v.setHoraSalida(LocalDateTime.now()); // <-- registrar salida

        Celda celda = v.getCelda();
        celda.setOcupada(false);
        celdaRepository.save(celda);

        return vehiculoRepository.save(v);
    }

    public List<Vehiculo> findAll() {
        return vehiculoRepository.findAll();
    }
}
