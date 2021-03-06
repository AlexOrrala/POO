/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

package Medidores;

import Plan.HorarioPico;
import Plan.PlanEnergia;
import Plan.Provincias;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Timer;
import java.util.TimerTask;
import java.util.Random;

/**
 * 
 * @author Sammy Guergachi <sguergachi at gmail.com>
 */
public class MedidorDigital extends Medidor{
    private LocalDateTime FechaToma;
    private double kilovatios;
    private static ArrayList<MedidorDigital> listasmedidor = new ArrayList<MedidorDigital>();
    public MedidorDigital(PlanEnergia plan,String direccion){
        super(plan, direccion);
        Timer timer= new Timer();
        TimerTask anadir= new TimerTask() {
            @Override
            public void run() {
                FechaToma=LocalDateTime.now();
                kilovatios=Math.floor(Math.random()*10);
            }
            
        };
        timer.schedule(anadir,0,1800000);
    }

    public static ArrayList<MedidorDigital> getListasmedidor() {
        return listasmedidor;
    }
    
    public static void agregarMedidor(MedidorDigital medidor){
        listasmedidor.add(medidor);
    }
    public LocalDateTime getFechaToma(){
        return FechaToma;
    }
    public double getKilovatios(){
        return kilovatios;
    }
    

    @Override
    public double calcularValorPagar(LocalDateTime fechaAccion) {
        double total=0;
        for (Lectura i: lectura){
            for(HorarioPico l:plan.getPicos()){
                if (l.getHorarioinicio().isBefore(i.getFechaToma().toLocalTime()) & l.getHorafin().isAfter(i.getFechaToma().toLocalTime())){
                    total=total+i.getKilovatios()*plan.getCostoK()*2;
                }
                else{
                    total=total+i.getKilovatios()*plan.getCostoK();
                }
                    
            }
        }
        return total;
    }
}
