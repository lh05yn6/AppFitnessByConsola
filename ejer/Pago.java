public class Pago {
    private String metodo;
    private double monto;

    public Pago(String metodo, double monto) {
        this.metodo = metodo;
        this.monto = monto;
    }

    @Override
    public String toString() {
        return "Método de Pago: " + metodo + ", Monto: " + monto;
    }
}
