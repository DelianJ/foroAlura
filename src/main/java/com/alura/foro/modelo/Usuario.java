package com.alura.foro.modelo;

import com.alura.foro.domain.usuario.DatosRegistroUsuario;
import com.alura.foro.domain.usuario.DatosmodificarUsuario;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import java.util.ArrayList;
import java.util.List;

@Table(name = "usuarios")
@Entity(name = "Usuario")
public class Usuario {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id_usuario;
    private String nombre;
    private String email;
    private String contrasena;
    @OneToMany(fetch = FetchType.LAZY, mappedBy = "autor")
    private List<Topico> topicos;
    
    public Usuario(){
        
    }

    public Usuario(long autor) {
        this.id_usuario = autor;
    }

    public Usuario(DatosRegistroUsuario datosRegistroUsuario) {
        this.nombre = datosRegistroUsuario.nombre();
        this.email = datosRegistroUsuario.email();
        this.contrasena = datosRegistroUsuario.contrasena();
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((id_usuario == null) ? 0 : id_usuario.hashCode());
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
        Usuario other = (Usuario) obj;
        if (id_usuario == null) {
            if (other.id_usuario != null) {
                return false;
            }
        } else if (!id_usuario.equals(other.id_usuario)) {
            return false;
        }
        return true;
    }

    public Long getId_usuario() {
        return id_usuario;
    }

    public void setId_usuario(Long id_usuario) {
        this.id_usuario = id_usuario;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getContrasena() {
        return contrasena;
    }

    public void setContrasena(String contrasena) {
        this.contrasena = contrasena;
    }
    
    public void agregarTopicos(Topico topico){
        if (topicos == null) {
            topicos = new ArrayList<>();
        }
        topico.setAutor(this);
    }

    public void actualizarUsuario(DatosmodificarUsuario datosmodificarUsuario) {
        this.nombre = datosmodificarUsuario.nombre();
        this.email = datosmodificarUsuario.email();
        this.contrasena = datosmodificarUsuario.contrasena();
    }

}
