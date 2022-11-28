package com.example.netlinesystems.listamaterialserv;

public class Nodo {

    private MaterialServ datos;
    private Nodo siguiente;

    public Nodo() {
        datos = null;
        siguiente = null;
    }

    public MaterialServ getDatos() {
        return datos;
    }

    public void setDatos(MaterialServ datos) {
        this.datos = datos;
    }

    public Nodo getSiguiente() {
        return siguiente;
    }

    public void setSiguiente(Nodo siguiente) {
        this.siguiente = siguiente;
    }
}
