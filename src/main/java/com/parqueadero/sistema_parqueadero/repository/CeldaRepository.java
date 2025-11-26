package com.parqueadero.sistema_parqueadero.repository;


import com.parqueadero.sistema_parqueadero.models.Celda;
import org.springframework.data.jpa.repository.JpaRepository;


import java.util.Optional;


public interface CeldaRepository extends JpaRepository<Celda, Long> {
Optional<Celda> findByCodigo(String codigo);

Optional<Celda> findFirstByOcupadaFalse();
}