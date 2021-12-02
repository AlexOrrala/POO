/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Plan;

import java.sql.Time;
import java.util.ArrayList;

/**
 *
 * @author samu_
 */
public class PlanEnergia {
    private String nombre;
    private double costoK;
    private ArrayList<Provincias> provincia;
    private ArrayList<HorarioPico> picos;
    public PlanEnergia(String nombre, double costoK,ArrayList<Provincias> provincia,ArrayList<HorarioPico> picos){
        this.nombre=nombre;
        this.costoK=costoK;
        this.provincia=provincia;
        this.picos = picos;
    }
    public String getNombre(){
        return nombre;
    }
    public double getCostoK(){
        return costoK;
    }
    public ArrayList<Provincias> getProvincia(){
        return provincia;
    }
}
