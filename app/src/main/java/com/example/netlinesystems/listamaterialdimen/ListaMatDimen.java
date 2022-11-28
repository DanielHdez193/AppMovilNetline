package com.example.netlinesystems.listamaterialdimen;

public class ListaMatDimen {
    private Nodo inicio;
    private int contador;

    public ListaMatDimen() {
        inicio = null;
        contador = 0;
    }

    public ListaMatDimen(Nodo inicio, int contador) {
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

    public void agregar(MaterialDimen dato) {
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
        String Lista = "Id / Cantidad / Descripcion / Unidad \n";
        int cont = 1;
        if (!esVacia()) {
            Nodo aux = inicio;
            System.out.println("Id / Cantidad / Descripcion / Unidad ");
            while (aux != null) {
                System.out.print(aux.getDatos().getId() + " / " + aux.getDatos().getCantidad() + " / " + aux.getDatos().getDescripcion() + " / " + aux.getDatos().getUnidad() + "\n");
                Lista = Lista + cont + " / " + aux.getDatos().getId() + " / " + aux.getDatos().getCantidad() + " / " + aux.getDatos().getDescripcion() + " / " + aux.getDatos().getUnidad() + "\n";
                cont++;
                aux = aux.getSiguiente();
            }
        } else {
            System.out.println("No tiene ningun producto registrado");
            Lista = "No tiene ningun producto registrado";
        }
        return Lista;
    }

    public void modificar(int posicion, int cantidad) {
        boolean encontrado = false;
        if (posicion >= 0 && posicion <= contador) {
            if (posicion == 1) {
                //System.out.println("Ingresa la cantidad");
                inicio.getDatos().setCantidad(cantidad);
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
                aux.getDatos().setCantidad(cantidad);
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
            System.out.println("Material encontrado");
            System.out.println("**Información del material**");
            System.out.println("Id: " + aux.getDatos().getId());
            System.out.println("Unidad: " + aux.getDatos().getUnidad());
            System.out.println("Cantidad: " + aux.getDatos().getCantidad());
            System.out.println("Descripcion: " + aux.getDatos().getDescripcion());
            return aux;
        } else {
            System.out.println("Material no encontrado, vuelva a intentarlo");
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
            System.out.println("Material eliminado");
        } else {
            System.out.println("No existe ese material");
        }
    }
}
