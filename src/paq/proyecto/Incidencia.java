/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package paq.proyecto;

/**
 *
 * @author aleja
 */
public class Incidencia 
{
 private String descripcion;
    private double montoCargo;

    public Incidencia(String descripcion, double montoCargo) {
        this.descripcion = descripcion;
        this.montoCargo = montoCargo;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public double getMontoCargo() {
        return montoCargo;
    }

    public void setMontoCargo(double montoCargo) {
        this.montoCargo = montoCargo;
    }
      
}
