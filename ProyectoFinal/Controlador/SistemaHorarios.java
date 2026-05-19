package Controlador;

import java.util.TreeMap;

import Modelos.Aula;

public class SistemaHorarios {

    private TreeMap<String, Aula> aulas;

    public SistemaHorarios() {

        aulas = new TreeMap<>();

        aulas.put("A101", new Aula("A101"));
        aulas.put("A102", new Aula("A102"));
        aulas.put("B201", new Aula("B201"));
    }

    public void mostrarAulas() {

        System.out.println("=== AULAS DISPONIBLES ===");

        for (Aula aula : aulas.values()) {

            System.out.println(aula.getNombre());
        }
    }

    public void reservarHorario(String aula,
                                 int dia,
                                 int hora,
                                 int duracion) {

        Aula aulaBuscada = aulas.get(aula);

        if (aulaBuscada != null) {

            boolean reservado =
                    aulaBuscada.reservar(dia,
                                         hora,
                                         duracion);

            if (reservado) {

                System.out.println("Reserva exitosa");

            } else {

                System.out.println("Horario ocupado");
            }

        } else {

            System.out.println("El aula no existe");
        }
    }

    public void liberarHorario(String aula,
                               int dia,
                               int hora,
                               int duracion) {

        Aula aulaBuscada = aulas.get(aula);

        if (aulaBuscada != null) {

            aulaBuscada.liberar(dia,
                                hora,
                                duracion);

            System.out.println("Horario liberado");

        } else {

            System.out.println("El aula no existe");
        }
    }

    public void consultarDisponibilidad(String aula,
                                        int dia,
                                        int hora) {

        Aula aulaBuscada = aulas.get(aula);

        if (aulaBuscada != null) {

            boolean disponible =
                    aulaBuscada.consultarDisponibilidad(dia,
                                                        hora);

            if (disponible) {

                System.out.println("Horario disponible");

            } else {

                System.out.println("Horario ocupado");
            }

        } else {

            System.out.println("El aula no existe");
        }
    }
}