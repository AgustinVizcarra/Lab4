package com.example.lab4;

public class Jugador {
    private String nombreEquipo;
    private String apellidoJugador;
    private String nombreJugador;
    private String hitoJugador;

    public Jugador(String nombreEquipo, String apellidoJugador, String nombreJugador, String hitoJugador) {
        this.nombreEquipo = nombreEquipo;
        this.apellidoJugador = apellidoJugador;
        this.nombreJugador = nombreJugador;
        this.hitoJugador = hitoJugador;
    }

    public String getNombreEquipo() {
        return nombreEquipo;
    }

    public void setNombreEquipo(String nombreEquipo) {
        this.nombreEquipo = nombreEquipo;
    }

    public String getApellidoJugador() {
        return apellidoJugador;
    }

    public void setApellidoJugador(String apellidoJugador) {
        this.apellidoJugador = apellidoJugador;
    }

    public String getNombreJugador() {
        return nombreJugador;
    }

    public void setNombreJugador(String nombreJugador) {
        this.nombreJugador = nombreJugador;
    }

    public String getHitoJugador() {
        return hitoJugador;
    }

    public void setHitoJugador(String hitoJugador) {
        this.hitoJugador = hitoJugador;
    }
}
