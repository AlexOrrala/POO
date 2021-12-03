
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
import java.util.Random;

/**
 *
 * @author samu_
 */
public abstract class Medidor {
    private String codigo;
    private PlanEnergia plan;
    private String direccion;
    private ArrayList<Lectura> lectura;
    private LocalDate ultima_cobrada;
    private static ArrayList<String> codesmedidores= new ArrayList<>();
    public String generarCodigo(){
        char[] voca = {'a','b','c','d','e','f','g','h','i','j','k','l','m','n','ñ','o','p','q','r','s','t','u','v','w','x','y','z'};
        String codigoa="";
        Random randon = new Random();
        int cantidad = 0;
        int comprobadorletras =0;
        int comprobadordigitos =0;
        do{
            
        if(codigoa.length() == 8&& (comprobadordigitos==0 || comprobadorletras==0)){
            cantidad = 0;
            comprobadorletras=0;
            comprobadordigitos=0;
            codigoa = "";
        }
        if(codigoa.length()<5){
            
        
        if((randon.nextInt(10)%2) ==0){
            int len;
            len = voca.length;
            codigoa += voca[randon.nextInt(len)];
            comprobadorletras = 2;
        }else{
            codigoa += randon.nextInt(9);
            comprobadordigitos= 2;
            }
        }
        cantidad++;
        }while(cantidad<6 );
        System.out.println(codigoa);
        int randon_n = 0;
        return codigoa;
    }
    public Medidor(PlanEnergia Plan,String direccion){
        this.plan=plan;
        this.direccion=direccion;
        ultima_cobrada=LocalDate.now();
        do{
            codigo=generarCodigo();
        }while(codesmedidores.contains(codigo));
        codesmedidores.add(codigo);
        lectura=new ArrayList<>();
    }
    public abstract double calcularValorPagar(LocalDateTime fechaAccion);
    
}