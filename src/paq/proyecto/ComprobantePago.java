/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package paq.proyecto;

/**
 *
 * @author aleja
 */
public class ComprobantePago 
{
    private static int contador = 1;
    private int Numcorrelativo;
    private String tipocompro;
    private Reserva reserva;
    private String ruc;
    private String razonsocial;
    private double subtotal;
    private double igv;
    private double total;
    private double adelantodescontado;
    private double saldoapagar;

    public ComprobantePago(String tipocompro, Reserva reserva, String ruc, String razonsocial) {
        this.Numcorrelativo = contador++;
        this.tipocompro = tipocompro;
        this.reserva = reserva;
        this.ruc = ruc;
        this.razonsocial = razonsocial;
    }

    public double calcularSubtotal() {
        double costoAlquiler = reserva.calcularcostoalquiler();
        double totalItems = reserva.calculartotalitems();
        double totalIncidencias = reserva.calculartotalincidencias();
        this.subtotal = costoAlquiler + totalItems + totalIncidencias;
        return this.subtotal;
    }

    public double calcularIGV() {
        this.igv = this.subtotal * 0.18;
        return this.igv;
    }

    public double calcularTotal() {
        this.total = this.subtotal + this.igv;
        return this.total;
    }

    public double calcularSaldoAPagar() {
        this.adelantodescontado = reserva.getAdelantopagado();
        this.saldoapagar = this.total - this.adelantodescontado;
        return this.saldoapagar;
    }

    public void generarcalculoauto() {
        calcularSubtotal();
        calcularIGV();
        calcularTotal();
        calcularSaldoAPagar();
    }

    public int getNumcorrelativo() {
        return Numcorrelativo;
    }

    public String getTipocompro() {
        return tipocompro;
    }

    public void setTipocompro(String tipocompro) {
        this.tipocompro = tipocompro;
    }

    public Reserva getReserva() {
        return reserva;
    }

    public void setReserva(Reserva reserva) {
        this.reserva = reserva;
    }

    public String getRuc() {
        return ruc;
    }

    public void setRuc(String ruc) {
        this.ruc = ruc;
    }

    public String getRazonsocial() {
        return razonsocial;
    }

    public void setRazonsocial(String razonsocial) {
        this.razonsocial = razonsocial;
    }

    public double getSubtotal() {
        return subtotal;
    }

    public double getIgv() {
        return igv;
    }

    public double getTotal() {
        return total;
    }

    public double getAdelantodescontado() {
        return adelantodescontado;
    }

    public double getSaldoapagar() {
        return saldoapagar;
    }
}
