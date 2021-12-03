/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

package Plan;

import Medidores.*;
import Usuarios.*;
import java.time.LocalDateTime;
import java.util.ArrayList;

/**
 * 
 * @author Sammy Guergachi <sguergachi at gmail.com>
 */
public class SistemaFacturacion {
    private Medidor medidor;
    private LocalDateTime fecha_emision;
    private Lectura anterior;
    private Lectura actual;
    private int dias_fact;
    private double consumokv;
    private double Cargofijo;
    private String formatofac;
    private double totalpagar;
    private String codigofac;
    private static ArrayList<SistemaFacturacion> facturas = new ArrayList<SistemaFacturacion>();

    public SistemaFacturacion(Medidor medidor, LocalDateTime fecha_emision, Lectura anterior, Lectura actual, int dias_fact, double consumokv, double Cargofijo, double totalpagar) {
        this.medidor = medidor;
        this.fecha_emision = fecha_emision;
        this.anterior = anterior;
        this.actual = actual;
        this.dias_fact = dias_fact;
        this.consumokv = consumokv;
        this.Cargofijo = Cargofijo;
        this.totalpagar = totalpagar;
        int cont=0;
        
        do{
            codigofac="";
            for(int i=0; i<8;i++){
                codigofac=codigofac+ (Math.floor(Math.random()*9));
            }
            for (SistemaFacturacion l:facturas){
                if (l.codigofac.equals(codigofac)){
                    cont=1;
                }
            }
        }while(cont==1);
    }

    
    
    public static void aregarfactura(SistemaFacturacion factura){
        facturas.add(factura);
    }

    public void setFormatofac(String formatofac) {
        this.formatofac = formatofac;
    }
    
    public String toString(){
        return formatofac;
    }
    public String getCodigofac(){
        return codigofac;
    }
    public LocalDateTime getFecha_emision(){
        return fecha_emision;
    }
    
    
    
    
    public Medidor getMedidor() {
        return medidor;
    }


    public Lectura getAnterior() {
        return anterior;
    }

    public Lectura getActual() {
        return actual;
    }

    public static ArrayList<SistemaFacturacion> getFacturas() {
        return facturas;
    }
    public int getDias_fact(){
        return dias_fact;
    }
    public double getConsumokv(){
        return consumokv;
    }
    public double getCargofijo(){
        return Cargofijo;
    }
    public double getTotalpagar(){
        return totalpagar;
    };

    
    
}
