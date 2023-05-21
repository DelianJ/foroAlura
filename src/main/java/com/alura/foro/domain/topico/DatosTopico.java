/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Record.java to edit this template
 */
package com.alura.foro.domain.topico;

import java.time.LocalDateTime;

/**
 *
 * @author Delian
 */
public record DatosTopico(String titulo, String mensaje, LocalDateTime fecha_creacion,
        String status, String nombre_usuario, String nombre_curso) {

}
