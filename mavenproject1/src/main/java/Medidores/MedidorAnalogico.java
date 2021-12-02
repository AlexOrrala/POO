/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Medidores;

import java.time.LocalDateTime;

/**
 *
 * @author samu_
 */
public class MedidorAnalogico extends Medidor {
    private LocalDateTime FechaToma;
    private double kilovatios;
    public MedidorAnalogico(LocalDateTime ultimamed,int Lecturaa){
        super();
    }

    @Override
    public double calcularValorPagar(LocalDateTime fechaAccion) {
       return 0;
    }
    
    
}
/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */