package com.tecsup.dto;

import jakarta.validation.constraints.AssertTrue;
import jakarta.validation.constraints.NotNull;

import java.time.LocalDate;

public record MembresiaRequest(
        @NotNull Long idSocio,
        @NotNull Long idPlan,
        @NotNull LocalDate fechaInicio,
        @NotNull LocalDate fechaFin,
        String estado
) {
    @AssertTrue(message = "fechaInicio no puede ser posterior a fechaFin")
    public boolean isFechasValidas() {
        return fechaInicio == null || fechaFin == null || !fechaInicio.isAfter(fechaFin);
    }
}
