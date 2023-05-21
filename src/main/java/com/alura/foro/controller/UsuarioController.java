/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.alura.foro.controller;

import com.alura.foro.domain.usuario.DatosListadoUsuario;
import com.alura.foro.domain.usuario.DatosRegistroUsuario;
import com.alura.foro.domain.usuario.DatosUsuario;
import com.alura.foro.domain.usuario.DatosmodificarUsuario;
import com.alura.foro.modelo.Usuario;
import com.alura.foro.repository.UsuarioRepository;
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
@RequestMapping("/usuario")
public class UsuarioController {
    
    @Autowired
    private UsuarioRepository usuarioRepository;
    
    @PostMapping
    public void registrarUsuario(@RequestBody @Valid DatosRegistroUsuario datosRegistroUsuario){
        usuarioRepository.save(new Usuario(datosRegistroUsuario));
    }
    
    @GetMapping
    public ResponseEntity<Page<DatosListadoUsuario>> listarusUarios(Pageable paginacion) {
        return ResponseEntity.ok(usuarioRepository.findAll(paginacion).map(DatosListadoUsuario::new));
    }
    
    @GetMapping("/{id_usuario}")
    public ResponseEntity<DatosUsuario> datosUsuario(@PathVariable Long id_usuario){
        Usuario usuario = usuarioRepository.getReferenceById(id_usuario);
        var datosUsuario = new DatosUsuario(usuario.getNombre(), usuario.getEmail());
        return ResponseEntity.ok(datosUsuario);
    }
    
    @PutMapping("/{id_usuario}")
    @Transactional
    public ResponseEntity modificarUsuario(@PathVariable Long id_usuario, @RequestBody @Valid DatosmodificarUsuario datosmodificarUsuario){
        Usuario usuario = usuarioRepository.getReferenceById(id_usuario);
        usuario.actualizarUsuario(datosmodificarUsuario);
        return ResponseEntity.ok(new DatosUsuario(usuario.getNombre(), usuario.getEmail()));
    }
    
    @DeleteMapping("/{id_usuario}")
    @Transactional
    public void eliminarUsuario(@PathVariable Long id_usuario){
        usuarioRepository.deleteById(id_usuario);
    }
}
