package com.example.recyclerview;

import androidx.room.Entity;
import androidx.room.PrimaryKey;

@Entity
public class Correo {
    @PrimaryKey(autoGenerate = true)
    private  int id;
    private String remitente;
    private String asunto;
    private String mensaje;


    public Correo(String remitente, String asunto, String mensaje) {
        this.remitente = remitente;
        this.asunto = asunto;
        this.mensaje = mensaje;
    }

    public String getRemitente() {
        return remitente;
    }

    public void setRemitente(String remitente) {
        this.remitente = remitente;
    }

    public String getAsunto() {
        return asunto;
    }

    public void setAsunto(String asunto) {
        this.asunto = asunto;
    }

    public String getMensaje() {
        return mensaje;
    }

    public void setMensaje(String mensaje) {
        this.mensaje = mensaje;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }
}