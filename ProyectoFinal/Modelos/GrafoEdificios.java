package Modelos;

public class GrafoEdificios {

    private String edificios[] = {

        "Ingenieria",
        "Biblioteca",
        "Cafeteria",
        "Rectoria",
        "Laboratorios"
    };

    private int matriz[][] = new int[5][5];

    public GrafoEdificios() {

        matriz[0][1] = 100;
        matriz[1][0] = 100;

        matriz[0][2] = 150;
        matriz[2][0] = 150;

        matriz[1][3] = 200;
        matriz[3][1] = 200;

        matriz[2][4] = 120;
        matriz[4][2] = 120;

        matriz[3][4] = 170;
        matriz[4][3] = 170;
    }

    public void mostrarEdificios() {

        System.out.println("=== EDIFICIOS ===");

        for (int i = 0; i < edificios.length; i++) {

            System.out.println(i + ". "
                    + edificios[i]);
        }
    }

    public void calcularRutaCorta(int inicio,
                                  int destino) {

        int distancia[] = new int[edificios.length];

        boolean visitado[] =
                new boolean[edificios.length];

        for (int i = 0; i < distancia.length; i++) {

            distancia[i] = Integer.MAX_VALUE;
        }

        distancia[inicio] = 0;

        for (int i = 0; i < edificios.length - 1; i++) {

            int nodoActual =
                    obtenerNodoMenor(distancia,
                                     visitado);

            visitado[nodoActual] = true;

            for (int j = 0; j < edificios.length; j++) {

                if (!visitado[j]
                        && matriz[nodoActual][j] != 0
                        && distancia[nodoActual]
                        != Integer.MAX_VALUE
                        && distancia[nodoActual]
                        + matriz[nodoActual][j]
                        < distancia[j]) {

                    distancia[j] =
                            distancia[nodoActual]
                            + matriz[nodoActual][j];
                }
            }
        }

        System.out.println("Ruta mas corta desde "
                + edificios[inicio]
                + " hasta "
                + edificios[destino]);

        System.out.println("Distancia total: "
                + distancia[destino]
                + " metros");
    }

    private int obtenerNodoMenor(int distancia[],
                                 boolean visitado[]) {

        int minimo = Integer.MAX_VALUE;

        int indice = -1;

        for (int i = 0; i < distancia.length; i++) {

            if (!visitado[i]
                    && distancia[i] <= minimo) {

                minimo = distancia[i];

                indice = i;
            }
        }

        return indice;
    }
}