package com.example.netlinesystems.listamaterialdimen;

public class MaterialDimen {

    private int id, cantidad;
    private String descripcion, unidad;

    public MaterialDimen(){
        id=0;
        cantidad=0;
        descripcion="";
        unidad="";
    }

    public MaterialDimen(int id, int idDimen, int cantidad, String descripcion, String unidad) {
        this.id = id;
        this.cantidad = cantidad;
        this.descripcion = descripcion;
        this.unidad = unidad;
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

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public String getUnidad() {
        return unidad;
    }

    public void setUnidad(String unidad) {
        this.unidad = unidad;
    }
}
