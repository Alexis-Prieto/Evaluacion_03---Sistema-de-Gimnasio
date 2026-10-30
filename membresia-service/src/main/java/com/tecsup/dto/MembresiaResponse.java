package com.tecsup.dto;

import java.time.LocalDate;

public record MembresiaResponse(Long idMembresia, Long idSocio, Long idPlan,
                                LocalDate fechaInicio, LocalDate fechaFin, String estado) {
}
