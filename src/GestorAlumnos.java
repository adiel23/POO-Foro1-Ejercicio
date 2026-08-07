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
}
