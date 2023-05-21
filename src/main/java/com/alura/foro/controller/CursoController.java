/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.alura.foro.controller;

import com.alura.foro.domain.curso.DatosCurso;
import com.alura.foro.domain.curso.DatosListarCursos;
import com.alura.foro.domain.curso.DatosModificarCurso;
import com.alura.foro.domain.curso.DatosRegistarCurso;
import com.alura.foro.modelo.Curso;
import com.alura.foro.repository.CursoRepository;
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
@RequestMapping("/cursos")
public class CursoController {
   
    @Autowired
    private CursoRepository cursoRepository;
    
    @PostMapping
    public void registrarCurso(@RequestBody @Valid DatosRegistarCurso datosRegistroCurso){
        cursoRepository.save(new Curso(datosRegistroCurso));
    }
    
    @GetMapping
    public ResponseEntity<Page<DatosListarCursos>> listarCursos(Pageable paginacion){
        return ResponseEntity.ok(cursoRepository.findAll(paginacion).map(DatosListarCursos::new));
    }
    
    @GetMapping("/{id_curso}")
    public ResponseEntity<DatosCurso> datosUsuario(@PathVariable Long id_curso){
        Curso curso = cursoRepository.getReferenceById(id_curso);
        var datosCurso = new DatosCurso(curso.getNombre(), curso.getCategoria());
        return ResponseEntity.ok(datosCurso);
    }
    
    @PutMapping("/{id_curso}")
    @Transactional
    public ResponseEntity modificarCurso(@PathVariable Long id_curso, @RequestBody @Valid DatosModificarCurso datosModificarCurso){
        Curso curso = cursoRepository.getReferenceById(id_curso);
        curso.actualizarCurso(datosModificarCurso);
        return ResponseEntity.ok(new DatosCurso(curso.getNombre(), curso.getCategoria()));
    }
    
    @DeleteMapping("/{id_curso}")
    @Transactional
    public void eliminarCurso(@PathVariable Long id_curso){
        cursoRepository.deleteById(id_curso);
    }
}
