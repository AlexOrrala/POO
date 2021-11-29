/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Usuarios;

import java.util.ArrayList;

/**
 *
 * @author samu_
 */
public class Plan {
    private String nombre;
    private double costo;
    private ArrayList<Provincias> provincia;
    public Plan(String nombre, double costo,ArrayList<Provincias> provincia){
        this.nombre=nombre;
        this.costo=costo;
        this.provincia=provincia;
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
}
