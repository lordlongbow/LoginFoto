package com.example.loginmasfoto.Modelos;

import java.io.Serializable;

public class Usuario  implements Serializable {
    public String nombre, apellido, email, password, foto;
    public Long dni;

    public Usuario() {
    }

    public Usuario(String nombre, String apellido, String email, String password, String foto, Long dni) {
        this.nombre = nombre;
        this.apellido = apellido;
        this.email = email;
        this.password = password;
        this.dni = dni;
        this.foto = foto;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getApellido() {
        return apellido;
    }

    public void setApellido(String apellido) {
        this.apellido = apellido;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getFoto(String foto) {
        return foto;
    }

    public void setFoto(String foto) {
        this.foto= foto;
    }
    public Long getDni() {
        return dni;
    }

    public void setDni(Long dni) {
        this.dni = dni;
    }

    @Override
    public String toString() {
        return "Usuario{" +
                "nombre='" + nombre + '\'' +
                ", apellido='" + apellido + '\'' +
                ", email='" + email + '\'' +
                ", password='" + password + '\'' +
                ", dni=" + dni +
                ", foto=" + foto +
                '}';
    }
}
