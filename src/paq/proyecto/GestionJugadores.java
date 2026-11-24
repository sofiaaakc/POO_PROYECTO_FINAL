/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package paq.proyecto;

/**
 *
 * @author aleja
 */
public class GestionJugadores 
{

    private Jugador[] lista = new Jugador[100];

    private int conta = 0;

    public boolean IngresarJugador(Jugador jug) 
    {

        if (jug == null || conta >= 100) 
        {

            return false;

        }

        if (jug.getNom() == null || jug.getApell() == null || jug.getCorreo() == null || jug.getTel() <= 0 || jug.getDni() <= 0) 
        {

            return false;

        }

        if (buscarPosPorDni(jug.getDni()) != -1) 
        {

            return false;

        }

        tipojugador(jug);

        lista[conta++] = jug;

        return true;

    }

    public int buscarPosPorDni(int dni) 
    {

        for (int i = 0; i < conta; i++) 
        {

            if (lista[i].getDni() == dni) 
            {

                return i;

            }

        }

        return -1;

    }

    public Jugador buscarporDni(int dni) 
    {

        int pos = buscarPosPorDni(dni);

        if (pos == -1) 
        {

            return null;

        }

        return lista[pos];

    }

    public boolean Modificar(int dni, String nom, String apell, int tel, String correo) 
    {

        int pos = buscarPosPorDni(dni);

        if (pos == -1) 
        {

            return false;

        }

        if (nom == null || apell == null || correo == null || tel <= 0) 
        {

            return false;

        }

        Jugador jug = lista[pos];

        jug.setNom(nom);

        jug.setApell(apell);

        jug.setTel(tel);

        jug.setCorreo(correo);

        return true;

    }

    public boolean EliminarJugador(int dni) 
    {

        int pos = buscarPosPorDni(dni);

        if (pos == -1) 
        {

            return false;

        }

        for (int i = pos; i < conta - 1; i++) 
        {

            lista[i] = lista[i + 1];

        }

        lista[conta - 1] = null;

        conta--;

        return true;

    }

    public String tipojugador(Jugador jug) 
    {

        if (jug == null) 
        {

            return null;

        }

        jug.getTipoJugador();

        if (jug.getReserF() >= 5 && !(jug instanceof JugadorFrecuente)) 
        {

            JugadorFrecuente promovido = new JugadorFrecuente(jug.getTel(), jug.getReserF(), jug.getCorreo(), jug.getDni(), jug.getNom(), jug.getApell());

            int pos = buscarPosPorDni(jug.getDni());

            if (pos != -1) 
            {

                lista[pos] = promovido;

            }

            return promovido.getTipo();

        }

        return jug.getTipo();

    }

    public Jugador[] getLista() 
    {

        return lista;

    }

    public int getConta() 
    {

        return conta;

    }    
}
