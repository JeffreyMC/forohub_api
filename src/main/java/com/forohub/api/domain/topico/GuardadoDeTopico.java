package com.forohub.api.domain.topico;

import com.forohub.api.ValidacionException;
import com.forohub.api.domain.curso.Curso;
import com.forohub.api.domain.curso.CursoRepository;
import com.forohub.api.domain.usuario.Usuario;
import com.forohub.api.domain.usuario.UsuarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.Optional;

@Service
public class GuardadoDeTopico {
    @Autowired
    TopicoRepository topicoRepository;
    @Autowired
    CursoRepository cursoRepository;
    @Autowired
    UsuarioRepository usuarioRepository;

    public DatosDetalleTopico guardarTopico(DatosRegistroTopico datos) {
        if(!usuarioRepository.existsById(datos.autor())){
            throw new ValidacionException("No existe el autor con el id brindado");
        }
        if(!cursoRepository.existsById(datos.curso())){
            throw new ValidacionException("No existe el curso con el id brindado");
        }

        //si el titulo del mensaje ya existe da error
        if(topicoRepository.existsByTitulo(datos.titulo())){
            throw new ValidacionException("Ya existe un post con el mismo titulo");
        }

        //encuentra al autor
        Optional<Usuario> autor = usuarioRepository.findById(datos.autor());
        //encuentra el curso
        Optional<Curso> curso = cursoRepository.findById(datos.curso());

        //guarda los datos en una variable
        var nuevoTopico = new Topico(null, datos.titulo(), datos.mensaje(), LocalDateTime.now(),
                datos.status(), autor.orElse(null), curso.orElse(null));

        topicoRepository.save(nuevoTopico);

        return new DatosDetalleTopico(nuevoTopico);
    }
}
