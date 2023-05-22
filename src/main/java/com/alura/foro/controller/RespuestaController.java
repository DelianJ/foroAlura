/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.alura.foro.controller;

import com.alura.foro.domain.respuesta.DatosListarRespuesta;
import com.alura.foro.domain.respuesta.DatosRegistrarRespuesta;
import com.alura.foro.modelo.Respuesta;
import com.alura.foro.repository.RespuestaRepository;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 *
 * @author Delian
 */
@RestController
@RequestMapping("/respuestas")
public class RespuestaController {
    
    @Autowired
    private RespuestaRepository respuestaRepository;
    
    @PostMapping
    public void registrarRespuesta(@RequestBody @Valid DatosRegistrarRespuesta datosRegistrarRespuesta){
        respuestaRepository.save(new Respuesta(datosRegistrarRespuesta));
    }
    
    @GetMapping
    public ResponseEntity<Page<DatosListarRespuesta>> datosListarRespuesta(Pageable paginacion){
        return ResponseEntity.ok(respuestaRepository.findAll(paginacion).map(DatosListarRespuesta::new));
    }
    
}
