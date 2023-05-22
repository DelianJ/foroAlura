/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Record.java to edit this template
 */
package com.alura.foro.domain.respuesta;

import com.alura.foro.modelo.Respuesta;
import java.time.LocalDateTime;

/**
 *
 * @author Delian
 */
public record DatosListarRespuesta(String mensaje, String mensajeTopico, LocalDateTime fechaCreacion, String nombre, boolean solucion) {
    public DatosListarRespuesta(Respuesta respuesta){
        this(respuesta.getMensaje(), respuesta.getTopico().getTitulo(), respuesta.getfechaCreacion(), respuesta.getAutor().getNombre(), respuesta.getSolucion());
    }
}
