package com.tecsup.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

import java.math.BigDecimal;

@Entity
@Table(name = "planes")
public class Plan {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idPlan;

    @Column(nullable = false, length = 100)
    private String nombre;

    @Column(nullable = false, precision = 10, scale = 2)
    private BigDecimal precio;

    @Column(nullable = false)
    private Integer duracionMeses;

    @Column(nullable = false, length = 1)
    private String estado = "A";

    public Plan() {
    }

    public Long getIdPlan() { return idPlan; }
    public String getNombre() { return nombre; }
    public void setNombre(String nombre) { this.nombre = nombre; }
    public BigDecimal getPrecio() { return precio; }
    public void setPrecio(BigDecimal precio) { this.precio = precio; }
    public Integer getDuracionMeses() { return duracionMeses; }
    public void setDuracionMeses(Integer duracionMeses) { this.duracionMeses = duracionMeses; }
    public String getEstado() { return estado; }
    public void setEstado(String estado) { this.estado = estado; }
}
