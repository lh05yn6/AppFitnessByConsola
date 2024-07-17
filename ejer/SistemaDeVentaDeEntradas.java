import java.util.ArrayList;
import java.util.List;

public class SistemaDeVentaDeEntradas {
    private List<Evento> eventos;

    public SistemaDeVentaDeEntradas() {
        this.eventos = new ArrayList<>();
    }

    public void agregarEvento(Evento evento) {
        eventos.add(evento);
    }

    public List<Evento> buscarEventos(String criterio) {
        List<Evento> eventosEncontrados = new ArrayList<>();
        for (Evento evento : eventos) {
            if (evento.getNombre().toLowerCase().contains(criterio.toLowerCase()) ||
                evento.getUbicacion().toLowerCase().contains(criterio.toLowerCase()) ||
                evento.getCategoria().toLowerCase().contains(criterio.toLowerCase()) ||
                evento.getDescripcion().toLowerCase().contains(criterio.toLowerCase())) {
                eventosEncontrados.add(evento);
            }
        }
        return eventosEncontrados;
    }

    public boolean procesarCompra(Evento evento, Asiento asiento, TipoEntrada tipo) {
        if (asiento.getEstado().equals("disponible")) {
            asiento.setEstado("vendido");
            return true;
        }
        return false;
    }
}
