package Controlador;

import Modelos.GrafoEdificios;

public class SistemaRutas {

    private GrafoEdificios grafo;

    public SistemaRutas() {

        grafo = new GrafoEdificios();
    }

    public void mostrarEdificios() {

        grafo.mostrarEdificios();
    }

    public void calcularRuta(int inicio,
                             int destino) {

        grafo.calcularRutaCorta(inicio,
                                destino);
    }
}