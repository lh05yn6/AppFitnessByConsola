import java.util.List;

public class Usuario {
    private String nombre;
    private String correo;
    private String password;

    public Usuario(String nombre, String correo, String password) {
        this.nombre = nombre;
        this.correo = correo;
        this.password = password;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getCorreo() {
        return correo;
    }

    public void setCorreo(String correo) {
        this.correo = correo;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public List<Evento> buscarEventos(String criterio, SistemaDeVentaDeEntradas sistema) {
        return sistema.buscarEventos(criterio);
    }

    public String verDetallesEvento(Evento evento) {
        return evento.toString();
    }

    public boolean comprarEntrada(Evento evento, Asiento asiento, TipoEntrada tipo, SistemaDeVentaDeEntradas sistema) {
        return sistema.procesarCompra(evento, asiento, tipo);
    }
}
