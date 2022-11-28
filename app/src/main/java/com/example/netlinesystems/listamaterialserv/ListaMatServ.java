package com.example.netlinesystems.listamaterialserv;

public class ListaMatServ {
    private Nodo inicio;
    private int contador;

    public ListaMatServ() {
        inicio = null;
        contador = 0;
    }

    public ListaMatServ(Nodo inicio, int contador) {
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

    public void agregar(MaterialServ dato) {
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
        String Lista = "Id / Producto / Cantidad \n";
        int cont = 1;
        if (!esVacia()) {
            Nodo aux = inicio;
            System.out.println("Id / Producto / Cantidad ");
            while (aux != null) {
                System.out.print(aux.getDatos().getId() + " / " + aux.getDatos().getNombre() + " / " + aux.getDatos().getCantidad() + "\n");
                Lista = Lista + cont + " / " + aux.getDatos().getNombre() + " / " + aux.getDatos().getCantidad() + "\n";
                cont++;
                aux = aux.getSiguiente();
            }
        } else {
            System.out.println("No tiene ningun producto registrado");
            Lista = "No tiene ningun producto agregado";
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
            System.out.println("Producto: " + aux.getDatos().getNombre());
            System.out.println("Cantidad: " + aux.getDatos().getCantidad());
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
