package Controlador;

import java.util.Stack;

import Modelos.Estudiante;
import Modelos.Materia;
import Modelos.Operacion;

public class SistemaPilas {

    private Stack<Operacion> pilaDeshacer;
    private Stack<Operacion> pilaRehacer;

    // guardar el sistema estudiantes
    private SistemaEstudiantes sistemaEstudiantes;

    public SistemaPilas(SistemaEstudiantes sistemaEstudiantes) {

        this.sistemaEstudiantes = sistemaEstudiantes;

        pilaDeshacer = new Stack<>();

        pilaRehacer = new Stack<>();
    }

    // GUARDAR OPERACION
    public void guardarOperacion(Operacion op) {

        pilaDeshacer.push(op);

        pilaRehacer.clear();
    }

    // DESHACER
    public void deshacer() {

        if (pilaDeshacer.isEmpty()) {

            System.out.println("No hay operaciones");

            return;
        }

        Operacion op = pilaDeshacer.pop();

        Estudiante est = op.getEstudiante();

        Materia mat = op.getMateria();

        if (op.getTipo().equals("INSCRIPCION")) {

            mat.getInscritos().remove(est);

            System.out.println("Inscripcion deshecha");
        }

        if (op.getTipo().equals("ELIMINAR")) {

            sistemaEstudiantes
                    .getMapaEstudiantes()
                    .put(est.getId(), est);

            System.out.println("Estudiante recuperado");
        }

        pilaRehacer.push(op);
    }

    // REHACER
    public void rehacer() {

        if (pilaRehacer.isEmpty()) {

            System.out.println("No hay operaciones");

            return;
        }

        Operacion op = pilaRehacer.pop();

        Estudiante est = op.getEstudiante();

        Materia mat = op.getMateria();

        if (op.getTipo().equals("INSCRIPCION")) {

            mat.getInscritos().add(est);

            System.out.println("Inscripcion rehecha");
        }

        if (op.getTipo().equals("ELIMINAR")) {

            sistemaEstudiantes
                    .getMapaEstudiantes()
                    .remove(est.getId());

            System.out.println("Estudiante eliminado otra vez");
        }

        pilaDeshacer.push(op);
    }
}