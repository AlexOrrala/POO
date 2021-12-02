/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Medidores;

import Usuarios.Plan;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Timer;
import java.util.TimerTask;
import java.util.Random;
/**
 *
 * @author samu_
 */
public class MedidorInteligente extends Medidor {
    private ArrayList<LocalDateTime> antiguas=new ArrayList<>();
    private ArrayList<Double> kilovatios;
    public MedidorInteligente(Plan plan){
        super(plan);
    }
    
    public void iniciarconteo(){
        Timer timer= new Timer();
        TimerTask anadir= new TimerTask() {
            @Override
            public void run() {
                antiguas.add(LocalDateTime.now());
                kilovatios.add(Math.floor(Math.random()*10));
            }
        };
        timer.schedule(anadir,0,1800000);
        }
    @Override
    public double calcularValorPagar(LocalDateTime fechacambio){
        antiguas.add(LocalDateTime.now());
        kilovatios.add(Math.floor(Math.random()*10));
        double total=0;
        int i=0;
        for (LocalDateTime l: antiguas){
            if (plan.getHoraspico().contains(l.getHour())){
                total=total+kilovatios.get(i)*plan.getCosto()*2;
            }
            else{
                total=total+kilovatios.get(i)*plan.getCosto();
            }
            i=i+1;
        }
        return total;
    }
}
