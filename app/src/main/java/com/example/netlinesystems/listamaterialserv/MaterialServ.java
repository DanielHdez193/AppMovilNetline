package com.example.netlinesystems.listamaterialserv;

public class MaterialServ {

    private int id, cantidad;
    private String nombre, descripcion;

    public MaterialServ() {
        id=0;
        nombre="";
        descripcion="";
        cantidad = 0;
    }

    public MaterialServ(int id, int cantidad, String nombre, String descripcion) {
        this.id = id;
        this.cantidad = cantidad;
        this.nombre = nombre;
        this.descripcion = descripcion;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getCantidad() {
        return cantidad;
    }

    public void setCantidad(int cantidad) {
        this.cantidad = cantidad;
    }
}
