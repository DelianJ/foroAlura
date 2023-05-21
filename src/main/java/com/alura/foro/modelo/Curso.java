package com.alura.foro.modelo;

import com.alura.foro.domain.curso.DatosModificarCurso;
import com.alura.foro.domain.curso.DatosRegistarCurso;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import java.util.ArrayList;
import java.util.List;

@Table(name = "cursos")
@Entity(name = "Curso")
public class Curso {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id_curso;
    private String nombre;
    private String categoria;
    @OneToMany(fetch = FetchType.LAZY, mappedBy = "curso")
    private List<Topico> topicos;

    public Curso(){
        
    }
    
    public Curso(String nombre, String categoria) {
        this.nombre = nombre;
        this.categoria = categoria;
    }

    public Curso(long curso) {
        this.id_curso = curso;
    }

    public Curso(DatosRegistarCurso datosRegistroCurso) {
        this.nombre = datosRegistroCurso.nombre();
        this.categoria = datosRegistroCurso.categoria();
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((id_curso == null) ? 0 : id_curso.hashCode());
        return result;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        Curso other = (Curso) obj;
        if (id_curso == null) {
            if (other.id_curso != null) {
                return false;
            }
        } else if (!id_curso.equals(other.id_curso)) {
            return false;
        }
        return true;
    }

    public Long getId_curso() {
        return id_curso;
    }

    public void setId_curso(Long id_curso) {
        this.id_curso = id_curso;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getCategoria() {
        return categoria;
    }

    public void setCategoria(String categoria) {
        this.categoria = categoria;
    }
    
    public void agregarTopicos(Topico topico){
        if (topicos == null) {
            topicos = new ArrayList<>();
        }
        topico.setCurso(this);
    }

    public void actualizarCurso(DatosModificarCurso datosModificarCurso) {
        this.nombre = datosModificarCurso.nombre();
        this.categoria = datosModificarCurso.categoria();
    }

}
