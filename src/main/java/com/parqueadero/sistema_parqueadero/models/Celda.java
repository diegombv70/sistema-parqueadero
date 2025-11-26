package com.parqueadero.sistema_parqueadero.models;

import jakarta.persistence.*;

@Entity
public class Celda {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String codigo;
    private boolean ocupada;

    public Celda() {}

    public Celda(String codigo, boolean ocupada) {
        this.codigo = codigo;
        this.ocupada = ocupada;
    }

    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }
    
    public String getCodigo() { return codigo; }
    public void setCodigo(String codigo) { this.codigo = codigo; }
    
    public boolean isOcupada() { return ocupada; }
    public void setOcupada(boolean ocupada) { this.ocupada = ocupada; }
}
