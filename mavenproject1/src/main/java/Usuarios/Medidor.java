/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Usuarios;

import java.time.LocalDate;

/**
 *
 * @author samu_
 */
public abstract class Medidor {
    private String codigo;
    private static int numdeserie=000;
    public Medidor(){
        codigo="Med"+numdeserie;
        numdeserie++;
    }
    public abstract double calcularValorPagar(LocalDate fechaAccion);
    
}
