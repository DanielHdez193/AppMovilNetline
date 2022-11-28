package com.example.netlinesystems.servidor;

public class Cliente {

    private String id;
    private String nombre, tipo, responsable, telefono, email, direcion, rfc, nota, foto, estatus;

    public Cliente(String id, String nombre, String tipo, String responsable, String telefono, String email, String direcion, String rfc, String nota, String foto, String estatus) {
        this.id = id;
        this.nombre = nombre;
        this.tipo = tipo;
        this.responsable = responsable;
        this.telefono = telefono;
        this.email = email;
        this.direcion = direcion;
        this.rfc = rfc;
        this.nota = nota;
        this.foto = foto;
        this.estatus = estatus;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    public String getResponsable() {
        return responsable;
    }

    public void setResponsable(String responsable) {
        this.responsable = responsable;
    }

    public String getTelefono() {
        return telefono;
    }

    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getDirecion() {
        return direcion;
    }

    public void setDirecion(String dirrecion) {
        this.direcion = dirrecion;
    }

    public String getRfc() {
        return rfc;
    }

    public void setRfc(String rfc) {
        this.rfc = rfc;
    }

    public String getNota() {
        return nota;
    }

    public void setNota(String nota) {
        this.nota = nota;
    }

    public String getFoto() {
        return foto;
    }

    public void setFoto(String foto) {
        this.foto = foto;
    }

    public String getEstatus() {
        return estatus;
    }

    public void setEstatus(String estatus) {
        this.estatus = estatus;
    }
}
