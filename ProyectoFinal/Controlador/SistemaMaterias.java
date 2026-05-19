package Controlador;

import java.util.HashMap;

import Modelos.Materia;

public class SistemaMaterias {

    private HashMap<String, Materia> materias;

    public SistemaMaterias() {

        materias = new HashMap<>();
    }

    public void crearMateria(Materia materia) {

        materias.put(materia.getCodigo(), materia);

        System.out.println("Materia creada correctamente");
    }

    public Materia buscarMateria(String codigo) {

        return materias.get(codigo);
    }

    public void agregarPreRequisito(String codigoMateria,
                                    String preRequisito) {

        Materia materia = materias.get(codigoMateria);

        if (materia != null) {

            materia.getPreRequisitos().add(preRequisito);

            System.out.println("Pre-requisito agregado correctamente");

        } else {

            System.out.println("La materia no existe");
        }
    }

    public void mostrarPreRequisitos(String codigoMateria) {

        Materia materia = materias.get(codigoMateria);

        if (materia != null) {

            System.out.println("=== PRE-REQUISITOS ===");

            for (String pre : materia.getPreRequisitos()) {

                System.out.println("- " + pre);
            }

        } else {

            System.out.println("La materia no existe");
        }
    }

    public void mostrarMaterias() {

        System.out.println("=== LISTA DE MATERIAS ===");

        for (Materia materia : materias.values()) {

            System.out.println("Codigo: "
                    + materia.getCodigo());

            System.out.println("Nombre: "
                    + materia.getNombre());

            System.out.println("Cupos: "
                    + materia.getCupos());

            System.out.println("----------------------");
        }
    }
}