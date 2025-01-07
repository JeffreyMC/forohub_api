package com.forohub.api.domain.topico;

import java.time.LocalDateTime;

public record DatosRespuestaTopico(
        Long id,
        String titulo,
        String mensaje,
        LocalDateTime fecha,
        String autor,
        String curso
) {
    public DatosRespuestaTopico(Topico topico){
        this(topico.getId(), topico.getTitulo(),topico.getMensaje(),
                topico.getFecha(), topico.getAutor().getUsername(),
                topico.getCurso().getNombre());
    }
}
