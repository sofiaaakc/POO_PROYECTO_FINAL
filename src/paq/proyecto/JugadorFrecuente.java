/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package paq.proyecto;

/**
 *
 * @author aleja
 */
public class JugadorFrecuente extends Jugador
{

    public JugadorFrecuente(int tel, int reserF, String correo, int dni, String nom, String apell) {
        super(tel, reserF, correo, dni, nom, apell);
        this.getTipoJugador();
       
    }
    
    

    @Override
    public void getTipoJugador() {
        this.tipo = "Frecuente";
    }

    @Override
    public double Calculardsct(int horas) 
    {
        return horas*4;
    }
    
    
}
