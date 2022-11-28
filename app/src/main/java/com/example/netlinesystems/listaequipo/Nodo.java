package com.example.netlinesystems.listaequipo;

public class Nodo {

    private Equipo datos;
    private Nodo siguiente;

    public Nodo() {
        datos = null;
        siguiente = null;
    }

    public Equipo getDatos() {
        return datos;
    }

    public void setDatos(Equipo datos) {
        this.datos = datos;
    }

    public Nodo getSiguiente() {
        return siguiente;
    }

    public void setSiguiente(Nodo siguiente) {
        this.siguiente = siguiente;
    }
}
