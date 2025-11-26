package com.parqueadero.sistema_parqueadero.repository;


import com.parqueadero.sistema_parqueadero.models.Vehiculo;
import org.springframework.data.jpa.repository.JpaRepository;


import java.util.Optional;


public interface VehiculoRepository extends JpaRepository<Vehiculo, Long> {
Optional<Vehiculo> findByPlacaAndHoraSalidaIsNull(String placa);
}
