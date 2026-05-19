package Main;

import java.util.TreeMap;
import java.util.Scanner;
import Controlador.SistemaRutas;
import Controlador.SistemaReportes;
import Controlador.SistemaEstudiantes;
import Controlador.SistemaPilas;

import Modelos.Aula;
import Modelos.Estudiante;
import Modelos.Materia;
import Modelos.Operacion;

public class Main {

        public static void main(String[] args) {

                Scanner entrada = new Scanner(System.in);

                SistemaEstudiantes sistemaEstudiantes = new SistemaEstudiantes();

                SistemaPilas sistemaPilas = new SistemaPilas(sistemaEstudiantes);
                SistemaRutas sistemaRutas = new SistemaRutas();
                SistemaReportes sistemaReportes = new SistemaReportes();
                TreeMap<String, Materia> materias = new TreeMap<>();

                TreeMap<String, Aula> aulas = new TreeMap<>();

                Aula aula1 = new Aula("A101");

                aulas.put("A101", aula1);

                int opcion = 0;

                while (opcion != 21) {

                        System.out.println("============================================================");
                        System.out.println("        PLANIFICACION ACADEMICA - SISTEMA UNIVERSITARIO");
                        System.out.println("============================================================");

                        System.out.println();
                        System.out.println("=== GESTION DE ESTUDIANTES ===");
                        System.out.println("1. Registrar estudiante");
                        System.out.println("2. Buscar estudiante por ID");
                        System.out.println("3. Listar todos los estudiantes");
                        System.out.println("4. Eliminar estudiante");

                        System.out.println();
                        System.out.println("=== GESTION DE MATERIAS ===");
                        System.out.println("5. Crear materia");
                        System.out.println("6. Agregar pre-requisito");
                        System.out.println("7. Mostrar pre-requisitos");
                        System.out.println("8. Inscribir estudiante");
                        System.out.println("9. Cancelar inscripcion");
                        System.out.println("10. Mostrar cola de espera");

                        System.out.println();
                        System.out.println("=== GESTION DE HORARIOS ===");
                        System.out.println("11. Reservar horario en aula");
                        System.out.println("12. Liberar horario");
                        System.out.println("13. Consultar disponibilidad");

                        System.out.println();
                        System.out.println("=== RUTAS ENTRE EDIFICIOS ===");
                        System.out.println("14. Mostrar edificios");
                        System.out.println("15. Calcular ruta mas corta");

                        System.out.println();
                        System.out.println("=== REPORTES ACADEMICOS ===");
                        System.out.println("16. Registrar nota");
                        System.out.println("17. Ver reporte academico");
                        System.out.println("18. Navegador de reportes");

                        System.out.println();
                        System.out.println("=== SISTEMA DESHACER/REHACER ===");
                        System.out.println("19. Deshacer ultima operacion");
                        System.out.println("20. Rehacer ultima operacion");

                        System.out.println();
                        System.out.println("=== SALIR ===");
                        System.out.println("21. Salir");

                        System.out.println();
                        System.out.print("Seleccione una opcion: ");

                        opcion = entrada.nextInt();
                        entrada.nextLine();

                        switch (opcion) {

                                case 1:

                                        System.out.println("--- REGISTRO ESTUDIANTE ---");

                                        System.out.print("ID: ");
                                        int id = entrada.nextInt();
                                        entrada.nextLine();

                                        System.out.print("Nombre: ");
                                        String nombre = entrada.nextLine();

                                        System.out.print("Email: ");
                                        String email = entrada.nextLine();

                                        System.out.print("Semestre: ");
                                        int semestre = entrada.nextInt();

                                        Estudiante estudiante = new Estudiante(nombre,
                                                        id,
                                                        email,
                                                        semestre);

                                        sistemaEstudiantes
                                                        .registrarEstudiante(estudiante);

                                        break;

                                case 2:

                                        System.out.println("--- BUSCAR ESTUDIANTE ---");

                                        System.out.print("Ingrese ID: ");

                                        int buscar = entrada.nextInt();

                                        Estudiante encontrado = sistemaEstudiantes
                                                        .buscarEstudiante(buscar);

                                        if (encontrado != null) {

                                                System.out.println("Nombre: "
                                                                + encontrado.getNombre());

                                                System.out.println("Email: "
                                                                + encontrado.getEmail());

                                                System.out.println("Semestre: "
                                                                + encontrado.getSemestre());

                                        } else {

                                                System.out.println("Estudiante no encontrado");
                                        }

                                        break;

                                case 3:

                                        System.out.println("--- LISTA ESTUDIANTES ---");

                                        sistemaEstudiantes.listarEstudiantes();

                                        break;

                                case 4:

                                        System.out.println("--- ELIMINAR ESTUDIANTE ---");

                                        System.out.print("Ingrese ID: ");

                                        int eliminar = entrada.nextInt();

                                        Estudiante eliminado = sistemaEstudiantes
                                                        .buscarEstudiante(eliminar);

                                        sistemaEstudiantes
                                                        .eliminarEstudiante(eliminar);

                                        if (eliminado != null) {

                                                Operacion op = new Operacion("ELIMINAR",
                                                                eliminado,
                                                                null);

                                                sistemaPilas.guardarOperacion(op);
                                        }

                                        break;

                                case 5:

                                        System.out.println("--- CREAR MATERIA ---");

                                        System.out.print("Codigo: ");
                                        String codigo = entrada.nextLine();

                                        System.out.print("Nombre: ");
                                        String nombreMateria = entrada.nextLine();

                                        System.out.print("Cupos: ");
                                        int cupos = entrada.nextInt();

                                        System.out.print("Creditos: ");
                                        int creditos = entrada.nextInt();

                                        entrada.nextLine();

                                        Materia materia = new Materia(codigo,
                                                        nombreMateria,
                                                        cupos,
                                                        creditos);

                                        materias.put(codigo, materia);

                                        System.out.println("Materia creada correctamente");

                                        break;

                                case 6:

                                        System.out.println("--- AGREGAR PREREQUISITO ---");

                                        System.out.print("Codigo materia: ");

                                        String codigoMateria = entrada.nextLine();

                                        Materia mat = materias.get(codigoMateria);

                                        if (mat != null) {

                                                System.out.print("Prerequisito: ");

                                                String pre = entrada.nextLine();

                                                mat.agregarPreRequisito(pre);

                                                System.out.println("Prerequisito agregado");

                                        } else {

                                                System.out.println("Materia no encontrada");
                                        }

                                        break;

                                case 7:

                                        System.out.println("--- PREREQUISITOS ---");

                                        System.out.print("Codigo materia: ");

                                        String codigoPre = entrada.nextLine();

                                        Materia materiaPre = materias.get(codigoPre);

                                        if (materiaPre != null) {

                                                for (String pre : materiaPre.getPreRequisitos()) {

                                                        System.out.println(pre);
                                                }

                                        } else {

                                                System.out.println("Materia no encontrada");
                                        }

                                        break;

                                case 8:

                                        System.out.println("--- INSCRIPCION ---");

                                        System.out.print("ID estudiante: ");

                                        int idEst = entrada.nextInt();

                                        entrada.nextLine();

                                        System.out.print("Codigo materia: ");

                                        String codMat = entrada.nextLine();

                                        Estudiante est = sistemaEstudiantes
                                                        .buscarEstudiante(idEst);

                                        Materia matIns = materias.get(codMat);

                                        if (est != null && matIns != null) {

                                                matIns.inscribirEstudiante(est);

                                                Operacion op = new Operacion("INSCRIPCION",
                                                                est,
                                                                matIns);

                                                sistemaPilas.guardarOperacion(op);

                                        } else {

                                                System.out.println("Datos incorrectos");
                                        }

                                        break;

                                case 9:

                                        System.out.println("--- CANCELAR INSCRIPCION ---");

                                        System.out.print("ID estudiante: ");

                                        int idCancelar = entrada.nextInt();

                                        entrada.nextLine();

                                        System.out.print("Codigo materia: ");

                                        String codCancelar = entrada.nextLine();

                                        Estudiante estCancelar = sistemaEstudiantes
                                                        .buscarEstudiante(idCancelar);

                                        Materia matCancelar = materias.get(codCancelar);

                                        if (estCancelar != null
                                                        && matCancelar != null) {

                                                matCancelar
                                                                .cancelarInscripcion(estCancelar);

                                        } else {

                                                System.out.println("Datos incorrectos");
                                        }

                                        break;

                                case 10:

                                        System.out.println("--- COLA DE ESPERA ---");

                                        System.out.print("Codigo materia: ");

                                        String cola = entrada.nextLine();

                                        Materia matCola = materias.get(cola);

                                        if (matCola != null) {

                                                for (Estudiante e : matCola.getColaEspera()) {

                                                        System.out.println(e.getNombre());
                                                }

                                        } else {

                                                System.out.println("Materia no encontrada");
                                        }

                                        break;

                                case 11:

                                        System.out.println("--- RESERVAR HORARIO ---");

                                        System.out.print("Aula: ");

                                        String aulaReserva = entrada.nextLine();

                                        Aula aulaR = aulas.get(aulaReserva);

                                        if (aulaR != null) {

                                                System.out.print("Dia: ");

                                                int dia = entrada.nextInt();

                                                System.out.print("Hora inicio: ");

                                                int hora = entrada.nextInt();

                                                System.out.print("Duracion: ");

                                                int duracion = entrada.nextInt();

                                                entrada.nextLine();

                                                boolean reservado = aulaR.reservar(dia,
                                                                hora,
                                                                duracion);

                                                if (reservado) {

                                                        System.out.println("Horario reservado");

                                                } else {

                                                        System.out.println("Horario ocupado");
                                                }

                                        } else {

                                                System.out.println("Aula no encontrada");
                                        }

                                        break;

                                case 12:

                                        System.out.println("--- LIBERAR HORARIO ---");

                                        System.out.print("Aula: ");

                                        String aulaLiberar = entrada.nextLine();

                                        Aula aulaL = aulas.get(aulaLiberar);

                                        if (aulaL != null) {

                                                System.out.print("Dia: ");

                                                int dia = entrada.nextInt();

                                                System.out.print("Hora inicio: ");

                                                int hora = entrada.nextInt();

                                                System.out.print("Duracion: ");

                                                int duracion = entrada.nextInt();

                                                entrada.nextLine();

                                                aulaL.liberar(dia,
                                                                hora,
                                                                duracion);

                                                System.out.println("Horario liberado");

                                        } else {

                                                System.out.println("Aula no encontrada");
                                        }

                                        break;

                                case 13:

                                        System.out.println("--- CONSULTAR DISPONIBILIDAD ---");

                                        System.out.print("Aula: ");

                                        String aulaConsulta = entrada.nextLine();

                                        Aula aulaC = aulas.get(aulaConsulta);

                                        if (aulaC != null) {

                                                System.out.print("Dia: ");

                                                int dia = entrada.nextInt();

                                                System.out.print("Hora: ");

                                                int hora = entrada.nextInt();

                                                entrada.nextLine();

                                                boolean disponible = aulaC.consultarDisponibilidad(dia,
                                                                hora);

                                                if (disponible) {

                                                        System.out.println("Horario disponible");

                                                } else {

                                                        System.out.println("Horario ocupado");
                                                }

                                        } else {

                                                System.out.println("Aula no encontrada");
                                        }

                                        break;
                                case 14:
                                        System.out.println("--- edificios ---");
                                        sistemaRutas.mostrarEdificios();
                                        break;
                                case 15:
                                        sistemaRutas.mostrarEdificios();
                                        System.out.print("origen: ");
                                        int origen = entrada.nextInt();
                                        System.out.print("destino: ");
                                        int destino = entrada.nextInt();
                                        entrada.nextLine();
                                        sistemaRutas.calcularRuta(origen, destino);
                                        break;
                                case 16:
                                        System.out.print("ID estudiante: ");
                                        int idNota = entrada.nextInt();
                                        entrada.nextLine();
                                        Estudiante estNota = sistemaEstudiantes.buscarEstudiante(idNota);
                                        if (estNota == null) {
                                                System.out.println("estudiante no encontrado");
                                        } else {
                                                System.out.print("semestre (0-9): ");
                                                int semNota = entrada.nextInt();
                                                System.out.print("materia (0-19): ");
                                                int matNota = entrada.nextInt();
                                                System.out.print("nota: ");
                                                double notaVal = entrada.nextDouble();
                                                entrada.nextLine();
                                                estNota.registrarNota(semNota, matNota, notaVal);
                                                System.out.println("nota guardada");
                                        }
                                        break;
                                case 17:
                                        System.out.print("ID estudiante: ");
                                        int idRep = entrada.nextInt();
                                        entrada.nextLine();
                                        Estudiante estRep = sistemaEstudiantes.buscarEstudiante(idRep);
                                        if (estRep == null) {
                                                System.out.println("estudiante no encontrado");
                                        } else {
                                                Double[][] notas = estRep.getNotas();
                                                int aprobadas = 0, reprobadas = 0;
                                                for (int s = 0; s < notas.length; s++) {
                                                        boolean hayNotas = false;
                                                        for (int m = 0; m < notas[s].length; m++) {
                                                                if (notas[s][m] != null) {
                                                                        hayNotas = true;
                                                                        break;
                                                                }
                                                        }
                                                        if (hayNotas) {
                                                                System.out.println("semestre " + s + ":");
                                                                double suma = 0;
                                                                int cont = 0;
                                                                for (int m = 0; m < notas[s].length; m++) {
                                                                        if (notas[s][m] != null) {
                                                                                System.out.println("  materia " + m
                                                                                                + ": " + notas[s][m]);
                                                                                suma += notas[s][m];
                                                                                cont++;
                                                                                if (notas[s][m] >= 3.0)
                                                                                        aprobadas++;
                                                                                else
                                                                                        reprobadas++;
                                                                        }
                                                                }
                                                                System.out.println("  promedio: "
                                                                                + (cont > 0 ? suma / cont : 0.0));
                                                        }
                                                }
                                                System.out.println("promedio total: " + estRep.calcularPromedio());
                                                System.out.println("aprobadas: " + aprobadas);
                                                System.out.println("reprobadas: " + reprobadas);
                                                sistemaReportes.registrarReporteVisto("reporte-" + estRep.getId());
                                        }
                                        break;
                                case 18:
                                        sistemaReportes.atras();
                                        break;

                                case 19:

                                        sistemaPilas.deshacer();

                                        break;

                                case 20:

                                        sistemaPilas.rehacer();

                                        break;

                                case 21:

                                        System.out.println("Saliendo del sistema...");

                                        break;

                                default:

                                        System.out.println("Opcion invalida");
                        }

                        System.out.println();
                }

                entrada.close();
        }
}