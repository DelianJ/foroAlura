/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.alura.foro.controller;

import com.alura.foro.domain.topico.DatosListadoTopico;
import com.alura.foro.domain.topico.DatosModificarTopico;
import com.alura.foro.domain.topico.DatosRegistrotopico;
import com.alura.foro.domain.topico.DatosTopico;
import com.alura.foro.modelo.Curso;
import com.alura.foro.modelo.Topico;
import com.alura.foro.modelo.Usuario;
import com.alura.foro.repository.TopicoRepository;
import jakarta.transaction.Transactional;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 *
 * @author Delian
 */
@RestController
@RequestMapping("/topicos")
public class TopicoController {

    @Autowired
    private TopicoRepository topicoRepository;

    @PostMapping
    public void registrarTopico(@RequestBody @Valid DatosRegistrotopico datosRegistrotopico) {
        var usuario = new Usuario(datosRegistrotopico.id_autor());
        var curso = new Curso(datosRegistrotopico.id_curso());

        var topico = new Topico(datosRegistrotopico);

        usuario.agregarTopicos(topico);
        curso.agregarTopicos(topico);

        topicoRepository.save(topico);
    }

    @GetMapping
    public ResponseEntity<Page<DatosListadoTopico>> listarTopicos(Pageable paginacion) {
        return ResponseEntity.ok(topicoRepository.findAll(paginacion).map(DatosListadoTopico::new));
    }

    @GetMapping("/{id_topico}")
    public ResponseEntity<DatosTopico> datosTopico(@PathVariable Long id_topico) {
        Topico topico = topicoRepository.getReferenceById(id_topico);
        var datosTopico = new DatosTopico(topico.getTitulo(), topico.getMensaje(),
                topico.getfechaCreacion(), topico.getStatus().toString(), topico.getAutor().getNombre(),
                topico.getCurso().getNombre());
        return ResponseEntity.ok(datosTopico);
    }

    @PutMapping("/{id_topico}")
    @Transactional
    public ResponseEntity modificarTopico(@RequestBody @Valid DatosModificarTopico datosModificarTopico, @PathVariable Long id_topico) {
        Topico topico = topicoRepository.getReferenceById(id_topico);
        topico.actualizarTopico(datosModificarTopico);
        return ResponseEntity.ok(new DatosTopico(topico.getTitulo(), topico.getMensaje(),
                topico.getfechaCreacion(), topico.getStatus().toString(), topico.getAutor().getNombre(),
                topico.getCurso().getNombre()));
    }
    
    @DeleteMapping("/{id_topico}")
    @Transactional
    public void eliminarTopico(@PathVariable Long id_topico){
        topicoRepository.deleteById(id_topico);
    }
}
