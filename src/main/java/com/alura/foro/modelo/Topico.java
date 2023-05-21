package com.alura.foro.modelo;

import com.alura.foro.domain.topico.DatosModificarTopico;
import com.alura.foro.domain.topico.DatosRegistrotopico;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Table(name = "topicos")
@Entity(name = "Topico")
public class Topico {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id_topico;
    private String titulo;
    private String mensaje;
    private LocalDateTime fecha_creacion = LocalDateTime.now();
    @Enumerated(EnumType.STRING)
    private StatusTopico status = StatusTopico.NO_RESPONDIDO;
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "id_usuario")
    private Usuario autor;
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "id_curso")
    private Curso curso;
    @OneToMany( mappedBy = "topico")
    private List<Respuesta> respuestas = new ArrayList<>();

    public Topico() {

    }

    public Topico(String titulo, String mensaje, Curso curso) {
        this.titulo = titulo;
        this.mensaje = mensaje;
        this.curso = curso;
    }

    public Topico(DatosRegistrotopico datosRegistrotopico) {
        this.titulo = datosRegistrotopico.titulo();
        this.mensaje = datosRegistrotopico.mensaje();
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((id_topico == null) ? 0 : id_topico.hashCode());
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
        Topico other = (Topico) obj;
        if (id_topico == null) {
            if (other.id_topico != null) {
                return false;
            }
        } else if (!id_topico.equals(other.id_topico)) {
            return false;
        }
        return true;
    }

    public Long getId_topico() {
        return id_topico;
    }

    public void setId_topico(Long id_topico) {
        this.id_topico = id_topico;
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public String getMensaje() {
        return mensaje;
    }

    public void setMensaje(String mensaje) {
        this.mensaje = mensaje;
    }

    public LocalDateTime getfechaCreacion() {
        return fecha_creacion;
    }

    public void setfechaCreacion(LocalDateTime fechaCreacion) {
        this.fecha_creacion = fechaCreacion;
    }

    public StatusTopico getStatus() {
        return status;
    }

    public void setStatus(StatusTopico status) {
        this.status = status;
    }

    public Usuario getAutor() {
        return autor;
    }

    public void setAutor(Usuario autor) {
        this.autor = autor;
    }

    public Curso getCurso() {
        return curso;
    }

    public void setCurso(Curso curso) {
        this.curso = curso;
    }

    public List<Respuesta> getRespuestas() {
        return respuestas;
    }

    public void setRespuestas(List<Respuesta> respuestas) {
        this.respuestas = respuestas;
    }

    public void actualizarTopico(DatosModificarTopico datosMedificarTopico) {
        this.titulo = datosMedificarTopico.titulo();
        this.mensaje = datosMedificarTopico.mensaje();
        this.autor.setId_usuario(datosMedificarTopico.id_autor());
        this.curso.setId_curso(datosMedificarTopico.id_curso());
    }

}
