package com.tecsup.dto;

import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;

import java.math.BigDecimal;

public record PlanRequest(
        @NotBlank String nombre,
        @NotNull @Positive BigDecimal precio,
        @NotNull @Min(1) Integer duracionMeses,
        String estado
) {
}
