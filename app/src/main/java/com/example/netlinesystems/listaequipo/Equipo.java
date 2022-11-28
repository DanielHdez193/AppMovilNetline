package com.example.netlinesystems.listaequipo;

public class Equipo {
    private int id;
    private String marca;
    private String modelo;
    private String noSerie;
    private String falla;

    public Equipo(){
        id = 0;
        marca = "";
        modelo = "";
        noSerie = "";
        falla = "";
    }
    public Equipo(int id, String marca, String modelo, String noSerie, String falla) {
        this.id = id;
        this.marca = marca;
        this.modelo = modelo;
        this.noSerie = noSerie;
        this.falla = falla;
    }


    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getMarca() {
        return marca;
    }

    public void setMarca(String marca) {
        this.marca = marca;
    }

    public String getModelo() {
        return modelo;
    }

    public void setModelo(String modelo) {
        this.modelo = modelo;
    }

    public String getNoSerie() {
        return noSerie;
    }

    public void setNoSerie(String noSerie) {
        this.noSerie = noSerie;
    }

    public String getFalla() {
        return falla;
    }

    public void setFalla(String falla) {
        this.falla = falla;
    }
}



