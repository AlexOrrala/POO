/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

package Usuarios;

import Plan.HorarioPico;
import Plan.PlanEnergia;
import Plan.Provincias;
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
    
    public void RegistrarPlan(String nombreplan,Double costokv, ArrayList<Provincias> provincias, ArrayList<HorarioPico> horas,ArrayList<PlanEnergia> planactual){
        int x=0;
        for(PlanEnergia c : planactual){
            if(c.getNombre()==nombreplan){
                x = 5;
            }
        }
        if(x!=5){
        PlanEnergia plan = new PlanEnergia(nombreplan,costokv,provincias,horas);
        planactual.add(plan);
        }
    }
    public void RegistrarMedidor(String n_cedula,ArrayList<Abonado> abonados){
        int x = 0;
        Scanner sc = new Scanner(System.in);
        for(Abonado c: abonados){
            if(c.getNombre() == n_cedula){
                x = 5;
            }
        }
        if(x!=5){
            String numero="";
            String direccion="";
            String contraseña ="";
            String tipo ="";
            System.out.println("Ingrese numero de cedula");
            numero = sc.nextLine();
            contraseña = generarContraseña();
            System.out.println("Ingrese dirección:");
            direccion = sc.nextLine();
            System.out.println("Ingrese tipo del medidor:");
            System.out.println("a)Analógico\nb)Digital");
            tipo = sc.nextLine();
        }
    }
    public String generarContraseña(){
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
        System.out.println(contraseña);
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
