/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package paq.proyecto;

/**
 *
 * @author aleja
 */
public class JugadorRegular extends Jugador
{

    public JugadorRegular(int tel, int reserF, String correo, int dni, String nom, String apell) {
        super(tel, reserF, correo, dni, nom, apell);
        this.getTipoJugador();
    }

    @Override
    public void getTipoJugador() 
    {
        this.tipo = "Regular";
    }

    @Override
    public double Calculardsct(int horas) 
    {
        return 0.0; //no tiene descuento
    }
    
    
}
