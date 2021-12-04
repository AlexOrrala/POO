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
    private static ArrayList<Administrador> Admins = new ArrayList<Administrador>();
    private static ArrayList<Operario> Operarios = new ArrayList<Operario>();
    public static void main(String[] args){
        int menu0=0;
        Scanner sc = new Scanner(System.in);
        do{
            System.out.println("1)Iniciar Sesión.");
            
            System.out.println("2)Salir.\n");
            menu0 = sc.nextInt();
        switch(menu0){
            case 1:
                Login();
                break;
        }
        }while(menu0!=2);
        
    }

    private static void Login() {        
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
        Abonado.agregarAbonado(new Abonado("Abonado1","1234"));
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
        Operarios.get(0).registrarmedicion(Medidor.getCodesmedidores().get(0),120.0);
        Operarios.get(0).registrarmedicion(Medidor.getCodesmedidores().get(0),100.0);
        
        
        
        Scanner sc = new Scanner(System.in);
        String usuario,contrasena;
        System.out.println("Usuario:");
        usuario = sc.nextLine();
        System.out.println("Contraseña:");
        contrasena = sc.nextLine();
        ob_Usuarios(usuario, contrasena);
        
    }
    private static void ob_Usuarios(String nombre,String contrasenia){
        ArrayList<String> listaf= new ArrayList<String>();
        boolean inicio = false;
        for(Abonado c: Abonado.getAbonado()){
            if(c.getNombre().equals(nombre) && c.getContrasenia().equals(contrasenia)){
            inicio = true;
        }
            listaf.add(c.getNombre());
       }
        for(Administrador c: Admins){
            if(c.getNombre().equals(nombre) && c.getContrasenia().equals(contrasenia)){
                inicio = true;
                Admin(c);
        }
       }
        for(Operario c: Operarios){
            if(c.getNombre().equals(nombre) && c.getContrasenia().equals(contrasenia)){
                inicio = true;
        }
       }
        if(inicio == false){
            System.out.println("Error el usuario y contraseña no coinciden con ninguna cuenta.");
        }
    }

    private static void Admin(Administrador c) {
        int menu=0;
        do{
            switch(menu){
                case 1:
                    c.RegistrarPlan();
                    break;
            }
        }while(menu==0);
    }

}
