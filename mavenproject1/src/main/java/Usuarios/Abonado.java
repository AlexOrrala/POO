/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

package Usuarios;

import Medidores.Medidor;
import Plan.PlanEnergia;
import java.util.ArrayList;

/**
 * 
 * @author Sammy Guergachi <sguergachi at gmail.com>
 */
public class Abonado extends Usuario{
    private String correo;
    private ArrayList<Medidor> listasmedidor;
    private static ArrayList<Abonado> abonado = new ArrayList<Abonado>();
    public Abonado(String nombre, String contrasenia) {
        super(nombre, contrasenia);
        listasmedidor = new ArrayList<Medidor>();
    }
    public void agregarmedidor(Medidor medidor){
        listasmedidor.add(medidor);
    }
    public String mensaje(){
    return "Usuario"+super.getNombre()+"\nContraseña:"+super.getContrasenia();
    }

    public static ArrayList<Abonado> getAbonado() {
        return abonado;
    }
    public static void agregarAbonado(Abonado abo){
        abonado.add(abo);
    }
    
}
