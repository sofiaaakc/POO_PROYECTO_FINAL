/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package paq.proyecto;

/**
 *
 * @author aleja
 */
//a
public class GestionServiciosAdic 
{
    private ServicioAdicional[] servAdic;
    private int contaS;
    private PaquetePromocional[] paquete;
    private int contaP;

    public GestionServiciosAdic() 
    {
        this.servAdic = new ServicioAdicional[50];
        this.contaS = 0;
        this.paquete = new PaquetePromocional[25];
        this.contaP = 0;
        
    }

    public ServicioAdicional[] getServAdic() {
        return servAdic;
    }

    public void setServAdic(ServicioAdicional[] servAdic) {
        this.servAdic = servAdic;
    }

    public int getContaS() {
        return contaS;
    }

    public void setContaS(int contaS) {
        this.contaS = contaS;
    }

    public PaquetePromocional[] getPaquete() {
        return paquete;
    }

    public void setPaquete(PaquetePromocional[] paquete) {
        this.paquete = paquete;
    }

    public int getContaP() {
        return contaP;
    }

    public void setContaP(int contaP) {
        this.contaP = contaP;
    }
    
    public int buscarPosPorCodigoServicio(int codigo)
    {
        for(int i = 0; i< contaS; i++)
        {
            if(servAdic[i] != null && servAdic[i].getCodigo() == codigo)
            {
                return i;
            }
        }
        return -1;
    }
    
    public ServicioAdicional buscarServicioPorCodigo(int codigo)
    {
        int pos = buscarPosPorCodigoServicio(codigo);
        if(pos == -1)
        {
            return null;
        }
        
        return servAdic[pos];
    }
    
    public boolean IngresarServicio(ServicioAdicional ref) 
    {
        if (ref == null) 
        {
            return false;
        }
        if (contaS < servAdic.length) 
        {
            if (buscarPosPorCodigoServicio(ref.getCodigo()) != -1) 
            {
                return false;
            }
            servAdic[contaS] = ref;
            contaS++;
            return true;
        }
        return false;
    }
    
    public boolean Modificar(int codigo, String nombreNuevo, float preciounitNuevo, int stockNuevo)
    {
        int pos = buscarPosPorCodigoServicio(codigo);
        if(pos == -1)
        {
            return false;
        }
        
        servAdic[pos].setNombre(nombreNuevo);
        servAdic[pos].setPrecioUnit(preciounitNuevo);
        servAdic[pos].setStockDispo(stockNuevo);
        return true;
    }
    
    public boolean EliminarServ(int codigo) 
    {
        int pos = buscarPosPorCodigoServicio(codigo);
        if (pos == -1) 
        {
            return false;
        }
        for (int i = pos; i < contaS - 1; i++) 
        {
            servAdic[i] = servAdic[i + 1];
        }
        servAdic[contaS - 1] = null;
        contaS--;
        return true;
    }
    
    public int buscarPosPorNombrePaquete(String nombre) 
    {
        if (nombre == null) 
        {
            return -1;
        }
        for (int i = 0; i < contaP; i++) 
        {
            if (paquete[i] != null && paquete[i].getNombre() != null
                    && paquete[i].getNombre().equalsIgnoreCase(nombre)) 
            {
                return i;
            }
        }
        return -1;
    }
    
    public PaquetePromocional buscarPaqPorNombre(String nombre) {
        int pos = buscarPosPorNombrePaquete(nombre);
        if (pos == -1) {
            return null;
        }
        return paquete[pos];
    }

    public boolean IngresarPaquete(PaquetePromocional ref) 
    {
        if (ref == null) 
        {
            return false;
        }
        if (contaP < paquete.length) 
        {
            if (buscarPosPorNombrePaquete(ref.getNombre()) != -1) 
            {
                return false;
            }
            paquete[contaP] = ref;
            contaP++;
            return true;
        }
        return false;
    }

    public boolean ModificarPaquete(String nombreActual, String nuevoNombre, ServicioAdicional[] nuevosServicios, float nuevoPrecioCerrado) {
        int pos = buscarPosPorNombrePaquete(nombreActual);
        if (pos == -1) 
        {
            return false;
        }
        paquete[pos].setNombre(nuevoNombre);
        paquete[pos].setServiIncluidos(nuevosServicios);
        paquete[pos].setPrecioPromCerrado(nuevoPrecioCerrado);
        return true;
    }

    public boolean EliminarPaquete(String nombre) 
    {
        int pos = buscarPosPorNombrePaquete(nombre);
        if (pos == -1) 
        {
            return false;
        }
        for (int i = pos; i < contaP - 1; i++) 
        {
            paquete[i] = paquete[i + 1];
        }
        paquete[contaP - 1] = null;
        contaP--;
        return true;
    }
    
    
}




