import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

class Alumno {
    private String carnet;
    private String nombreCompleto;

    public Alumno(String carnet, String nombreCompleto) {
        this.carnet = carnet;
        this.nombreCompleto = nombreCompleto;
    }

    public String getCarnet() {
        return carnet;
    }

    public String getNombreCompleto() {
        return nombreCompleto;
    }
}

void main() {
    Scanner scanner = new Scanner(System.in);
    List<Alumno> alumnos = new ArrayList<>();
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

                    Alumno alumno = alumnos.stream()
                            .filter(a -> Objects.equals(a.carnet, carnet))
                            .findFirst()
                            .orElse(null);

                    if (alumno != null) {
                        System.out.println("El alumno que esta intentando registrar ya existe en el sistema");
                        System.out.print("\n¿Volver a ingresar carnet? (s/n): ");
                        respuesta = scanner.nextLine().trim();
                    } else {
                        System.out.print("Ingrese el nombre completo del alumno: ");
                        String nombreCompleto = scanner.nextLine().trim();

                        // Instanciación y almacenamiento del alumno
                        alumnos.add(new Alumno(carnet, nombreCompleto));

                        // Mensaje requerido
                        System.out.println("Alumno ingresado exitosamente");
                        System.out.print("\n¿Desea ingresar otro alumno? (s/n): ");
                        respuesta = scanner.nextLine().trim();
                    }

                } while (respuesta.equalsIgnoreCase("s"));
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
