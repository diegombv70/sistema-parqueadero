package com.parqueadero.sistema_parqueadero.services;

import com.parqueadero.sistema_parqueadero.models.Rol;
import com.parqueadero.sistema_parqueadero.repository.RolRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class RolService {

    private final RolRepository rolRepository;

    public RolService(RolRepository rolRepository) {
        this.rolRepository = rolRepository;
    }

    public Rol guardar(Rol rol) {
        return rolRepository.save(rol);
    }

    public List<Rol> listar() {
        return rolRepository.findAll();
    }
}
