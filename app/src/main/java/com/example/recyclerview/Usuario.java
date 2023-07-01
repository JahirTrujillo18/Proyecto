package com.example.recyclerview;

public class Usuario {
    private String username;
    private String password;
    private String nombres;
    private String apellidos;
    private String tipo;
    private String id_escuela;

    public Usuario(String username, String password, String nombres, String apellidos) {
        this.username = username;
        this.password = password;
        this.nombres = nombres;
        this.apellidos = apellidos;
        this.tipo = tipo;
        this.id_escuela = id_escuela;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getNombres() {
        return nombres;
    }

    public void setNombres(String nombres) {
        this.nombres = nombres;
    }

    public String getApellidos() {
        return apellidos;
    }

    public void setApellidos(String apellidos) {
        this.apellidos = apellidos;
    }

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    public String getId_escuela() {
        return id_escuela;
    }

    public void setId_escuela(String id_escuela) {
        this.id_escuela = id_escuela;
    }
}

