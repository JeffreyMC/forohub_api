package com.forohub.api.controller;

import com.forohub.api.domain.topico.*;
import jakarta.transaction.Transactional;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/topics")
public class TopicoController {
    @Autowired
    private GuardadoDeTopico guardadoDeTopico;
    @Autowired
    private TopicoRepository topicoRepository;

    @GetMapping
    public ResponseEntity<Page<DatosListadoTopicos>> listadoTopicos(Pageable paginacion) {
        return ResponseEntity.ok(topicoRepository.findAll(paginacion)
                .map(DatosListadoTopicos::new));
    }

    @PostMapping
    @Transactional
    public ResponseEntity postear(@RequestBody @Valid DatosRegistroTopico datosRegistroTopico){
        var detalleTopico = guardadoDeTopico.guardarTopico(datosRegistroTopico);
        return ResponseEntity.ok(detalleTopico);
    }
}
