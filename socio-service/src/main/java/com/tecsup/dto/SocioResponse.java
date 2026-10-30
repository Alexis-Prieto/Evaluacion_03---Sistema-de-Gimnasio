package com.tecsup.dto;

public record SocioResponse(
        Long idSocio,
        String dni,
        String nombres,
        String apellidos,
        String telefono,
        String correo,
        String estado
) {
}
