/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package paq.proyecto;

/**
 *
 * @author aleja
 */
public class ServicioAdicional implements Facturable
{
    private int codigo;
    private String nombre;
    private float precioUnit;
    private int stockDispo;
    
    public ServicioAdicional(int codigo, String nombre, float precioUnit, int stockDispo)
    {
        this.codigo = codigo;
        this.nombre = nombre;
        this.precioUnit = precioUnit;
        this.stockDispo = stockDispo;
    }

    public int getCodigo() {
        return codigo;
    }

    public void setCodigo(int codigo) {
        this.codigo = codigo;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public float getPrecioUnit() {
        return precioUnit;
    }

    public void setPrecioUnit(float precioUnit) {
        this.precioUnit = precioUnit;
    }

    public int getStockDispo() {
        return stockDispo;
    }

    public void setStockDispo(int stockDispo) {
        this.stockDispo = stockDispo;
    }

    @Override
    public float calcularMonto() 
    {
        return this.precioUnit;
        
    }

    @Override
    public String obtenerDetalle() 
    {
        return "Servicio - " + codigo + "\n " + nombre + "\nS/. " + precioUnit + "\nStock: " + stockDispo;
        
    }
    
    
            
    
}
