package com.forohub.api.domain.topico;

import com.forohub.api.domain.curso.Curso;
import com.forohub.api.domain.usuario.Usuario;

import java.time.LocalDate;
import java.time.LocalDateTime;

public record DatosDetalleTopico(
        Long id,
        String titulo,
        String mensaje,
        LocalDateTime fecha,
        Long autor,
        Long curso
) {
    public DatosDetalleTopico(Topico topico){
        this(topico.getId(), topico.getTitulo(),topico.getMensaje(),
                topico.getFecha(), topico.getAutor().getId(),
                topico.getCurso().getId());
    }
}
