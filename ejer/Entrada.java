public class Entrada {
    private Evento evento;
    private Usuario usuario;
    private Asiento asiento;
    private TipoEntrada tipoEntrada;
    private double precio;
    private String estado;  

    public Entrada(Evento evento, Usuario usuario, Asiento asiento, TipoEntrada tipoEntrada, double precio, String estado) {
        this.evento = evento;
        this.usuario = usuario;
        this.asiento = asiento;
        this.tipoEntrada = tipoEntrada;
        this.precio = precio;
        this.estado = estado;
    }

    public Evento getEvento() {
        return evento;
    }

    public Usuario getUsuario() {
        return usuario;
    }

    public Asiento getAsiento() {
        return asiento;
    }

    public TipoEntrada getTipoEntrada() {
        return tipoEntrada;
    }

    public double getPrecio() {
        return precio;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }
}
