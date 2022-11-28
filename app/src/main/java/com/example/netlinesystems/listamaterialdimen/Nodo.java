package com.example.netlinesystems.listamaterialdimen;

public class Nodo {

    private MaterialDimen datos;
    private Nodo siguiente;

    public Nodo() {
        datos = null;
        siguiente = null;
    }

    public Nodo(MaterialDimen datos, Nodo siguiente) {
        this.datos = datos;
        this.siguiente = siguiente;
    }

    public MaterialDimen getDatos() {
        return datos;
    }

    public void setDatos(MaterialDimen datos) {
        this.datos = datos;
    }

    public Nodo getSiguiente() {
        return siguiente;
    }

    public void setSiguiente(Nodo siguiente) {
        this.siguiente = siguiente;
    }
}
