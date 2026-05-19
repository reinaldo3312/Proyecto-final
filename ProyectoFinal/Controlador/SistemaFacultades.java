package Controlador;

import Modelos.Facultad;

public class SistemaFacultades {

    private Facultad facultades[] = new Facultad[5];

    public SistemaFacultades() {

        facultades[0] = new Facultad("Ingenieria");
        facultades[1] = new Facultad("Salud");
        facultades[2] = new Facultad("Derecho");
        facultades[3] = new Facultad("Educacion");
        facultades[4] = new Facultad("Artes");
    }

    public void mostrarFacultades() {

        System.out.println("=== FACULTADES ===");

        for (int i = 0; i < facultades.length; i++) {

            System.out.println((i + 1)
                    + ". "
                    + facultades[i].getNombre());
        }
    }
}