/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.alura.foro.controller;

import com.alura.foro.domain.usuario.DatosAutenticacionUsuario;
import com.alura.foro.infra.security.DatosJWTToken;
import com.alura.foro.infra.security.TokenService;
import com.alura.foro.modelo.Usuario;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 *
 * @author Delian
 */
@RestController
@RequestMapping("/login")
public class AutenticacionController {
    
    @Autowired
    private AuthenticationManager authenticactionManager;
    
    @Autowired
    private TokenService tokenService;
    
    @PostMapping
    public ResponseEntity autenticarUsuario(@RequestBody @Valid DatosAutenticacionUsuario autenticacionUsuario){
        Authentication authenticationtoken = new UsernamePasswordAuthenticationToken(autenticacionUsuario.nombre(),
                autenticacionUsuario.contrasena());
        var usuarioAutenticado = authenticactionManager.authenticate(authenticationtoken);
        var jwtToken = tokenService.generarToken((Usuario) usuarioAutenticado.getPrincipal());
        return ResponseEntity.ok(new DatosJWTToken(jwtToken));
    }
}
