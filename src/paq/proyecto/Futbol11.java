/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package paq.proyecto;

/**
 *
 * @author aleja
 */
public class Futbol11 extends Cancha
{

    public Futbol11(int codigo, int horario, float tarifaBaseXHr, String nombre, String estado) 
    {
        super(codigo, horario, tarifaBaseXHr, nombre, "Futbol 11", estado);
        this.capMaxJugadores = 23;
        this.recargo = 0.55f;
    }

    

    @Override
    public float calcularTarifaBaseXHr() 
    {
        float tarifaFinal;
        if(this.horario >= 18)
        {
            tarifaFinal = this.tarifaBaseXHr + this.tarifaBaseXHr*this.recargo;
        }
        else
        {
            tarifaFinal = this.tarifaBaseXHr;
        }
        return tarifaFinal;
        
    }
    
    
    
}
