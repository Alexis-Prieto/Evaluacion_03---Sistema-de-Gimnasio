package com.tecsup.dto;

import java.math.BigDecimal;

public record PlanResponse(Long idPlan, String nombre, BigDecimal precio, Integer duracionMeses, String estado) {
}
