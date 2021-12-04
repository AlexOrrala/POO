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
import java.sql.Time;
import java.time.LocalDateTime;
import java.time.LocalTime;
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
    
    public void RegistrarPlan(){
        int x=0,comprueba=0,confirmar=2;
        LocalTime Inicio,Fin;
        double cargo=0,costokv=0;
        ArrayList<Provincias> listaprov = new ArrayList<Provincias>();
        ArrayList<HorarioPico> horariospico = new ArrayList<HorarioPico>();
        Scanner sc = new Scanner(System.in);
        String nombreplan,confirmarfecha;
        System.out.println("Ingrese nombre del plan:");
        nombreplan = sc.nextLine();
        
        for(PlanEnergia c : PlanEnergia.getListas()){
            if(c.getNombre()==nombreplan){
                x = 5;
            }
        }
        if(x==5){
            
            System.out.println("Ingrese Cargo:");
            do{
                cargo = sc.nextDouble();
            }while(cargo ==0);
            System.out.println("Ingrese Costo Kilovatio:");
            do{
                costokv = sc.nextDouble();
            }while(cargo ==0);
            do{
                System.out.println("Ingrese:\n0)salir\n1)Azuay\n2)Bolívar\n3)Cañar\n4)Carchi\n5)Chimborazo\n6)Cotopaxi\n7)ElOro\n8)Esmeraldas\n9)Galápagos\n10)Guayas\n11)Imbabura\n12)Loja\n13)LosRios\n14)Manabí\n15)MoronaSantiago\n16)Napo\n17)Orellana\n18)Pastaza\n19)Pichincha\n20)SantaElena\n21)SantoDomingodelosTsáchilas\n22)Sucumbíos\n23)Tungurahua\n24)ZamoraChinchipe");
                
                comprueba =sc.nextInt();
                if(x>0&& x<=24){
                listaprov.add(Provincias.values() [comprueba-1]);
                }
            }while(comprueba!=0);
            do{
            do{
                int houri=0,min1=0,min2=0,hourf=0;
                
                do{
                    System.out.println("Ingrese horas:");                
                    houri = sc.nextInt();
                }while(houri >0 && houri<=24);
                do{
                    System.out.println("Ingrese min:");  
                    min1 = sc.nextInt();
                }while(min1 >0 && min1<60);
                Inicio = LocalTime.of(houri, min1);
                
                do{
                    System.out.println("Ingrese horas:");                
                    hourf = sc.nextInt();
                }while(hourf >0 && hourf<=24);
                do{
                    System.out.println("Ingrese min:");  
                    min2 = sc.nextInt();
                }while(min2 >0 && min2<60);
                Fin = LocalTime.of(hourf, min2);
                if(houri<hourf){
                    confirmar =0;
                }else{
                    if(min1<min2){
                        confirmar=0;
                    }
                }
                
            }while(confirmar!=0);
                HorarioPico h1 = new HorarioPico(Inicio, Fin);
                horariospico.add(h1);
                System.out.println("Desea ingresar otra fecha(Y/N)");
                confirmarfecha = sc.nextLine();
            }while(confirmarfecha.equals("Y"));
            
            PlanEnergia plan = new PlanEnergia(nombreplan,cargo,costokv,listaprov,horariospico);
            PlanEnergia.Agregarplan(plan);
        }else{
            System.out.println("El Plan ya existe");
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
