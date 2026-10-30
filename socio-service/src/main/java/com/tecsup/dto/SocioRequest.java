package com.tecsup.dto;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;

public record SocioRequest(
        @NotBlank String dni,
        @NotBlank String nombres,
        @NotBlank String apellidos,
        @NotBlank String telefono,
        @NotBlank @Email String correo,
        String estado
) {
}
