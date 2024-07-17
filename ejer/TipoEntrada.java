public class TipoEntrada {
    private String tipo;
    private double precio;

    public TipoEntrada(String tipo, double precio) {
        this.tipo = tipo;
        this.precio = precio;
    }

    public String getTipo() {
        return tipo;
    }

    public double getPrecio() {
        return precio;
    }
}
