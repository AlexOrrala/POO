/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Medidores;

import Plan.PlanEnergia;
import Plan.Provincias;
import java.time.LocalDate;
import java.time.LocalDateTime;

/**
 *
 * @author samu_
 */
public class MedidorAnalogico extends Medidor {
    private LocalDateTime FechaToma;
    private double kilovatios;
    public MedidorAnalogico(String codigo,PlanEnergia plan,String direccion,LocalDate ultima_cobrada,Provincias prov){
        super( codigo, plan, direccion, ultima_cobrada, prov);
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