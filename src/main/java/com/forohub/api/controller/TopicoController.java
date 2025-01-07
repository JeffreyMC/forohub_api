package com.forohub.api.controller;

import com.forohub.api.domain.topico.*;
import jakarta.transaction.Transactional;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
@RequestMapping("/topics")
public class TopicoController {
    @Autowired
    private GuardadoDeTopico guardadoDeTopico;
    @Autowired
    private TopicoRepository topicoRepository;

    //obtener todos los topicos o temas del foro
    @GetMapping
    public ResponseEntity<Page<DatosListadoTopicos>> listadoTopicos(Pageable paginacion) {
        return ResponseEntity.ok(topicoRepository.findAll(paginacion)
                .map(DatosListadoTopicos::new));
    }

    //registrar un nuevo topico
    @PostMapping
    @Transactional
    public ResponseEntity postear(@RequestBody @Valid DatosRegistroTopico datosRegistroTopico){
        var detalleTopico = guardadoDeTopico.guardarTopico(datosRegistroTopico);
        return ResponseEntity.ok(detalleTopico);
    }

    //obtener un topico mediante un id
    @GetMapping("/{id}")
    public ResponseEntity<DatosRespuestaTopico> obtenerTopico(@PathVariable Long id){
        Topico topico = topicoRepository.getReferenceById(id);

        var datosTopico = new DatosRespuestaTopico(
                topico.getId(), topico.getTitulo(), topico.getMensaje(), topico.getFecha(),
                topico.getAutor().getUsername(), topico.getCurso().getNombre()
        );

        return ResponseEntity.ok().body(datosTopico);
    }

    //editar un topico mediante un id
    @PutMapping("/{id}")
    @Transactional
    public ResponseEntity actualizarTopico(@RequestBody @Valid DatosActualizarTopico datosActualizarTopico, @PathVariable Long id){
        Optional<Topico> optionalTopico = topicoRepository.findById(id);
        if(optionalTopico.isPresent()){
            Topico topico = topicoRepository.getReferenceById(id);

            topico.actualizarDatos(datosActualizarTopico);

            return ResponseEntity.ok().body(new DatosRespuestaTopico(topico.getId(), topico.getTitulo(), topico.getMensaje(),
                    topico.getFecha(), topico.getAutor().getUsername(), topico.getCurso().getNombre()));
        }

        return ResponseEntity.badRequest().build();
    }

    //Eliminar un ropico
    @DeleteMapping("/{id}")
    public ResponseEntity eliminarTopico(@PathVariable Long id){
        Topico topico = topicoRepository.getReferenceById(id);
        topicoRepository.delete(topico);

        return ResponseEntity.noContent().build();
    }
}
