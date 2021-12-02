/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Usuarios;

import java.time.LocalDateTime;
import java.util.ArrayList;

/**
 *
 * @author samu_
 */
public class Plan {
    private String nombre;
    private double costo;
    private ArrayList<Provincias> provincia;
    private double cargoBase;
    private ArrayList<Integer> horaspico;
    public Plan(String nombre, double costo,ArrayList<Provincias> provincia,double cargoBase, ArrayList<Integer> horaspico){
        this.nombre=nombre;
        this.costo=costo;
        this.provincia=provincia;
        this.cargoBase=cargoBase;
        this.horaspico=horaspico;
    }
    public String getNombre(){
        return nombre;
    }
    public double getCosto(){
        return costo;
    }
    public ArrayList<Provincias> getProvincia(){
        return provincia;
    }
    public double getCargoBase(){
        return cargoBase;
    }
    public ArrayList<Integer> getHoraspico(){
        return horaspico;
    }
}
