/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

package Main;
import Medidores.*;
import Plan.*;
import Usuarios.*;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.Scanner;

/**
 * 
 * @author Sammy Guergachi <sguergachi at gmail.com>
 */
public class main {
    
    public static void main(String[] args){
        Inicializarvalores();
        int menu0=0;
        Scanner sc = new Scanner(System.in);
        do{
            System.out.println("1)Ingresar.");
            System.out.println("2)Salir.\n");
            menu0 = sc.nextInt();
        switch(menu0){
            case 1:
                System.out.println("xd");
                break;
        }
        }while(menu0!=2);
        
    }
    
    public static void Inicializarvalores(){
        ArrayList<Administrador> Admins = new ArrayList<Administrador>();
        ArrayList<Operario> Operarios = new ArrayList<Operario>();
        Admins.add(new Administrador("admin", "superadmin"));
        Operarios.add(new Operario("operario1", "contraseña1"));
        Operarios.add(new Operario("operario2", "contraseña2"));
        ArrayList<Provincias> provincias1 = new ArrayList<Provincias>();
        provincias1.add(Provincias.Azuay);
        provincias1.add(Provincias.Guayas);
        provincias1.add(Provincias.Galápagos);
        HorarioPico horarios = new HorarioPico(LocalTime.of(10, 0), LocalTime.of(12,0));
        ArrayList<HorarioPico> horaspicos= new ArrayList<HorarioPico>();
        PlanEnergia.Agregarplan(new PlanEnergia("Plan1",5.5,500.0,provincias1,horaspicos));
        PlanEnergia.Agregarplan(new PlanEnergia("Plan2",4.5,300.0,provincias1,horaspicos));
        Abonado.agregarAbonado(new Abonado("Abonado1",Administrador.generarContraseña()));
        Abonado.agregarAbonado(new Abonado("Abonado2",Administrador.generarContraseña()));
        int contador =0;
        for(Abonado c: Abonado.getAbonado()){
            if(contador==0){
            c.agregarmedidor(new MedidorAnalogico(PlanEnergia.getListas().get(0),"direccion",LocalDateTime.now(),210.0));
            c.agregarmedidor(new MedidorDigital(PlanEnergia.getListas().get(1),"direccion2"));
            }else{
            c.agregarmedidor(new MedidorAnalogico(PlanEnergia.getListas().get(0),"direccion3",LocalDateTime.now(),120));
            }
            contador++;
        }
        //Operarios.get(0).registrarmedicion(Medidor.getCodesmedidores().get(0),120.0);
        //Operarios.get(0).registrarmedicion(Medidor.getCodesmedidores().get(0),100.0);
    }

}
