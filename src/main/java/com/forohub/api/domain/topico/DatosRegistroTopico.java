package com.forohub.api.domain.topico;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

import java.time.LocalDateTime;

public record DatosRegistroTopico(
        @NotBlank
        String titulo,
        @NotBlank
        String mensaje,

        LocalDateTime fecha,
        @NotNull
        Status status,
        @NotNull
        Long autor,
        @NotNull
        Long curso
) {
}
