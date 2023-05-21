/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Record.java to edit this template
 */
package com.alura.foro.domain.curso;

import com.alura.foro.modelo.Curso;

/**
 *
 * @author Delian
 */
public record DatosListarCursos(String nombre, String categoria) {

    public DatosListarCursos(Curso curso){
        this(curso.getNombre(), curso.getCategoria());
    }
}
