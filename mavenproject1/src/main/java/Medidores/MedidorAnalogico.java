/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Medidores;

import Plan.PlanEnergia;
import Plan.Provincias;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.ArrayList;

/**
 *
 * @author samu_
 */
public class MedidorAnalogico extends Medidor {
    private LocalDateTime FechaToma;
    private double kilovatios;
    private static ArrayList<MedidorAnalogico> listasmedidor = new ArrayList<MedidorAnalogico>();
    public MedidorAnalogico(PlanEnergia plan,String direccion,LocalDateTime FechaToma, double kilovatios){
        super( plan, direccion);
        this.FechaToma=FechaToma;
        this.kilovatios=kilovatios;
    }

    @Override
    public double calcularValorPagar(LocalDateTime fechaAccion) {
       Lectura anadida=new Lectura(FechaToma,kilovatios);
       lectura.add(anadida);
       ultima_cobrada = fechaAccion;
       double costo=kilovatios*plan.getCostoK();
       return costo;
    }
    
    public static void agregarMedidor(MedidorAnalogico medidor){
        listasmedidor.add(medidor);
    }

    public double getKilovatios() {
        return kilovatios;
    }
    public LocalDateTime getFechaToma(){
        return FechaToma;
    }
    
    public static ArrayList<MedidorAnalogico> getListasmedidor() {
        return listasmedidor;
    }

    public LocalDateTime getFechaToma() {
        return FechaToma;
    }
    

    
    
}
/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
