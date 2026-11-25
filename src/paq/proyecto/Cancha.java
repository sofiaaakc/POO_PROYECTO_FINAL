/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package paq.proyecto;

/**
 *
 * @author aleja
 */
public abstract class Cancha 
//aaaa
{
    protected int codigo, horario, capMaxJugadores;
    protected float tarifaBaseXHr, recargo;
    protected String nombre, tipo, estado;

    public Cancha(int codigo, int horario, float tarifaBaseXHr, String nombre, String tipo, String estado) {
        this.codigo = codigo;
        this.horario = horario;
        this.tarifaBaseXHr = tarifaBaseXHr;
        this.nombre = nombre;
        this.tipo = tipo;
        this.estado = estado;
    }
    

    public int getCodigo() {
        return codigo;
    }

    public void setCodigo(int codigo) {
        this.codigo = codigo;
    }

    public int getHorario() {
        return horario;
    }

    public void setHorario(int horario) {
        this.horario = horario;
    }

    public int getCapMaxJugadores() {
        return capMaxJugadores;
    }

    public void setCapMaxJugadores(int capMaxJugadores) {
        this.capMaxJugadores = capMaxJugadores;
    }

    public float getTarifaBaseXHr() {
        return tarifaBaseXHr;
    }

    public void setTarifaBaseXHr(float tarifaBaseXHr) {
        this.tarifaBaseXHr = tarifaBaseXHr;
    }

    public float getRecargo() {
        return recargo;
    }

    public void setRecargo(float recargo) {
        this.recargo = recargo;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }

    public abstract float calcularTarifaBaseXHr();
    

}
