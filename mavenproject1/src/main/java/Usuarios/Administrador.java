/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

package Usuarios;

import Medidores.Medidor;
import Medidores.MedidorAnalogico;
import Medidores.MedidorDigital;
import Plan.HorarioPico;
import Plan.PlanEnergia;
import Plan.Provincias;
import Plan.SistemaFacturacion;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Random;
import java.util.Scanner;

/**
 * 
 * @author Sammy Guergachi <sguergachi at gmail.com>
 */
public class Administrador extends Usuario{
    public Administrador(String nombre, String contrasenia) {
        super(nombre, contrasenia);
    }
    
    public void RegistrarPlan(String nombreplan,Double cargo,Double costokv, ArrayList<Provincias> provincias, ArrayList<HorarioPico> horas){
        int x=0;
        for(PlanEnergia c : PlanEnergia.getListas()){
            if(c.getNombre()==nombreplan){
                x = 5;
            }
        }
        if(x==5){
        PlanEnergia plan = new PlanEnergia(nombreplan,cargo,costokv,provincias,horas);
        PlanEnergia.Agregarplan(plan);
        }
    }
    public void RegistrarMedidor(String n_cedula){
        int x = 0;
        Scanner sc = new Scanner(System.in);
        for(Abonado c: Abonado.getAbonado()){
            if(c.getNombre() == n_cedula){
                x = 5;
            }
        }
        if(x!=5){
            String nombre_plan="";
            String direccion="";
            String contraseña ="";
            ArrayList<String> planes = new ArrayList<String>();
            String tipo ="";
            contrasenia = generarContraseña();
            System.out.println("Ingrese dirección:");
            direccion = sc.nextLine();
            System.out.println("Ingrese letra del tipo del medidor:");
            
            do{
            System.out.println("a)Analógico\nb)Digital");
            tipo = sc.nextLine();
            tipo = tipo.toLowerCase();
            
            }while(!(tipo.equals("a") || tipo.equals("b")));
            for(PlanEnergia c: PlanEnergia.getListas()){
                planes.add(c.getNombre());
            }
            do{
            System.out.println("Ingrese nombre del Plan:");
            nombre_plan = sc.nextLine();
            
            }while(!(planes.contains(nombre_plan)));
            int indice = planes.indexOf(nombre_plan);
            if(tipo.equals("a")){
                MedidorAnalogico m = new MedidorAnalogico(PlanEnergia.getListas().get(indice), direccion,LocalDateTime.now(),0.00);
                MedidorAnalogico.agregarMedidor(m);
                Abonado abo = new Abonado(n_cedula, contrasenia);
                
            }else{
                MedidorDigital m = new MedidorDigital(PlanEnergia.getListas().get(indice), direccion);
                MedidorDigital.agregarMedidor(m);
                Abonado abo = new Abonado(n_cedula, contrasenia);
            }
        }
    }
    public void lecturas(LocalDateTime fechainicio,LocalDateTime fechafin,String codigo1,String codigo2,int valor1,int valor2){
        LocalDateTime fechacambia = fechainicio;
        
        
        Random randon = new Random();
        int valorsuma= valor1;
        System.out.println("Fecha de inicio:" + fechainicio);
        System.out.println("Hay dos medidores inteligentes");
        System.out.println("Lecturas para medidor con código"+codigo1+"Con valor actual:" +valor1);
        do{
            
            fechacambia = fechacambia.plusMinutes(10);
            System.out.println(codigo1+", "+fechacambia +", "+valorsuma);
            valorsuma += randon.nextInt(10);
        }while(!(fechacambia.equals(fechafin)));
        System.out.println("Lecturas para medidor con código"+codigo2+"Con valor actual:" +valor2);
        fechacambia = fechainicio;
        valorsuma= valor2;
        do{
            fechacambia = fechacambia.plusMinutes(10);
            System.out.println(codigo2+", "+fechacambia +", "+valorsuma);
            valorsuma += randon.nextInt(10);
        }while(!(fechacambia.equals(fechafin)));
        
    }
    
    public void Facturacion(){
        for(MedidorAnalogico c : MedidorAnalogico.getListasmedidor()){
        String cadena;
        cadena = "Analogico"+"\n";
        cadena = "Fecha de emision: "+LocalDateTime.now()+"\n";
        cadena = "Código del medidor:" + c.getCodigo()+"\n";
        cadena = "Nombre del plan:" + c.getPlan().getNombre()+"\n";
        cadena = "Fecha lectura anterior:" + c.getUltima_cobrada()+"\n";
        cadena = "Fecha lectura actual:" + c.getLectura().get(c.getLectura().size()).getFechaToma()+"\n";
        LocalDateTime hoy = LocalDateTime.now();
        int dias = hoy.getDayOfYear() - c.getUltima_cobrada().getDayOfYear();
        cadena = "Número de dias:" + dias+"\n";
        cadena = "Lectura Anterior:" + c.getLectura().get(c.getLectura().size() -1).getKilovatios()+"\n";
        cadena = "Lectura Actual:" + c.getLectura().get(c.getLectura().size()).getKilovatios()+"\n";
        cadena = "Consumo kilovatios:" + c.getKilovatios()+"\n";
        cadena = "Cargo Fijo del Plan:" + c.getPlan().getCargob()+"\n";
        cadena = "Totalpagar" + c.calcularValorPagar(hoy)+"\n";
            SistemaFacturacion s = new SistemaFacturacion(c, hoy, c.getLectura().get(c.getLectura().size() -1),c.getLectura().get(c.getLectura().size()) , dias,c.getKilovatios(), c.getPlan().getCargob(), c.calcularValorPagar(hoy));
            s.setFormatofac(cadena);
            SistemaFacturacion.aregarfactura(s);
            for(Abonado a: Abonado.getAbonado()){
               if(Abonado.Duenomedidor(c.getCodigo()).equals(a) ){
                   a.aregarfactura(s);
               }
            }
        }
        for(MedidorDigital c : MedidorDigital.getListasmedidor()){
        String cadena;
        cadena = "Digital"+"\n";
        cadena = "Fecha de emision: "+LocalDateTime.now()+"\n";
        cadena = "Código del medidor:" + c.getCodigo()+"\n";
        cadena = "Nombre del plan:" + c.getPlan().getNombre()+"\n";
        cadena = "Fecha lectura anterior:" + c.getUltima_cobrada()+"\n";
        cadena = "Fecha lectura actual:" + c.getLectura().get(c.getLectura().size()).getFechaToma()+"\n";
        LocalDateTime hoy = LocalDateTime.now();
        int dias = hoy.getDayOfYear() - c.getUltima_cobrada().getDayOfYear();
        cadena = "Número de dias:" + dias+"\n";
        cadena = "Lectura Anterior:" + c.getLectura().get(c.getLectura().size() -1).getKilovatios()+"\n";
        cadena = "Lectura Actual:" + c.getLectura().get(c.getLectura().size()).getKilovatios()+"\n";
        cadena = "Consumo kilovatios:" + c.getKilovatios()+"\n";
        cadena = "Cargo Fijo del Plan:" + c.getPlan().getCargob()+"\n";
        cadena = "Totalpagar" + c.calcularValorPagar(hoy)+"\n";
            SistemaFacturacion s = new SistemaFacturacion(c, hoy, c.getLectura().get(c.getLectura().size() -1),c.getLectura().get(c.getLectura().size()) , dias,c.getKilovatios(), c.getPlan().getCargob(), c.calcularValorPagar(hoy));
            SistemaFacturacion.aregarfactura(s);
            for(Abonado a: Abonado.getAbonado()){
               if(Abonado.Duenomedidor(c.getCodigo()).equals(a) ){
                   a.aregarfactura(s);
               }
            }
        }
        
    }
    
    public static String generarContraseña(){
        char[] voca = {'a','b','c','d','e','f','g','h','i','j','k','l','m','n','ñ','o','p','q','r','s','t','u','v','w','x','y','z'};
        String contraseña="";
        Random randon = new Random();
        int cantidad = 0;
        int comprobadorletras =0;
        int comprobadordigitos =0;
        do{
            
        if(contraseña.length() == 8&& (comprobadordigitos==0 || comprobadorletras==0)){
            cantidad = 0;
            comprobadorletras=0;
            comprobadordigitos=0;
            contraseña = "";
        }
        if(contraseña.length()<8){
            
        
        if((randon.nextInt(10)%2) ==0){
            int len;
            len = voca.length;
            contraseña += voca[randon.nextInt(len)];
            comprobadorletras = 2;
        }else{
            contraseña += randon.nextInt(9);
            comprobadordigitos= 2;
            }
        }
        cantidad++;
        }while(cantidad<9 );
        int randon_n = 0;
        do{
            
            randon_n = randon.nextInt(8);
            if(Character.isLetter(contraseña.charAt(randon_n))){
                contraseña = contraseña.replace(contraseña.charAt(randon_n), Character.toUpperCase(contraseña.charAt(randon_n) ));                
            }
            
        }while(!(Character.isUpperCase(contraseña.charAt(randon_n))));
        return contraseña;
    }
}
