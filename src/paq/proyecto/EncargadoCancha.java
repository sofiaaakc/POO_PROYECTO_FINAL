/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package paq.proyecto;

/**
 *
 * @author aleja
 */
public class EncargadoCancha extends Empleado
{

    public EncargadoCancha(String usuario, String contraseña, int dni, String nom, String apell) {
        super(usuario, contraseña, dni, nom, apell);
    }

    @Override
    public void determinarrol() {
        this.rol = "EncargadoCancha";
    }
    
    
}
