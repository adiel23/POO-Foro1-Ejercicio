import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

void main() {
    Scanner scanner = new Scanner(System.in);
    GestorAlumnos gestorAlumnos = new GestorAlumnos();
    String respuesta;

    System.out.println("=== SISTEMA DE REGISTRO - UDB VIRTUAL (POO) ===");

    do {
        System.out.println("\nSeleccione un numero en base a lo que quiere realizar: \n1 para agregar un alumno\n2 para buscar un alumno\n3 para eliminar un alumno\n4 para mostrar todos los alumnos\n5 para cerrar el programa");

        String opcion = scanner.nextLine().trim();

        switch (opcion) {
            case "1":
                do {
                    System.out.print("\nIngrese el carnet del alumno: ");
                    String carnet = scanner.nextLine().trim();

                    // ver si ya hay un alumno registrado con ese carnet
                    Alumno alumno = gestorAlumnos.obtenerAlumnoPorCarnet(carnet);

                    if (alumno != null) {
                        System.out.println("El alumno que esta intentando registrar ya existe en el sistema");
                        System.out.print("\n¿Volver a ingresar carnet? (s/n): ");
                    } else {
                        System.out.print("Ingrese el nombre completo del alumno: ");
                        String nombreCompleto = scanner.nextLine().trim();

                        // agregar alumno
                        gestorAlumnos.agregarAlumno(carnet, nombreCompleto);

                        // Mensaje requerido
                        System.out.println("Alumno ingresado exitosamente");
                        System.out.print("\n¿Desea ingresar otro alumno? (s/n): ");
                    }
                    respuesta = scanner.nextLine().trim();

                } while (respuesta.equalsIgnoreCase("s"));
                break;
            case "2":
                System.out.print("\ningrese el carnet del alumno a buscar:");
                String carnetBuscar = scanner.nextLine().trim();

                Alumno alumnoEncontrado = gestorAlumnos.obtenerAlumnoPorCarnet(carnetBuscar);

                if (alumnoEncontrado != null) {
                    System.out.println("\n===ALUMNO ENCONTRADO===");
                    System.out.println("Carnet: " + alumnoEncontrado.getCarnet());
                    System.out.println("Nombre completo: " + alumnoEncontrado.getNombreCompleto());
                } else {
                    System.out.println("Alumno no encontrado, no se puede mostrar");
                }
                break;
                
            case "3":
                String alumnoABorrar;
                System.out.print("Ingrese numero de carnet o nombre completo: ");
                alumnoABorrar = scanner.nextLine() .trim();
                
                if (alumnoABorrar.isEmpty()){
                    System.out.print("Ingresa el numero de Carnet o nombre completo correcto"); 
                } else { 
                    Alumno alumno = gestorAlumnos.obtenerAlumnoPorCarnetONombre(alumnoABorrar);
                    if (alumno != null) { 
                        gestorAlumnos.eliminarAlumnoPorCarnet(alumno.getCarnet());
                        System.out.println("Alumno Eliminado");
                    } else {
                        System.out.println("Alumno no encontrado, no se puede eliminar");
                    } 
                    case "4":
                // literal 4: mostrar todos los alumnos
                List<Alumno> lista = gestorAlumnos.obtenerAlumnos();

                if (lista == null || lista.isEmpty()) {
                    System.out.println("\nNo hay alumnos registrados actualmente");
                } else {
                    System.out.println("\n=== LISTA DE ALUMNOS ===");
                    for (Alumno a : lista) {
                        System.out.println("Carnet: " + a.getCarnet() + " | Nombre: " + a.getNombreCompleto());
                    }
                }
                break;

            case "5":
                System.out.println("Saliendo del programa...");
                return;
                 }
                break;
                
            default:
                System.out.println("ingrese un valor valido");
                respuesta = "s";
                continue;
        }

        System.out.println("Desea continuar con el programar? (s/n)");
        respuesta = scanner.nextLine().trim();

    } while (respuesta.equalsIgnoreCase("s"));

    scanner.close();

}
