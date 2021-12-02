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
 * @author Sammy Guergachi <sguergachi at gmail.com>
 */
public class MedidorDigital extends Medidor{
    private LocalDateTime FechaToma;
    private double kilovatios;
    public MedidorDigital(String codigo,PlanEnergia plan,String direccion,LocalDate ultima_cobrada,Provincias prov){
        super( codigo, plan, direccion, ultima_cobrada, prov);
    }

    @Override
    public double calcularValorPagar(LocalDateTime fechaAccion) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
}
