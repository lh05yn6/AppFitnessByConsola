public class Asiento {
    private int numero;
    private String fila;
    private String estado;

    public Asiento(int numero, String fila, String estado) {
        this.numero = numero;
        this.fila = fila;
        this.estado = estado;
    }

    public int getNumero() {
        return numero;
    }

    public String getFila() {
        return fila;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }
}
