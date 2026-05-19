package Modelos;
import java.util.Stack;

public class ReporteAcademico {

   
    double[][] notas = new double[10][20];

    // cantidad materias por semestre
    int[] cantidad = new int[10];

    
    Stack<String> pila = new Stack<>();


    
    public void guardarNota(int semestre, int materia, double nota) {

        notas[semestre][materia] = nota;

        if (materia + 1 > cantidad[semestre]) {

            cantidad[semestre] = materia + 1;
        }

        pila.push("Nota guardada");

        System.out.println("Nota registrada");
    }


    
    public void promedioSemestre(int semestre) {

        double suma = 0;

        for (int i = 0; i < cantidad[semestre]; i++) {

            suma = suma + notas[semestre][i];
        }

        double promedio = 0;

        if (cantidad[semestre] > 0) {

            promedio = suma / cantidad[semestre];
        }

        pila.push("Promedio semestre");

        System.out.println("Promedio: " + promedio);
    }


    
    public void promedioTotal() {

        double suma = 0;

        int total = 0;

        for (int i = 0; i < 10; i++) {

            for (int j = 0; j < cantidad[i]; j++) {

                suma = suma + notas[i][j];

                total++;
            }
        }

        double promedio = 0;

        if (total > 0) {

            promedio = suma / total;
        }

        pila.push("Promedio total");

        System.out.println("Promedio acumulado: " + promedio);
    }


    
    public void perdidas() {

        pila.push("Materias perdidas");

        System.out.println("MATERIAS PERDIDAS");

        for (int i = 0; i < 10; i++) {

            for (int j = 0; j < cantidad[i]; j++) {

                if (notas[i][j] < 3.0) {

                    System.out.println(
                            "Semestre " + i +
                            " Materia " + j +
                            " Nota " + notas[i][j]
                    );
                }
            }
        }
    }


    // historial
    public void historial() {

        if (pila.empty()) {

            System.out.println("No hay historial");

        } else {

            System.out.println("Historial:");

            for (int i = pila.size() - 1; i >= 0; i--) {

                System.out.println(pila.get(i));
            }
        }
    }


    // atras
    public void atras() {

        if (!pila.empty()) {

            String dato = pila.pop();

            System.out.println("Se elimino: " + dato);

        } else {

            System.out.println("No hay datos");
        }
    }
}