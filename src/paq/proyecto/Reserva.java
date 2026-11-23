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
    private int numCorr;
    private Jugador jugadorTitular;
    private Cancha cancha;
    private Recepcionista recepcionRegistro;
    private String fecha;
    private String horaInicio;
    private int duracion;
    private Jugador[] jugadoresParticipantes;
    private int cantidadParticipantes;
    private Incidencia[] incidencias;
    private int cantidadIncidencias;
    private String estado; 
    private String[] historialEstados;
    private int cantidadHistorial;
    private double adelantoPagado;
    private boolean adelantoDevuelto;
    private ComprobantePago comprobante; 

public Reserva(Jugador jugadorTitular, Cancha cancha, Recepcionista recepcionRegistro,
                   String fecha, String horaInicio, int duracion) {
        this.numCorr = contadorCorrelativo++;
        this.jugadorTitular = jugadorTitular;
        this.cancha = cancha;
        this.recepcionRegistro = recepcionRegistro;
        this.fecha = fecha;
        this.horaInicio = horaInicio;
        this.duracion = duracion;
        this.jugadoresParticipantes = new Jugador[25];
        this.cantidadParticipantes = 0;
        this.incidencias = new Incidencia[20];
        this.cantidadIncidencias = 0;
        this.estado = "Pendiente";
        this.historialEstados = new String[20];
        this.cantidadHistorial = 0;
        this.adelantoPagado = 0.0;
        this.adelantoDevuelto = false;
        this.comprobante = null;

        if (jugadorTitular != null) {
            agregarParticipante(jugadorTitular);
        }
        registrarEstadoHistorial("Pendiente");
    }
    
}
