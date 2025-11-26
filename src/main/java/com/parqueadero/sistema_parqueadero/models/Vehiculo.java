package com.parqueadero.sistema_parqueadero.models;

import jakarta.persistence.*;
import java.time.LocalDateTime;

@Entity
public class Vehiculo {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String placa;
    private String tipoVehiculo;

    private LocalDateTime horaEntrada;
    private LocalDateTime horaSalida;

    @ManyToOne
    @JoinColumn(name = "celda_id")
    private Celda celda;

    public Vehiculo() {}

    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }

    public String getPlaca() { return placa; }
    public void setPlaca(String placa) { this.placa = placa; }

    public String getTipoVehiculo() { return tipoVehiculo; }
    public void setTipoVehiculo(String tipoVehiculo) { this.tipoVehiculo = tipoVehiculo; }

    public LocalDateTime getHoraEntrada() { return horaEntrada; }
    public void setHoraEntrada(LocalDateTime horaEntrada) { this.horaEntrada = horaEntrada; }

    public LocalDateTime getHoraSalida() { return horaSalida; }
    public void setHoraSalida(LocalDateTime horaSalida) { this.horaSalida = horaSalida; }

    public Celda getCelda() { return celda; }
    public void setCelda(Celda celda) { this.celda = celda; }
}
