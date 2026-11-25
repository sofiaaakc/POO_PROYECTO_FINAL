/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package paq.proyecto;

/**
 *
 * @author aleja
 */
public class GestionReservas {
     private Reserva[] Reservas;
    private int conta;
    private ComprobantePago[] comprobantes;
    private int contaCompro;

    public GestionReservas() {
        this.Reservas = new Reserva[100];
        this.conta = 0;
        this.comprobantes = new ComprobantePago[100];
        this.contaCompro = 0;
    }

    public boolean Validardispo(Cancha c, String fecha, String horainicio, int duracion) {
        if (c == null || c.getEstado().equalsIgnoreCase("En Mantenimiento")) {
            return false;
        }
        if (duracion < 1 || duracion > 3) {
            return false;
        }

        for (int i = 0; i < conta; i++) {
            Reserva r = Reservas[i];
            if (r.getCcancha().getCodigo() == c.getCodigo() &&
                r.getFecha().equals(fecha) &&
                r.getHoraInicio().equals(horainicio) &&
                !r.getEstado().equalsIgnoreCase("Cancelada")) {
                return false;
            }
        }
        return true;
    }

    public Reserva crearreserva(Jugador titular, Cancha c, Recepcionista recep,
                                String fecha, String horaInicio, int duracion) {
        if (conta >= Reservas.length) {
            return null;
        }
        if (!Validardispo(c, fecha, horaInicio, duracion)) {
            return null;
        }

        Reserva nueva = new Reserva(titular, c, recep, fecha, horaInicio, duracion);
        Reservas[conta] = nueva;
        conta++;
        return nueva;
    }

    public boolean confirmaradelanto(int numCorr, double montoAdelanto) {
        for (int i = 0; i < conta; i++) {
            if (Reservas[i].getNumCorr() == numCorr && Reservas[i].getEstado().equals("Pendiente")) {
                Reservas[i].confirmarReserva(montoAdelanto);
                return true;
            }
        }
        return false;
    }

    public boolean inicarpartido(int numCorr, EncargadoCancha encargado) {
        for (int i = 0; i < conta; i++) {
            if (Reservas[i].getNumCorr() == numCorr && Reservas[i].getEstado().equals("Confirmada")) {
                Reservas[i].iniciarPartido(encargado);
                return true;
            }
        }
        return false;
    }

    public ComprobantePago finalizaryemitircompro(int numCorr, String tipocompro, String ruc, String razonsocial) {
        for (int i = 0; i < conta; i++) {
            if (Reservas[i].getNumCorr() == numCorr && Reservas[i].getEstado().equals("En Juego")) {
                if (contaCompro < comprobantes.length) {
                    Reservas[i].cerrarPartido();
                    ComprobantePago comp = new ComprobantePago(tipocompro, Reservas[i], ruc, razonsocial);
                    comp.generarcalculoauto();
                    comprobantes[contaCompro] = comp;
                    contaCompro++;
                    return comp;
                }
            }
        }
        return null;
    }

    public double cancelarreserva(int numCorr, int horasAnticipacion) {
        for (int i = 0; i < conta; i++) {
            if (Reservas[i].getNumCorr() == numCorr) {
                if (!Reservas[i].getEstado().equals("Finalizada") && !Reservas[i].getEstado().equals("Cancelada")) {
                    return Reservas[i].cancelarreserva(horasAnticipacion);
                }
            }
        }
        return -1;
    }

    public String reporteocupacio() {
        String texto = "=== REPORTE DE OCUPACIÓN ===\n";
        for (int i = 0; i < conta; i++) {
            if (!Reservas[i].getEstado().equalsIgnoreCase("Cancelada")) {
                texto += "Cancha: " + Reservas[i].getCcancha().getCodigo() +
                         " | Fecha: " + Reservas[i].getFecha() +
                         " | Hora: " + Reservas[i].getHoraInicio() +
                         " | Estado: " + Reservas[i].getEstado() + "\n";
            }
        }
        return texto;
    }

    public String reporteproductividad() {
        String texto = "=== REPORTE DE PRODUCTIVIDAD ===\n";
        for (int i = 0; i < conta; i++) {
            String nombreEncargado = "Sin asignar";
            if (Reservas[i].getEncargadoSupervision() != null) {
                nombreEncargado = Reservas[i].getEncargadoSupervision().getNom();
            }
            texto += "Reserva #" + Reservas[i].getNumCorr() +
                     " | Recepcionista: " + Reservas[i].getRecepcionRegistro().getNom() +
                     " | Encargado: " + nombreEncargado + "\n";
        }
        return texto;
    }

    public String reportetopjuga() {
        String texto = "=== TOP JUGADORES ===\n";
        for (int i = 0; i < conta; i++) {
            Jugador j = Reservas[i].getJugadorTitular();
            if (j.getReserF() > 0) {
                texto += j.getNom() + " - Reservas finalizadas: " + j.getReserF() + "\n";
            }
        }
        return texto;
    }

    public String reporteingresos() {
        double totalGeneral = 0.0;
        for (int i = 0; i < contaCompro; i++) {
            totalGeneral += comprobantes[i].getTotal();
        }
        return "=== REPORTE DE INGRESOS ===\n" +
               "Comprobantes emitidos: " + contaCompro + "\n" +
               "Total recaudado: S/ " + totalGeneral + "\n";
    }

    public Reserva[] getReservas() {
        return Reservas;
    }

    public int getConta() {
        return conta;
    }

    public ComprobantePago[] getComprobantes() {
        return comprobantes;
    }

    public int getContaCompro() {
        return contaCompro;
    }
}
