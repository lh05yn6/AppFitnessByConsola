import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class Evento {
    private String nombre;
    private String ubicacion;
    private Date fecha;
    private String categoria;
    private String descripcion;
    private List<Asiento> asientos;

    public Evento(String nombre, String ubicacion, Date fecha, String categoria, String descripcion) {
        this.nombre = nombre;
        this.ubicacion = ubicacion;
        this.fecha = fecha;
        this.categoria = categoria;
        this.descripcion = descripcion;
        this.asientos = new ArrayList<>();
    }

    public String getNombre() {
        return nombre;
    }

    public String getUbicacion() {
        return ubicacion;
    }

    public Date getFecha() {
        return fecha;
    }

    public String getCategoria() {
        return categoria;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void agregarAsiento(Asiento asiento) {
        asientos.add(asiento);
    }

    public List<Asiento> verDisponibilidad() {
        List<Asiento> disponibles = new ArrayList<>();
        for (Asiento asiento : asientos) {
            if (asiento.getEstado().equals("disponible")) {
                disponibles.add(asiento);
            }
        }
        return disponibles;
    }

    @Override
    public String toString() {
        return "Evento: " + nombre + "\nUbicación: " + ubicacion + "\nFecha: " + fecha + "\nCategoría: " + categoria + "\nDescripción: " + descripcion;
    }
}
