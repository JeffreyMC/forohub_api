package com.forohub.api.domain.topico;

import com.forohub.api.domain.curso.Curso;
import jakarta.validation.constraints.NotNull;

import java.time.LocalDateTime;

public record DatosActualizarTopico(
        Long id,
        String titulo,
        String mensaje,
        Curso curso
) {
}
