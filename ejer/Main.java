import java.util.Date;
import java.util.List;
import java.util.Scanner;
import java.util.InputMismatchException;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        SistemaDeVentaDeEntradas sistema = new SistemaDeVentaDeEntradas();

        Organizador organizador = new Organizador("Carlos", "carlos@mail.com", "password123");

        Evento evento1 = new Evento("Concierto de Rock", "Estadio Central", new Date(), "Música", "Concierto de rock con bandas famosas Metalica.");
        evento1.agregarAsiento(new Asiento(1, "A", "disponible"));
        evento1.agregarAsiento(new Asiento(2, "A", "disponible"));
        organizador.crearEvento(evento1, sistema);

        Evento evento2 = new Evento("Feria de Libros", "Centro de Convenciones", new Date(), "Cultura", "Feria de libros con autores reconocidos y venta de Comics.");
        evento2.agregarAsiento(new Asiento(1, "B", "disponible"));
        evento2.agregarAsiento(new Asiento(2, "B", "disponible"));
        organizador.crearEvento(evento2, sistema);

        Evento evento3 = new Evento("Torneo de Ajedrez", "Club de Ajedrez", new Date(), "Deporte", "Torneo de ajedrez para principiantes y expertos.");
        evento3.agregarAsiento(new Asiento(1, "C", "disponible"));
        evento3.agregarAsiento(new Asiento(2, "C", "disponible"));
        organizador.crearEvento(evento3, sistema);

        Evento evento4 = new Evento("Arte Nacional: Colores de Bolivia", "Galería de Arte de La Paz", new Date(), "Arte", "Exposición de obras de arte de autores nacionales de Bolivia Mamani Mamani.");
        evento4.agregarAsiento(new Asiento(1, "D", "disponible"));
        evento4.agregarAsiento(new Asiento(2, "D", "disponible"));
        organizador.crearEvento(evento4, sistema);

        Evento evento5 = new Evento("Bajocero Concert: Rock Indie", "Estadio Central", new Date(), "Música", "Concierto de rock indie con bandas como Kellen, Los Últimos Glaciales y Aliss.");
        evento5.agregarAsiento(new Asiento(1, "E", "disponible"));
        evento5.agregarAsiento(new Asiento(2, "E", "disponible"));
        organizador.crearEvento(evento5, sistema);

        Usuario usuario = new Usuario("Ana", "ana@mail.com", "password123");

        while (true) {
            try {
                System.out.println("\nBienvenido al SuperMarker  de Entradas");
                System.out.println("1. Buscar eventos");
                System.out.println("2. Comprar entrada");
                System.out.println("3. Ver detalles del evento");
                System.out.println("4. Salir");
                System.out.print("Seleccione una opción: ");

                int opcion = scanner.nextInt();
                scanner.nextLine();  

                switch (opcion) {
                    case 1:
                        System.out.print("Ingrese criterio de búsqueda (ubicación, fecha, categoría, palabra clave): ");
                        String criterio = scanner.nextLine();
                        List<Evento> eventosEncontrados = usuario.buscarEventos(criterio, sistema);
                        for (Evento e : eventosEncontrados) {
                            System.out.println("Evento encontrado: " + e.getNombre());
                        }
                        break;

                    case 2:
                        System.out.print("Ingrese nombre del evento: ");
                        String nombreEvento = scanner.nextLine();
                        Evento eventoSeleccionado = null;
                        for (Evento e : sistema.buscarEventos(nombreEvento)) {
                            if (e.getNombre().equalsIgnoreCase(nombreEvento)) {
                                eventoSeleccionado = e;
                                break;
                            }
                        }
                        if (eventoSeleccionado != null) {
                            List<Asiento> asientosDisponibles = eventoSeleccionado.verDisponibilidad();
                            if (!asientosDisponibles.isEmpty()) {
                                System.out.println("Asientos disponibles:");
                                for (Asiento asiento : asientosDisponibles) {
                                    System.out.println("Asiento " + asiento.getNumero() + " en fila " + asiento.getFila());
                                }
                                System.out.print("Seleccione el número de asiento: ");
                                int numeroAsiento = scanner.nextInt();
                                scanner.nextLine();  
                                Asiento asientoSeleccionado = null;
                                for (Asiento asiento : asientosDisponibles) {
                                    if (asiento.getNumero() == numeroAsiento) {
                                        asientoSeleccionado = asiento;
                                        break;
                                    }
                                }
                                if (asientoSeleccionado != null) {
                                    System.out.print("Seleccione el tipo de entrada (General, VIP, Anticipada): ");
                                    String tipoEntrada = scanner.nextLine();
                                    TipoEntrada tipo = new TipoEntrada(tipoEntrada, 50.0);  
                                    
                                    System.out.print("Seleccione el método de pago (Contado, QR): ");
                                    String metodoPago = scanner.nextLine();
                                    
                                    boolean compraExitosa = usuario.comprarEntrada(eventoSeleccionado, asientoSeleccionado, tipo, sistema);
                                    if (compraExitosa) {
                                        System.out.println("Realizo su compra exitosamente! Método de pago: " + metodoPago);
                                    } else {
                                        System.out.println("Error al comprar la entrada.");
                                    }
                                } else {
                                    System.out.println("Asiento no encontrado.");
                                }
                            } else {
                                System.out.println("No hay asientos disponibles.");
                            }
                        } else {
                            System.out.println("Evento no encontrado.");
                        }
                        break;

                    case 3:
                        System.out.print("Ingrese nombre del evento: ");
                        String eventoDetalle = scanner.nextLine();
                        Evento eventoDet = null;
                        for (Evento e : sistema.buscarEventos(eventoDetalle)) {
                            if (e.getNombre().equalsIgnoreCase(eventoDetalle)) {
                                eventoDet = e;
                                break;
                            }
                        }
                        if (eventoDet != null) {
                            System.out.println("Detalles del evento: " + usuario.verDetallesEvento(eventoDet));
                        } else {
                            System.out.println("Evento no encontrado.");
                        }
                        break;

                    case 4:
                        System.out.println("Saliendo del sistema...");
                        scanner.close();
                        return;

                    default:
                        System.out.println("Opción no válida. Intente nuevamente.");
                        break;
                }
            } catch (InputMismatchException e) {
                System.out.println("Entrada inválida. Por favor, ingrese un número.");
                scanner.next(); 

            }
        }
    }
}
