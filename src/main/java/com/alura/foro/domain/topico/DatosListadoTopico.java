/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Record.java to edit this template
 */
package com.alura.foro.domain.topico;

import com.alura.foro.modelo.Topico;
import java.time.LocalDateTime;

/**
 *
 * @author Delian
 */
public record DatosListadoTopico(String titulo, String mensaje, LocalDateTime fecha_creacion,
        String status, String nombre_usuario, String nombre_curso) {

    public DatosListadoTopico(Topico topico) {
        this(topico.getTitulo(), topico.getMensaje(), topico.getfechaCreacion(),
                topico.getStatus().toString(), topico.getAutor().getNombre(), topico.getCurso().getNombre());
    }
}
