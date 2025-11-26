package com.parqueadero.sistema_parqueadero.services;

import com.parqueadero.sistema_parqueadero.models.Celda;
import com.parqueadero.sistema_parqueadero.repository.CeldaRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CeldaService {

    private final CeldaRepository celdaRepository;

    public CeldaService(CeldaRepository celdaRepository) {
        this.celdaRepository = celdaRepository;
    }

    public List<Celda> findAll() {
        return celdaRepository.findAll();
    }

    public Optional<Celda> findById(Long id) {
        return celdaRepository.findById(id);
    }

    public Celda save(Celda c) {
        return celdaRepository.save(c);
    }

    public void delete(Long id) {
        celdaRepository.deleteById(id);
    }

    public long countDisponibles() {
        return celdaRepository.findAll().stream().filter(c -> !c.isOcupada()).count();
    }

    public long countOcupadas() {
        return celdaRepository.findAll().stream().filter(Celda::isOcupada).count();
    }
}
