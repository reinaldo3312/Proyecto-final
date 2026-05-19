package Modelos;

import java.util.LinkedList;
import java.util.Queue;

public class Materia {

    private String codigo;
    private String nombre;
    private int cupos;
    private int creditos;

    private LinkedList<String> preRequisitos;

    private Queue<Estudiante> colaEspera;

   
    private LinkedList<Estudiante> inscritos;

    public Materia(String codigo,
                   String nombre,
                   int cupos,
                   int creditos) {

        this.codigo = codigo;
        this.nombre = nombre;
        this.cupos = cupos;
        this.creditos = creditos;

        preRequisitos = new LinkedList<>();

        colaEspera = new LinkedList<>();

        inscritos = new LinkedList<>();
    }

    public String getCodigo() {
        return codigo;
    }

    public String getNombre() {
        return nombre;
    }

    public int getCupos() {
        return cupos;
    }

    public void setCupos(int cupos) {
        this.cupos = cupos;
    }

    public int getCreditos() {
        return creditos;
    }

    public LinkedList<String> getPreRequisitos() {
        return preRequisitos;
    }

    public Queue<Estudiante> getColaEspera() {
        return colaEspera;
    }

    
    public LinkedList<Estudiante> getInscritos() {
        return inscritos;
    }

    public void agregarPreRequisito(String materia) {

        preRequisitos.add(materia);
    }

    
    public void inscribirEstudiante(Estudiante estudiante) {

        if (inscritos.size() < cupos) {

            inscritos.add(estudiante);

            System.out.println("Inscripcion exitosa");

        } else {

            colaEspera.add(estudiante);

            System.out.println("Materia llena");

            System.out.println("Estudiante enviado a cola");
        }
    }

    
    public void cancelarInscripcion(Estudiante estudiante) {

        inscritos.remove(estudiante);

        System.out.println("Inscripcion cancelada");

        if (!colaEspera.isEmpty()) {

            Estudiante siguiente = colaEspera.poll();

            inscritos.add(siguiente);

            System.out.println("Cupo asignado a "
                    + siguiente.getNombre());
        }
    }
}