package com.example.myapplicationlv;

import java.io.Serializable;

public class Persona implements Serializable {
    private String nombre;
    private String numero;
    private int codigo;


    public Persona(String nombre, String numero, int codigo) {
        this.nombre = nombre;
        this.numero = numero;
        this.codigo=codigo;

    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getNumero() {
        return numero;
    }

    public void setNumero(String numero) {
        this.numero = numero;
    }

    public int getCodigo() {
        return codigo;
    }

    public void setCodigo(int codigo) {
        this.codigo = codigo;
    }
}
