/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package com.alura.foro.repository;

import com.alura.foro.modelo.Respuesta;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 *
 * @author Delian
 */
public interface RespuestaRepository extends JpaRepository<Respuesta, Long>{
    
}
