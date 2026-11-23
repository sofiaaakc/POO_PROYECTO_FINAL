/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package paq.proyecto;

/**
 *
 * @author aleja
 */
public abstract class Jugador extends Persona
{
    protected int tel, reserF;
    protected String correo, tipo;

    public Jugador(int tel, int reserF, String correo, int dni, String nom, String apell) {
        super(dni, nom, apell);
        this.tel = tel;
        this.reserF = reserF;
        this.correo = correo;
    }

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }
    
    public int getTel() {
        return tel;
    }

    public void setTel(int tel) {
        this.tel = tel;
    }

    public int getReserF() {
        return reserF;
    }

    public void setReserF(int reserF) {
        this.reserF = reserF;
    }

    public String getCorreo() {
        return correo;
    }

    public void setCorreo(String correo) {
        this.correo = correo;
    }
    
    public void aumentarreservasf()
    {
        this.reserF++;
    }
    
    public abstract void getTipoJugador();
    
    public abstract double Calculardsct(int horas);
}
