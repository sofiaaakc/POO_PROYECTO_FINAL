/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package paq.proyecto;

/**
 *
 * @author aleja
 */
public class PaquetePromocional implements Facturable
{
    private String nombre;
    private ServicioAdicional[] serviIncluidos;
    private float precioPromCerrado;

    public PaquetePromocional(String nombre, ServicioAdicional[] serviIncluidos, float precioPromCerrado) {
        this.nombre = nombre;
        this.serviIncluidos = serviIncluidos;
        this.precioPromCerrado = precioPromCerrado;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public ServicioAdicional[] getServiIncluidos() {
        return serviIncluidos;
    }

    public void setServiIncluidos(ServicioAdicional[] serviIncluidos) {
        this.serviIncluidos = serviIncluidos;
    }

    public float getPrecioPromCerrado() {
        return precioPromCerrado;
    }

    public void setPrecioPromCerrado(float precioPromCerrado) {
        this.precioPromCerrado = precioPromCerrado;
    }

    @Override
    public float calcularMonto() 
    {
        return this.precioPromCerrado;
        
    }

    @Override
    public String obtenerDetalle() 
    {
        String detalle = "Paquete: " + nombre + "\nS/ " + precioPromCerrado;
        if (serviIncluidos != null && serviIncluidos.length > 0) {
        detalle = detalle + " | Incluye: ";
        for (int i = 0; i < serviIncluidos.length; i++) {
            if (serviIncluidos[i] != null) {
                detalle = detalle + serviIncluidos[i].getNombre();
                if (i < serviIncluidos.length - 1 && serviIncluidos[i + 1] != null) {
                    detalle = detalle + ", ";
                }
            }
        }
    }

    return detalle;
    }
    
    
    
}
