package com.tecsup.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

import java.time.LocalDate;

@Entity
@Table(name = "membresias")
public class Membresia {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idMembresia;

    @Column(nullable = false)
    private Long idSocio;

    @Column(nullable = false)
    private Long idPlan;

    @Column(nullable = false)
    private LocalDate fechaInicio;

    @Column(nullable = false)
    private LocalDate fechaFin;

    @Column(nullable = false, length = 1)
    private String estado = "A";

    public Membresia() {
    }

    public Long getIdMembresia() { return idMembresia; }
    public Long getIdSocio() { return idSocio; }
    public void setIdSocio(Long idSocio) { this.idSocio = idSocio; }
    public Long getIdPlan() { return idPlan; }
    public void setIdPlan(Long idPlan) { this.idPlan = idPlan; }
    public LocalDate getFechaInicio() { return fechaInicio; }
    public void setFechaInicio(LocalDate fechaInicio) { this.fechaInicio = fechaInicio; }
    public LocalDate getFechaFin() { return fechaFin; }
    public void setFechaFin(LocalDate fechaFin) { this.fechaFin = fechaFin; }
    public String getEstado() { return estado; }
    public void setEstado(String estado) { this.estado = estado; }
}
