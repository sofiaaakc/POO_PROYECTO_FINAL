/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package paq.proyecto;

/**
 *
 * @author aleja
 */
public class Futbol5 extends Cancha

{

    public Futbol5(int codigo, int horario, float tarifaBaseXHr, String nombre, String estado) 
    {
        super(codigo, horario, tarifaBaseXHr, nombre, "Futbol 5", estado);
        this.capMaxJugadores = 11;
        this.recargo = 0.2f;
    }

    
    @Override
    public float calcularTarifaBaseXHr() 
    {
        float tarifaFinal;
        if(this.horario >= 18)
        {
            tarifaFinal = this.tarifaBaseXHr*(1 + this.recargo);
        }
        else
        {
            tarifaFinal = this.tarifaBaseXHr;
        }
        return tarifaFinal;
        
    }
    
    
    
    
    
}
