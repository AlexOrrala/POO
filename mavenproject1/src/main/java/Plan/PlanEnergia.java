
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
    private double cargob;
    private static ArrayList<PlanEnergia> listas = new ArrayList<PlanEnergia>();
    public PlanEnergia(String nombre, double costoK,double cargob,ArrayList<Provincias> provincia,ArrayList<HorarioPico> picos){
        this.nombre=nombre;
        this.costoK=costoK;
        this.provincia=provincia;
        this.picos = picos;
        this.cargob=cargob;
    }

    public static void Agregarplan(PlanEnergia plan){
        listas.add(plan);
    }
    public static ArrayList<PlanEnergia> getListas() {
        return listas;
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
    public ArrayList<HorarioPico> getPicos(){
        return picos;
    }
    public double getCargob(){
        return cargob;
    }
        
}
/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */