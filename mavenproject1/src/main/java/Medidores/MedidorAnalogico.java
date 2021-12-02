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
public class MedidorAnalogico extends Medidor {
    private LocalDateTime ultimamed;
    private double Lecturaa;
    public MedidorAnalogico(Plan plan,LocalDateTime ultimamed,double Lecturaa){
        super(plan);
        this.ultimamed=ultimamed;
        this.Lecturaa=Lecturaa;
    }
    public LocalDateTime getUltimamed(){
        return ultimamed;
    }
    public double getLectuaraa(){
        return Lecturaa;
    }
    public void setUltimamed(LocalDateTime ultimamed ){
        this.ultimamed=ultimamed;
    }
    public void setLecturaa(int Lecturaa){
        this.Lecturaa=Lecturaa;
    }

    @Override
    public double calcularValorPagar(LocalDateTime fechaAccion) {
        ultimamed=fechaAccion;
        double pagar=Lecturaa*plan.getCosto();
        return pagar;
    }
    
    
}
