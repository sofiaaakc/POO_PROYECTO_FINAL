/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package paq.proyecto;

/**
 *
 * @author aleja
 */
public class Reserva 
{
    private static int contador = 1;
    private int numCorr;
    private Jugador jugadorTitular;
    private Cancha ccancha;
    private Recepcionista recepcionRegistro;
    private EncargadoCancha encargadoSupervision;
    private String fecha;
    private String horaInicio;
    private int duracion;
    
    private Jugador[] jugadoresParticipantes;
    private int cantParticipantes;
    
    private Facturable[] items;
    private int cantItems;
    
    private Incidencia[] incidencias;
    private int cantIncidencias;
    
    private String estado;
    private String[] historialestados;
    private int cantEstados;
    
    private double adelantopagado;
    
    public Reserva(Jugador jugadorTitular, Cancha ccancha, Recepcionista recepcionRegistro,
                   String fecha, String horaInicio, int duracion) {
        this.numCorr = contador++;
        this.jugadorTitular = jugadorTitular;
        this.ccancha = ccancha;
        this.recepcionRegistro = recepcionRegistro;
        this.fecha = fecha;
        this.horaInicio = horaInicio;
        this.duracion = duracion;
        
        this.jugadoresParticipantes = new Jugador[22];
        this.cantParticipantes = 0;
        
        this.items = new Facturable[15];
        this.cantItems = 0;
        
        this.incidencias = new Incidencia[10];
        this.cantIncidencias = 0;
        
        this.historialestados = new String[10];
        this.cantEstados = 0;
        
        this.adelantopagado = 0.0;
        registrarCambioEstado("Pendiente");
    }
    
    private void registrarCambioEstado(String nuevoEstado) {
        this.estado = nuevoEstado;
        if (cantEstados < historialestados.length) {
            historialestados[cantEstados] = nuevoEstado;
            cantEstados++;
        }
    }

    public void agregarParticipante(Jugador j) {
        if (cantParticipantes < jugadoresParticipantes.length) {
            jugadoresParticipantes[cantParticipantes] = j;
            cantParticipantes++;
        }
    }

    public void agregarItem(Facturable item) {
        if (cantItems < items.length) {
            items[cantItems] = item;
            cantItems++;
        }
    }

    public void agregarIncidencia(Incidencia inc) {
        if (cantIncidencias < incidencias.length) {
            incidencias[cantIncidencias] = inc;
            cantIncidencias++;
        }
    }

    public void confirmarReserva(double montoadelanto) {
        if (estado.equals("Pendiente")) {
            this.adelantopagado = montoadelanto;
            registrarCambioEstado("Confirmada");
        }
    }

    public void iniciarPartido(EncargadoCancha encargado) {
        if (estado.equals("Confirmada")) {
            this.encargadoSupervision = encargado;
            ccancha.setEstado("Ocupada");
            registrarCambioEstado("En Juego");
        }
    }

    public void cerrarPartido() {
        if (estado.equals("En Juego")) {
            ccancha.setEstado("Disponible");
            jugadorTitular.aumentarreservasf(); 
            registrarCambioEstado("Finalizada");
        }
    }

    public double cancelarreserva(int horasanticipacion) {
        if (estado.equals("En Juego")) {
            ccancha.setEstado("Disponible");
        }
        registrarCambioEstado("Cancelada");
        
        if (horasanticipacion >= 24) {
            double devuelto = adelantopagado;
            adelantopagado = 0.0;
            return devuelto;
        } else {
            return 0.0;
        }
    }

    public double calcularcostoalquiler() {
        
        double costoBruto = ccancha.calcularTarifaBaseXHr()*duracion;
        double descuento = jugadorTitular.Calculardsct(duracion);
        return costoBruto - descuento;
    }

    public double calculartotalitems() {
        double suma = 0.0;
        for (int i = 0; i < cantItems; i++) {
            suma += items[i].calcularMonto();
        }
        return suma;
    }

    public double calculartotalincidencias() {
        double suma = 0.0;
        for (int i = 0; i < cantIncidencias; i++) {
            suma += incidencias[i].getMontoCargo();
        }
        return suma;
    }
    public Jugador getJugadorTitular() {
        return jugadorTitular;
    }

    public void setJugadorTitular(Jugador jugadorTitular) {
        this.jugadorTitular = jugadorTitular;
    }

    public Cancha getCcancha() {
        return ccancha;
    }

    public void setCcancha(Cancha ccancha) {
        this.ccancha = ccancha;
    }

    public String getFecha() {
        return fecha;
    }

    public void setFecha(String fecha) {
        this.fecha = fecha;
    }

    public String getHoraInicio() {
        return horaInicio;
    }

    public void setHoraInicio(String horaInicio) {
        this.horaInicio = horaInicio;
    }

    public int getDuracion() {
        return duracion;
    }

    public void setDuracion(int duracion) {
        this.duracion = duracion;
    }

    public double getAdelantopagado() {
        return adelantopagado;
    }

    public void setAdelantopagado(double adelantopagado) {
        this.adelantopagado = adelantopagado;
    }

    public int getNumCorr() {
        return numCorr;
    }

    public Recepcionista getRecepcionRegistro() {
        return recepcionRegistro;
    }

    public EncargadoCancha getEncargadoSupervision() {
        return encargadoSupervision;
    }

    public String getEstado() {
        return estado;
    }

    public Jugador[] getJugadoresParticipantes() {
        return jugadoresParticipantes;
    }

    public int getCantParticipantes() {
        return cantParticipantes;
    }

    public Facturable[] getItems() {
        return items;
    }

    public int getCantItems() {
        return cantItems;
    }

    public Incidencia[] getIncidencias() {
        return incidencias;
    }

    public int getCantIncidencias() {
        return cantIncidencias;
    }

    public String[] getHistorialestados() {
        return historialestados;
    }

    public int getCantEstados() {
        return cantEstados;
    }
}
