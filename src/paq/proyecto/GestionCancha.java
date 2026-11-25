/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package paq.proyecto;

/**
 *
 * @author aleja
 */
public class GestionCancha 

{
    private Cancha[] arreglo;
    private int conta;

    public GestionCancha() 
    {
        arreglo = new Cancha[30];
        conta = 0;
    }

    public Cancha[] getArreglo() {
        return arreglo;
    }

    public void setArreglo(Cancha[] arreglo) {
        this.arreglo = arreglo;
    }

    public int getConta() {
        return conta;
    }

    public void setConta(int conta) {
        this.conta = conta;
    }
    
    
   

    public boolean Ingresar(Cancha ref) 
    {
        if (ref == null) 
        {
            return false;
        }
        if (conta < arreglo.length) 
        {
            if (BuscarPosPorCodigo(ref.getCodigo()) != -1) 
            {
                return false; 
            }
            arreglo[conta] = ref;
            conta++;
            return true;
        }
        return false; 
    }

    public int BuscarPosPorCodigo(int codigo) 
    {
        for (int i = 0; i < conta; i++) 
        {
            if (arreglo[i].getCodigo()== codigo) 
            {
                return i;
            }
        }
        return -1;
    }
    
    public Cancha buscarCanchaCodigo(int codigo)
    {
        int pos = BuscarPosPorCodigo(codigo);
        if(pos == -1)
        {
            return null;
        }
        return arreglo[pos];
    }

    public boolean Modificar(int codigo, String nombreNuevo, float tarifabaseNueva, String estadoNuevo, int horarioNuevo)
    {
        int pos = BuscarPosPorCodigo(codigo);
        if(pos == -1)
        {
            return false;
        }
        
        Cancha cancha = arreglo[pos];
        cancha.setNombre(nombreNuevo);
        cancha.setTarifaBaseXHr(tarifabaseNueva);
        cancha.setEstado(estadoNuevo);
        cancha.setHorario(horarioNuevo);
        
        return true;
    }
    
    public boolean Eliminar(int codigo)
    {
        int pos = BuscarPosPorCodigo(codigo);
        if(pos == -1)
        {
            return false;
        }
        
        for(int i = pos; i < conta - 1; i++)
        {
            arreglo[i] = arreglo[i+1];
        }
        
        arreglo[conta - 1] = null;
        conta = conta - 1;
        return true;
    }

    
}
