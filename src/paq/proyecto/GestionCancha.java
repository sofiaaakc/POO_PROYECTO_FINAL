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
        arreglo = new Cancha[3];
        conta = 0;
    }
    
    public void Ingresar(Cancha ref)
    {
        if(conta<arreglo.length)
        {
            arreglo[conta] = ref;
            conta++;
        }
        else
        {
            System.out.println("Error. No hay espacio");
        }
    }
    
    public int BuscarPos(int codigo) 
    {
        for (int i = 0; i < conta; i++) {
            if (arreglo[i].getCodigo()== codigo) 
            {
                return i;
            }
        }
        return -1;
    }


    public Empleado buscarporDni(int dni) {
        int pos = buscarPosPorDni(dni);
        if (pos == -1) {
            return null;
        }
        return lista[pos];
    }

    public boolean Modificar(int dni, String nom, String apell, String usuario, String contraseña) {
        int pos = buscarPosPorDni(dni);
        if (pos == -1) {
            return false;
        }

        int posUsuario = buscarPosPorUsuario(usuario);
        if (posUsuario != -1 && posUsuario != pos) {
            return false;
        }

        Empleado emp = lista[pos];
        emp.setNom(nom);
        emp.setApell(apell);
        emp.setUsuario(usuario);
        emp.setContraseña(contraseña);
        return true;
    }

    public boolean EliminarEmpleado(int dni) {
        int pos = buscarPosPorDni(dni);
        if (pos == -1) {
            return false;
        }
        for (int i = pos; i < conta - 1; i++) {
            lista[i] = lista[i + 1];
        }
        lista[conta - 1] = null;
        conta--;
        return true;
    }

    public Empleado[] getLista() {
        return lista;
    }

    public int getConta() {
        return conta;
    }
}
