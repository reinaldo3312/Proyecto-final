package Controlador;
import java.util.Stack;

public class SistemaReportes {

    Stack<String> pilaNavegacion = new Stack<>();

    public void atras() {
        if (!pilaNavegacion.isEmpty()) {
            String dato = pilaNavegacion.pop();
            System.out.println("volviendo de: " + dato);
        } else {
            System.out.println("no hay reportes anteriores");
        }
    }

    public void registrarReporteVisto(String nombreReporte) {
        pilaNavegacion.push(nombreReporte);
        System.out.println("reporte guardado en historial");
    }
}