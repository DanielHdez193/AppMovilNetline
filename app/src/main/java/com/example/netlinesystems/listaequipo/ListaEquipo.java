package com.example.netlinesystems.listaequipo;

public class ListaEquipo {

    private Nodo inicio;
    private int contador;

    public ListaEquipo() {
        inicio = null;
        contador = 0;
    }

    public ListaEquipo(Nodo inicio, int contador) {
        this.inicio = inicio;
        this.contador = contador;
    }

    public int getContador() {
        return contador;
    }

    public void setContador(int contador) {
        this.contador = contador;
    }

    public boolean esVacia() {
        return inicio == null;
    }

    public void agregar(Equipo dato) {
        Nodo nuevo = new Nodo();

        nuevo.setDatos(dato);

        if (esVacia()) {
            inicio = nuevo;
        } else {
            Nodo aux = inicio;
            while (aux.getSiguiente() != null) {
                aux = aux.getSiguiente();
            }
            aux.setSiguiente(nuevo);
        }
        contador++;
    }

    public String mostrar() {
        String Lista = "Id Equipo / Marca / Modelo / No. Serie / Falla \n";
        int cont = 1;
        if (!esVacia()) {
            Nodo aux = inicio;
            System.out.println("Id Equipo / Marca / Modelo / No. Serie / Falla ");
            while (aux != null) {
                System.out.print(aux.getDatos().getId() + " / " + aux.getDatos().getMarca() + " / " + aux.getDatos().getModelo() + " / " + aux.getDatos().getNoSerie() + "\n");
                Lista = Lista + cont + " / " + aux.getDatos().getMarca() + " / " + aux.getDatos().getModelo() + " / " + aux.getDatos().getNoSerie() + " / " + aux.getDatos().getFalla() + "\n";
                cont++;
                aux = aux.getSiguiente();
            }
        } else {
            System.out.println("No tiene ningun equipo registrado");
            Lista = "No tiene ningun equipo registrado";
        }
        return Lista;
    }

    public void modificar(int posicion, String noSerie, String falla) {
        boolean encontrado = false;
        if (posicion >= 0 && posicion <= contador) {
            if (posicion == 1) {
                //System.out.println("Ingresa la cantidad");
                inicio.getDatos().setNoSerie(noSerie);
                inicio.getDatos().setFalla(falla);
            } else {
                Nodo aux = inicio;
                while (encontrado != true) {
                    if (aux.getDatos().getId() == posicion) {
                        encontrado = true;
                    } else {
                        aux = aux.getSiguiente();
                    }
                }
                //System.out.println("Ingresa la cantidad")
                aux.getDatos().setNoSerie(noSerie);
                aux.getDatos().setFalla(falla);
                aux.getDatos();
            }
            System.out.println("Material Modificado");
        } else {
            System.out.println("Material no encontrado");
        }
    }

    public Nodo buscar(int posicion) {
        Nodo aux = inicio;
        boolean encontrado = false;
        while (aux != null && encontrado != true) {
            if (posicion == aux.getDatos().getId()) {
                encontrado = true;
            } else {
                aux = aux.getSiguiente();
            }
        }
        if (encontrado == true) {
            System.out.println("Equipo encontrado");
            System.out.println("**Información del material**");
            System.out.println("Id: " + aux.getDatos().getId());
            System.out.println("Marca: " + aux.getDatos().getMarca());
            System.out.println("Modelo: " + aux.getDatos().getModelo());
            System.out.println("Numero de serie: " + aux.getDatos().getNoSerie());
            System.out.println("Falla: " + aux.getDatos().getFalla());
            return aux;
        } else {
            System.out.println("Equipo no encontrado, vuelva a intentarlo");
            return null;
        }
    }

    public void eliminar(int posicion) {
        boolean encontrado = false;
        if (posicion >= 0 && posicion <= contador) {
            if (posicion == 1) {
                inicio = inicio.getSiguiente();
            } else {
                Nodo ant = inicio;
                Nodo aux = inicio.getSiguiente();
                while (encontrado != true) {
                    if (aux.getDatos().getId() == posicion) {
                        encontrado = true;
                    } else {
                        ant = ant.getSiguiente();
                        aux = aux.getSiguiente();
                    }
                }
                ant.setSiguiente(aux.getSiguiente());
                aux.setSiguiente(null);
            }
            contador--;
            System.out.println("Equipo eliminado");
        } else {
            System.out.println("No existe ese equipo");
        }
    }
}
