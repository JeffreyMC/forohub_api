package com.forohub.api.domain.topico;

import com.forohub.api.domain.curso.Curso;
import com.forohub.api.domain.usuario.Usuario;

import java.time.LocalDateTime;

public record DatosListadoTopicos(
        Long id,
        String titulo,
        String mensaje,
        LocalDateTime fecha,
        String status,
        String autor,
        Curso curso

) {
    public DatosListadoTopicos(Topico topico){
        this(topico.getId(), topico.getTitulo(), topico.getMensaje(), topico.getFecha(),
                topico.getStatus().toString(), topico.getAutor().getUsername(), topico.getCurso());
    }
}
