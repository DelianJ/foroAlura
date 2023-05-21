/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Record.java to edit this template
 */
package com.alura.foro.domain.usuario;

import com.alura.foro.modelo.Usuario;

/**
 *
 * @author Delian
 */
public record DatosListadoUsuario(String nombre, String email) {

    public DatosListadoUsuario(Usuario usuario){
        this(usuario.getNombre(), usuario.getEmail());
    }
}
