package Controlador;

import java.util.HashMap;

import Modelos.Estudiante;

public class SistemaEstudiantes {

    private HashMap<Integer, Estudiante> estudiantes;

    
    public HashMap<Integer, Estudiante> getMapaEstudiantes() {

        return estudiantes;
    }

   
    public SistemaEstudiantes() {

        estudiantes = new HashMap<>();
    }


    public void registrarEstudiante(Estudiante estudiante) {

        estudiantes.put(estudiante.getId(), estudiante);

        System.out.println("Estudiante registrado correctamente");
    }

    
    public Estudiante buscarEstudiante(int id) {

        return estudiantes.get(id);
    }

    
    public void eliminarEstudiante(int id) {

        if (estudiantes.containsKey(id)) {

            estudiantes.remove(id);

            System.out.println("Estudiante eliminado");

        } else {

            System.out.println("El estudiante no existe");
        }
    }

    
    public void listarEstudiantes() {

        if (estudiantes.isEmpty()) {

            System.out.println("No hay estudiantes registrados");

            return;
        }

        for (Estudiante estudiante : estudiantes.values()) {

            System.out.println("ID: "
                    + estudiante.getId());

            System.out.println("Nombre: "
                    + estudiante.getNombre());

            System.out.println("Email: "
                    + estudiante.getEmail());

            System.out.println("Semestre: "
                    + estudiante.getSemestre());

            System.out.println("----------------------");
        }
    }
}