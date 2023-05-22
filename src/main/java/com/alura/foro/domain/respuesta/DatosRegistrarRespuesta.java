/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Record.java to edit this template
 */
package com.alura.foro.domain.respuesta;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

/**
 *
 * @author Delian
 */
public record DatosRegistrarRespuesta(
        @NotBlank
        String mensaje, 
        @NotNull
        Long id_topico, 
        @NotNull
        Long id_usuario) {

}
