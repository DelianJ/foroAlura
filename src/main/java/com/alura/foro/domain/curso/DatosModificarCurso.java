/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Record.java to edit this template
 */
package com.alura.foro.domain.curso;

import jakarta.validation.constraints.NotBlank;

/**
 *
 * @author Delian
 */
public record DatosModificarCurso(
        @NotBlank
        String nombre,
        @NotBlank
        String categoria) {

}
