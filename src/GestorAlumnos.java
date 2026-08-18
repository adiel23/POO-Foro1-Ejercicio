import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class GestorAlumnos {
    private List<Alumno> alumnos;

    public GestorAlumnos() {
        this.alumnos = new ArrayList<>();
    }

    public Alumno obtenerAlumnoPorCarnet(String carnet) {
        return alumnos.stream()
                .filter(a -> Objects.equals(a.getCarnet(), carnet))
                .findFirst()
                .orElse(null);
    }

    public void agregarAlumno(String carnet, String nombreCompleto) {
        Alumno alumno = new Alumno(carnet, nombreCompleto);
        this.alumnos.add(alumno);
    }
    
        /*Metodo para poder buscar por carnet o nombre completo*/
    public Alumno obtenerAlumnoPorCarnetONombre(String texto) {
    return alumnos.stream()
            .filter(a -> Objects.equals(a.getCarnet(), texto)
                      || (a.getNombreCompleto() != null && a.getNombreCompleto().equalsIgnoreCase(texto)))
            .findFirst()
            .orElse(null);
    }
    /*Metodo para poder borrar al alumno*/
        public boolean eliminarAlumnoPorCarnet(String carnet) {
        return alumnos.removeIf(a -> Objects.equals(a.getCarnet(), carnet));
    }

}

