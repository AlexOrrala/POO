
/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Medidores;

import Plan.PlanEnergia;
import Plan.Provincias;
import Usuarios.*;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.ArrayList;

/**
 *
 * @author samu_
 */
public abstract class Medidor {
    private String codigo;
    private PlanEnergia plan;
    private String direccion;
    private ArrayList<Lectura> lectura;
    private LocalDate ultima_cobrada;
    private Provincias prov;
    
    public Medidor(String codigo,PlanEnergia plan,String direccion,LocalDate ultima_cobrada,Provincias prov){
        lectura = new ArrayList<Lectura>();
    }
    public abstract double calcularValorPagar(LocalDateTime fechaAccion);
    
}