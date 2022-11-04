package com.example.lab4.Clases;

import com.example.lab4.Jugador;

public class JugadorDto {

    private Jugador[] lista;
    private String estado;

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }

    public Jugador[] getLista() {
        return lista;
    }

    public void setLista(Jugador[] lista) {
        this.lista = lista;
    }
}
