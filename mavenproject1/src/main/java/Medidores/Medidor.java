/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Medidores;

import Usuarios.Plan;
import java.time.LocalDateTime;

/**
 *
 * @author samu_
 */
public abstract class Medidor {
    private String codigo;
    private static int numdeserie=000;
    protected Plan plan;
    public Medidor(Plan plan){
        codigo="Med"+numdeserie;
        numdeserie++;
        this.plan=plan;
    }
    public abstract double calcularValorPagar(LocalDateTime fechaAccion);
    
}